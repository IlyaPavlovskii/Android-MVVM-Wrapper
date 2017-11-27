package by.pavlovskii.ilya.mvvm.test.di.modules;

import javax.inject.Singleton;

import by.pavlovskii.ilya.mvvm.test.navigator.MainNavigator;
import dagger.Module;
import dagger.Provides;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 27.11.2017<br>
 * Time: 8:36<br>
 * Project name: MVVMtest<br>
 * ===================================================================================<br>
 * Navigation between screens<br>
 * ===================================================================================<br>
 */
@Module
@Singleton
public class NavigatorModule {

    @Provides
    @Singleton
    public MainNavigator provideMainNavigator() {
        return new MainNavigator();
    }

}
