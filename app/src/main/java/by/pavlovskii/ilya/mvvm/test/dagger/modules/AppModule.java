package by.pavlovskii.ilya.mvvm.test.dagger.modules;

import javax.inject.Singleton;

import by.mvvmwrapper.dagger.scope.ActivityScope;
import by.pavlovskii.ilya.mvvm.test.activity.MainActivity;
import by.pavlovskii.ilya.mvvm.test.dagger.modules.activity.MainActivityModule;
import by.pavlovskii.ilya.mvvm.test.navigator.MainNavigator;
import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import ru.terrakok.cicerone.Navigator;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 07.11.16<br>
 * Time: 16:39<br>
 * Project name: MVVMtest<br>
 * ===================================================================================<br>
 * Application module<br>
 * ===================================================================================<br>
 */
@Module(includes = {AndroidSupportInjectionModule.class})
public interface AppModule {

    //======================================================
    //----------------------Methods-------------------------
    //======================================================
    @ActivityScope
    @ContributesAndroidInjector(modules = {MainActivityModule.class})
    MainActivity mainActivityInjector();


}
