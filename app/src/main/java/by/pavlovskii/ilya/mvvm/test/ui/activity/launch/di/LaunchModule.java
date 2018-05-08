package by.pavlovskii.ilya.mvvm.test.ui.activity.launch.di;

import android.support.annotation.NonNull;
import by.mvvmwrapper.dagger.map.ViewModelKey;
import by.mvvmwrapper.viewmodel.BaseViewModel;
import by.pavlovskii.ilya.mvvm.test.ui.activity.launch.LaunchViewModel;
import by.pavlovskii.ilya.mvvm.test.ui.activity.launch.impl.SampleItemFactoryImpl;
import by.pavlovskii.ilya.mvvm.test.utils.factory.SampleItemFactory;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 09.05.2018<br>
 * Time: 1:05<br>
 * Project name: MVVMtest<br>
 * ===================================================================================<br>
 */
@Module
public abstract class LaunchModule {

    @Binds
    abstract SampleItemFactory bindSampleItemFactory(@NonNull SampleItemFactoryImpl impl);

    @Binds
    @IntoMap
    @ViewModelKey(LaunchViewModel.class)
    abstract BaseViewModel bindLaunchViewModel(@NonNull LaunchViewModel viewModel);

}
