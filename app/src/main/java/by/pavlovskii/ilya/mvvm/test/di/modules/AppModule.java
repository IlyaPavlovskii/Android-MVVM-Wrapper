package by.pavlovskii.ilya.mvvm.test.di.modules;

import android.app.Application;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;

import javax.inject.Singleton;

import by.mvvmwrapper.dagger.scope.ActivityScope;
import by.pavlovskii.ilya.mvvm.test.activity.main.MainActivity;
import by.pavlovskii.ilya.mvvm.test.activity.main.MainActivityModule;
import by.pavlovskii.ilya.mvvm.test.activity.main.MainSubComponent;
import by.pavlovskii.ilya.mvvm.test.activity.yellow.YellowActivity;
import by.pavlovskii.ilya.mvvm.test.activity.yellow.YellowActivityModule;
import by.pavlovskii.ilya.mvvm.test.fragments.timer.TimerFragmentProvider;
import by.pavlovskii.ilya.mvvm.test.fragments.timer.TimerSubComponent;
import by.pavlovskii.ilya.mvvm.test.viewmodel.SubcomponentViewModelFactory;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
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
@Module(subcomponents = {
        MainSubComponent.class
})
public abstract class AppModule {

    @Binds
    abstract Context context(Application app);

    @Provides
    static Resources resources(@NonNull Context context) {
        return context.getResources();
    }

    //======================================================
    //----------------------Methods-------------------------
    //======================================================
    @ActivityScope
    @ContributesAndroidInjector(modules = {
            MainActivityModule.class, TimerFragmentProvider.class})
    abstract MainActivity mainActivityInjector();

    @ActivityScope
    @ContributesAndroidInjector(modules = {YellowActivityModule.class})
    abstract YellowActivity yellowActivityInjector();

    // Provide factory
    @Provides
    @Singleton
    static SubcomponentViewModelFactory provideViewModelFactory(
            MainSubComponent.Builder builder) {
        return new SubcomponentViewModelFactory(builder);
    }

}
