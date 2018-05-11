package by.pavlovskii.ilya.mvvm.test.ui.fragments.timer.di;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.NonNull;

import by.mvvmwrapper.dagger.map.ViewModelKey;
import by.mvvmwrapper.dagger.scope.FragmentScope;
import by.mvvmwrapper.viewmodel.BaseViewModel;
import by.pavlovskii.ilya.mvvm.test.di.ViewModelStorageKey;
import by.pavlovskii.ilya.mvvm.test.ui.activity.main.MainActivity;
import by.pavlovskii.ilya.mvvm.test.ui.activity.main.MainViewModel;
import by.pavlovskii.ilya.mvvm.test.ui.fragments.timer.TimerViewData;
import by.pavlovskii.ilya.mvvm.test.ui.fragments.timer.TimerViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

import javax.inject.Named;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 08.12.2017<br>
 * Time: 17:10<br>
 * Project name: MVVMtest<br>
 * ===================================================================================<br>
 */
@Module
public abstract class TimerViewModelModule {

    @Provides
    @FragmentScope
    static TimerViewData viewData() {
        return new TimerViewData();
    }

    @Binds
    @IntoMap
    @ViewModelKey(TimerViewModel.class)
    abstract BaseViewModel bindTimerViewModel(@NonNull TimerViewModel viewModel);

    @Provides
    @ViewModelStorageKey
    static MainViewModel provideMainViewModel(@NonNull MainActivity activity,
                                              @NonNull ViewModelProvider.Factory factory) {
        return ViewModelProviders
                .of(activity, factory)
                .get(MainViewModel.class);
    }

}
