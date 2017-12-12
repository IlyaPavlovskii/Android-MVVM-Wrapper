package by.pavlovskii.ilya.mvvm.test.di.modules;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import javax.inject.Singleton;

import by.pavlovskii.ilya.mvvm.test.ui.activity.main.MainViewModel;
import by.pavlovskii.ilya.mvvm.test.ui.activity.yellow.YellowViewModel;
import by.pavlovskii.ilya.mvvm.test.di.ViewModelKey;
import by.pavlovskii.ilya.mvvm.test.ui.fragments.timer.TimerViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 08.12.2017<br>
 * Time: 3:33<br>
 * Project name: MVVMtest<br>
 * ===================================================================================<br>
 * //TODO Add description<br>
 * ===================================================================================<br>
 */
@Module
public abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel.class)
    abstract ViewModel bindMainViewModel(MainViewModel viewModel);

    @Binds
    @IntoMap
    @ViewModelKey(YellowViewModel.class)
    abstract ViewModel bindYellowViewModel(YellowViewModel viewModel);

    @Binds
    @IntoMap
    @ViewModelKey(TimerViewModel.class)
    abstract ViewModel bindTimerViewModel(TimerViewModel viewModel);

}