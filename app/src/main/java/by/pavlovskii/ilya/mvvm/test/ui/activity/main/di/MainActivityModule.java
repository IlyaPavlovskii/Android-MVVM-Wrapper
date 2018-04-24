package by.pavlovskii.ilya.mvvm.test.ui.activity.main.di;

import android.support.annotation.NonNull;

import by.mvvmwrapper.dagger.scope.ActivityScope;
import by.pavlovskii.ilya.mvvm.test.navigator.MainNavigator;
import by.pavlovskii.ilya.mvvm.test.ui.activity.main.MainBindingAdapter;
import by.pavlovskii.ilya.mvvm.test.ui.activity.main.MainViewData;
import by.pavlovskii.ilya.mvvm.test.ui.activity.main.MainViewModel;
import by.pavlovskii.ilya.mvvm.test.utils.DemoActivityFactory;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import ru.terrakok.cicerone.Navigator;
import timber.log.Timber;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 08.12.2017<br>
 * Time: 16:18<br>
 * Project name: MVVMtest<br>
 * ===================================================================================<br>
 */
@Module
public abstract class MainActivityModule {

    @Binds
    @ActivityScope
    abstract Navigator navigator(MainNavigator navigator);

    @Provides
    @ActivityScope
    static MainViewModel viewModel(@NonNull MainViewData viewData,
                                   @NonNull DemoActivityFactory demoActivityFactory) {
        Timber.d("provide");
        return new MainViewModel(viewData, demoActivityFactory);
    }

//    @Provides
//    @ActivityScope
//    static MainBindingAdapter mainBindingAdapter() {
//        return new MainBindingAdapter();
//    }

}
