package by.pavlovskii.ilya.mvvm.test.di.modules.activity;

import android.support.annotation.NonNull;

import by.mvvmwrapper.dagger.scope.ActivityScope;
import by.mvvmwrapper.dagger.scope.FragmentScope;
import by.pavlovskii.ilya.mvvm.test.di.modules.fragment.TimerFragmentModule;
import by.pavlovskii.ilya.mvvm.test.fragments.TimerFragment;
import by.pavlovskii.ilya.mvvm.test.navigator.MainNavigator;
import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;
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
public interface MainActivityModule {

    @Binds
    @ActivityScope
    Navigator navigator(@NonNull MainNavigator navigator);

    @FragmentScope
    @ContributesAndroidInjector(modules = {TimerFragmentModule.class})
    TimerFragment timerFragment();

}
