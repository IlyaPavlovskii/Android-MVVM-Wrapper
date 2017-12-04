package by.pavlovskii.ilya.mvvm.test.di.modules.activity;

import android.support.annotation.NonNull;

import by.mvvmwrapper.dagger.scope.ActivityScope;
import by.pavlovskii.ilya.mvvm.test.navigator.MainNavigator;
import dagger.Binds;
import dagger.Module;
import ru.terrakok.cicerone.Navigator;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 03.12.2017<br>
 * Time: 15:52<br>
 * Project name: MVVMtest<br>
 * ===================================================================================<br>
 */
@Module
public interface YellowActivityModule {

    @Binds
    @ActivityScope
    Navigator navigator(@NonNull MainNavigator navigator);
}
