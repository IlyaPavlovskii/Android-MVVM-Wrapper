package by.pavlovskii.ilya.mvvm.test.ui.fragments.timer.di;

import android.support.annotation.NonNull;

import by.mvvmwrapper.dagger.scope.FragmentScope;
import by.pavlovskii.ilya.mvvm.test.ui.activity.main.MainViewModel;
import by.pavlovskii.ilya.mvvm.test.ui.fragments.timer.TimerViewData;
import by.pavlovskii.ilya.mvvm.test.ui.fragments.timer.TimerViewModel;
import dagger.Lazy;
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
public interface TimerViewModelModule {

    @Provides
    @FragmentScope
    static TimerViewData viewData() {
        return new TimerViewData();
    }

    @Provides
    @FragmentScope
    static TimerViewModel viewModel(@NonNull TimerViewData viewData, Lazy<MainViewModel> lazy) {
        return new TimerViewModel(viewData, lazy);
    }

}
