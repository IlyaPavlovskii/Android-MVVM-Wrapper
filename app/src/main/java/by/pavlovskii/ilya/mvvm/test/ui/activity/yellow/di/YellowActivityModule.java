package by.pavlovskii.ilya.mvvm.test.ui.activity.yellow.di;

import android.support.annotation.NonNull;

import by.mvvmwrapper.dagger.map.ViewModelKey;
import by.mvvmwrapper.dagger.scope.ActivityScope;
import by.mvvmwrapper.viewmodel.BaseViewModel;
import by.pavlovskii.ilya.mvvm.test.ui.activity.yellow.YellowViewData;
import by.pavlovskii.ilya.mvvm.test.ui.activity.yellow.YellowViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 08.12.2017<br>
 * Time: 3:14<br>
 * Project name: MVVMtest<br>
 * ===================================================================================<br>
 */
@Module
public abstract class YellowActivityModule {

    @Provides
    @ActivityScope
    static YellowViewData viewData() {
        return new YellowViewData();
    }

    @Binds
    @IntoMap
    @ViewModelKey(YellowViewModel.class)
    abstract BaseViewModel bindYellowViewModel(@NonNull YellowViewModel viewModel);

}
