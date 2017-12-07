package by.pavlovskii.ilya.mvvm.test.di.modules;

import android.app.Application;
import android.content.Context;

import by.mvvmwrapper.dagger.scope.ActivityScope;
import by.pavlovskii.ilya.mvvm.test.activity.MainActivity;
import by.pavlovskii.ilya.mvvm.test.activity.YellowActivity;
import by.pavlovskii.ilya.mvvm.test.application.App;
import by.pavlovskii.ilya.mvvm.test.di.modules.activity.MainActivityModule;
import by.pavlovskii.ilya.mvvm.test.di.modules.activity.YellowActivityModule;
import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

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
@Module(includes = ViewModelModule.class)
public interface AppModule {

    @Binds
    Context context(Application app);

    //======================================================
    //----------------------Methods-------------------------
    //======================================================
    @ActivityScope
    @ContributesAndroidInjector(modules = {MainActivityModule.class})
    MainActivity mainActivityInjector();

    @ActivityScope
    @ContributesAndroidInjector(modules = {YellowActivityModule.class})
    YellowActivity yellowActivityInjector();

}
