package by.pavlovskii.ilya.mvvm.test.fragments.timer;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import javax.inject.Named;

import by.mvvmwrapper.dagger.scope.FragmentScope;
import by.pavlovskii.ilya.mvvm.test.activity.main.MainViewModel;
import dagger.Module;
import dagger.Provides;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 04.12.2017<br>
 * Time: 11:15<br>
 * Project name: MVVMtest<br>
 * ===================================================================================<br>
 */
@Module
public abstract class TimerFragmentModule {

    @Provides
    @FragmentScope
    public static TimerViewData viewData() {
        return new TimerViewData();
    }

    @Provides
    @FragmentScope
    public static TimerViewModel viewModel(@NonNull TimerViewData viewData) {
        return new TimerViewModel(viewData);
    }

    @Provides
    @FragmentScope
    @Named("TimerViewModelProvider.Factory")
    static ViewModelProvider.Factory factory(@NonNull TimerViewModel viewModel) {
        return new ViewModelProvider.Factory() {
            @NonNull
            @Override
            public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
                if (modelClass.isAssignableFrom(viewModel.getClass())) {
                    return (T) viewModel;
                }
                return null;
            }
        };
    }
}
