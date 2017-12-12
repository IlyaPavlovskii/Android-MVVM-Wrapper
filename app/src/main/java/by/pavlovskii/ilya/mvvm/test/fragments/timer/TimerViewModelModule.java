package by.pavlovskii.ilya.mvvm.test.fragments.timer;

import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import javax.inject.Named;
import javax.inject.Provider;

import by.mvvmwrapper.dagger.scope.FragmentScope;
import by.pavlovskii.ilya.mvvm.test.activity.main.MainViewModel;
import by.pavlovskii.ilya.mvvm.test.viewmodel.GeneralViewModelFactory;
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
    @Named("TimerFragmentViewModelProvider")
    @FragmentScope
    static ViewModelProvider.Factory viewModelProvider(@NonNull Provider<TimerViewModel> provider) {
        return new GeneralViewModelFactory<>(TimerViewModel.class, provider);
    }

}
