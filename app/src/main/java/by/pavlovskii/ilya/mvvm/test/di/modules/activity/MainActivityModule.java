package by.pavlovskii.ilya.mvvm.test.di.modules.activity;

import android.support.annotation.NonNull;

import by.mvvmwrapper.dagger.scope.ActivityScope;
import by.pavlovskii.ilya.mvvm.test.navigator.MainNavigator;
import by.pavlovskii.ilya.mvvm.test.viewmodel.MainViewModel;
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
@Module
public abstract class MainActivityModule {

    @Binds
    @ActivityScope
    abstract Navigator provideNavigator(@NonNull MainNavigator navigator);

    @Provides
    @ActivityScope
    static Class<MainViewModel> provideClass() {
        return MainViewModel.class;
    }

}
