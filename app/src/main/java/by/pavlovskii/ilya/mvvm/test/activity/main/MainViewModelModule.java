package by.pavlovskii.ilya.mvvm.test.activity.main;

import android.support.annotation.NonNull;
import android.util.Log;

import by.mvvmwrapper.dagger.scope.ActivityScope;
import by.pavlovskii.ilya.mvvm.test.fragments.timer.TimerSubComponent;
import by.pavlovskii.ilya.mvvm.test.navigator.MainNavigator;
import by.pavlovskii.ilya.mvvm.test.utils.DemoActivityFactory;
import by.pavlovskii.ilya.mvvm.test.viewmodel.SubcomponentViewModelFactory;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import ru.terrakok.cicerone.Navigator;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 24.11.2017<br>
 * Time: 17:39<br>
 * Project name: MVVMtest<br>
 * ===================================================================================<br>
 */
@Module(subcomponents = TimerSubComponent.class)
public abstract class MainViewModelModule {

    @Binds
    @ActivityScope
    abstract Navigator navigator(@NonNull MainNavigator navigator);

    @Provides
    @ActivityScope
    static MainViewData viewData() {
        return new MainViewData();
    }

    @Provides
    @ActivityScope
    static MainViewModel viewModel(@NonNull MainViewData viewData, @NonNull DemoActivityFactory demoActivityFactory,
                                   @NonNull SubcomponentViewModelFactory factory,
                                   @NonNull TimerSubComponent.Builder builder) {
        Log.d("MainViewModel", "provide");
        factory.addCreator(builder);
        return new MainViewModel(viewData, demoActivityFactory);
    }

}
