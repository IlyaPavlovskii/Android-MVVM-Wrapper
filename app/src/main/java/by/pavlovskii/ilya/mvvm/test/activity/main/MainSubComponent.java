package by.pavlovskii.ilya.mvvm.test.activity.main;

import by.mvvmwrapper.dagger.scope.ActivityScope;
import by.pavlovskii.ilya.mvvm.test.fragments.timer.TimerFragmentProvider;
import dagger.Subcomponent;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 08.12.2017<br>
 * Time: 14:40<br>
 * Project name: MVVMtest<br>
 * ===================================================================================<br>
 */
@ActivityScope
@Subcomponent(
        modules = {
                MainViewModelModule.class,
                TimerFragmentProvider.class
        })
public interface MainSubComponent {

    @Subcomponent.Builder
    interface Builder {
        MainSubComponent build();
    }

    MainViewModel viewModel();

}
