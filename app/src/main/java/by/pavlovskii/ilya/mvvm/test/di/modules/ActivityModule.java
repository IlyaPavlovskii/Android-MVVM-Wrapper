package by.pavlovskii.ilya.mvvm.test.di.modules;

import by.mvvmwrapper.dagger.scope.ActivityScope;
import by.pavlovskii.ilya.mvvm.test.ui.activity.adapter.AdapterActivity;
import by.pavlovskii.ilya.mvvm.test.ui.activity.adapter.di.AdapterModule;
import by.pavlovskii.ilya.mvvm.test.ui.activity.launch.LaunchActivity;
import by.pavlovskii.ilya.mvvm.test.ui.activity.launch.di.LaunchModule;
import by.pavlovskii.ilya.mvvm.test.ui.activity.main.MainActivity;
import by.pavlovskii.ilya.mvvm.test.ui.activity.main.di.MainActivityModule;
import by.pavlovskii.ilya.mvvm.test.ui.activity.twoway.TwoWayActivity;
import by.pavlovskii.ilya.mvvm.test.ui.activity.twoway.di.TwoWayModule;
import by.pavlovskii.ilya.mvvm.test.ui.fragments.timer.di.TimerFragmentProvider;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 13.12.2017<br>
 * Time: 11:40<br>
 * Project name: MVVMtest<br>
 * ===================================================================================<br>
 * Activity dependency provider module<br>
 * ===================================================================================<br>
 */
@Module
public interface ActivityModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = {LaunchModule.class})
    LaunchActivity launchActivityInjector();

    @ActivityScope
    @ContributesAndroidInjector(modules = {TwoWayModule.class})
    TwoWayActivity twoWayActivityInjector();

    @ActivityScope
    @ContributesAndroidInjector(modules = {AdapterModule.class})
    AdapterActivity adapterActivityInjector();

    @ActivityScope
    @ContributesAndroidInjector(modules = {
            MainActivityModule.class,
            TimerFragmentProvider.class})
    MainActivity mainActivityInjector();
}
