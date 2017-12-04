package by.pavlovskii.ilya.mvvm.test.di.modules;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import javax.inject.Singleton;

import by.mvvmwrapper.viewmodel.IViewModel;
import by.pavlovskii.ilya.mvvm.test.di.ViewModelKey;
import by.pavlovskii.ilya.mvvm.test.viewmodel.AppViewModelFactory;
import by.pavlovskii.ilya.mvvm.test.viewmodel.MainViewModel;
import by.pavlovskii.ilya.mvvm.test.viewmodel.TimerViewModel;
import by.pavlovskii.ilya.mvvm.test.viewmodel.YellowViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 07.11.16<br>
 * Time: 16:43<br>
 * Project name: MVVMtest<br>
 * ===================================================================================<br>
 * {@link IViewModel} module<br>
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

    @Binds
    @Singleton
    abstract ViewModelProvider.Factory bindViewModelFactory(AppViewModelFactory factory);

}
