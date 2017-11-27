package by.pavlovskii.ilya.mvvm.test.application;

import android.app.Activity;
import android.app.Application;
import android.util.Log;

import javax.inject.Inject;

import by.pavlovskii.ilya.mvvm.test.di.Injector;
import by.pavlovskii.ilya.mvvm.test.di.components.DaggerApplicationComponent;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

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
    //----------------------Constants-----------------------
    //======================================================
    private static final String TAG = App.class.getSimpleName();

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
        Log.d(TAG, "onCreate");
        Injector.init(this);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        Log.d(TAG, "onTerminate");
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return dispatchingAndroidInjector;
    }

    //======================================================
    //---------------------Public methods-------------------
    //======================================================

    //======================================================
    //-----------------------Listeners----------------------
    //======================================================

    //======================================================
    //---------------------Inner classes--------------------
    //======================================================
}
