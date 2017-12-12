package by.pavlovskii.ilya.mvvm.test.fragments.timer;

import by.mvvmwrapper.dagger.scope.FragmentScope;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 07.12.2017<br>
 * Time: 18:43<br>
 * Project name: MVVMtest<br>
 * ===================================================================================<br>
 */
@Module
public abstract class TimerFragmentProvider {

    @FragmentScope
    @ContributesAndroidInjector(modules = TimerViewModelModule.class)
    abstract TimerFragment provideAboutFragmentFactory();

}