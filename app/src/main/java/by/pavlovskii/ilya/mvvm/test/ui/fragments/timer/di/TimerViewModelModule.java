package by.pavlovskii.ilya.mvvm.test.ui.fragments.timer.di;

import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import javax.inject.Named;
import javax.inject.Provider;

import by.mvvmwrapper.dagger.scope.FragmentScope;
import by.mvvmwrapper.utils.viewmodelproviders.ProviderViewModelProviderFactory;
import by.pavlovskii.ilya.mvvm.test.storage.Constants;
import by.pavlovskii.ilya.mvvm.test.ui.activity.main.MainViewModel;
import by.mvvmwrapper.utils.viewmodelproviders.GeneralViewModelFactory;
import by.pavlovskii.ilya.mvvm.test.ui.fragments.timer.TimerViewData;
import by.pavlovskii.ilya.mvvm.test.ui.fragments.timer.TimerViewModel;
import dagger.Module;
import dagger.Provides;

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
@FragmentScope
public abstract class TimerViewModelModule {

    @Provides
    @FragmentScope
    static TimerViewData viewData() {
        return new TimerViewData();
    }

    @Provides
    @FragmentScope
    static TimerViewModel viewModel(@NonNull TimerViewData viewData, @NonNull MainViewModel mainViewModel) {
        return new TimerViewModel(viewData, mainViewModel);
    }

    @Provides
    @FragmentScope
    @Named(Constants.Dagger.TIMER_VM_PROVIDER)
    static ViewModelProvider.Factory viewModelProvider(@NonNull Provider<TimerViewModel> provider) {
        return new ProviderViewModelProviderFactory<>(TimerViewModel.class, provider);
    }

}
