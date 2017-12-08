package by.pavlovskii.ilya.mvvm.test.activity.main;

import android.arch.lifecycle.ViewModelProvider;

import javax.inject.Inject;

import by.mvvmwrapper.dagger.scope.ActivityScope;
import by.pavlovskii.ilya.mvvm.test.navigator.MainNavigator;
import by.pavlovskii.ilya.mvvm.test.viewmodel.SubcomponentViewModelFactory;
import dagger.Binds;
import dagger.Module;
import ru.terrakok.cicerone.Navigator;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 08.12.2017<br>
 * Time: 16:18<br>
 * Project name: MVVMtest<br>
 * ===================================================================================<br>
 */
@Module
@ActivityScope
public abstract class MainActivityModule {

    @Binds
    @ActivityScope
    abstract Navigator navigator(MainNavigator navigator);

    @Binds
    @ActivityScope
    abstract ViewModelProvider.Factory viewModelProvider(SubcomponentViewModelFactory factory);
}
