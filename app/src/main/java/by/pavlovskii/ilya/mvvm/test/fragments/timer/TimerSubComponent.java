package by.pavlovskii.ilya.mvvm.test.fragments.timer;

import by.mvvmwrapper.dagger.scope.FragmentScope;
import dagger.Subcomponent;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 08.12.2017<br>
 * Time: 17:13<br>
 * Project name: MVVMtest<br>
 * ===================================================================================<br>
 */
@FragmentScope
@Subcomponent(modules = TimerViewModelModule.class)
public interface TimerSubComponent {

    @Subcomponent.Builder
    interface Builder {
        TimerSubComponent build();
    }

    TimerViewModel viewModel();
}
