package by.pavlovskii.ilya.mvvm.test.ui.activity.twoway.di;

import android.support.annotation.NonNull;
import by.mvvmwrapper.dagger.map.ViewModelKey;
import by.mvvmwrapper.viewmodel.BaseViewModel;
import by.pavlovskii.ilya.mvvm.test.ui.activity.twoway.TwoWayViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 12.05.2018<br>
 * Time: 18:01<br>
 * Project name: MVVMtest<br>
 * ===================================================================================<br>
 */
@Module
public abstract class TwoWayModule {

    @Binds
    @IntoMap
    @ViewModelKey(TwoWayViewModel.class)
    abstract BaseViewModel bindTwoWayViewModel(@NonNull TwoWayViewModel viewModel);

}
