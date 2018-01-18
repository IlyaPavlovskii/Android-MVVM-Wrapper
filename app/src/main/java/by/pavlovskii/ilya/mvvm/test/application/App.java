package by.pavlovskii.ilya.mvvm.test.application;

import android.app.Activity;
import android.app.Application;
import android.util.Log;

import javax.inject.Inject;

import by.pavlovskii.ilya.mvvm.test.BuildConfig;
import by.pavlovskii.ilya.mvvm.test.di.Injector;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import timber.log.Timber;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 05.08.16<br>
 * Time: 17:17<br>
 * Project name: MVVMtest<br>
 * ===================================================================================
 * Application main class<br>
 * ===================================================================================
 */
public class App extends Application implements HasActivityInjector {

    //======================================================
    //------------------------Fields------------------------
    //======================================================
    @Inject
    DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;

    //======================================================
    //-------------------Override methods-------------------
    //======================================================

    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
        Timber.d("onCreate");
        Injector.init(this);

    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        Timber.d("onTerminate");
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return dispatchingAndroidInjector;
    }
}
