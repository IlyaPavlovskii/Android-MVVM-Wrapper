package by.pavlovskii.ilya.mvvm.test.application;

import android.app.Activity;
import android.app.Application;
import android.util.Log;

import javax.inject.Inject;

import dagger.android.DaggerFragment_MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasDispatchingActivityInjector;

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
public class App extends Application implements HasDispatchingActivityInjector {

    //======================================================
    //----------------------Constants-----------------------
    //======================================================
    private static final String TAG = App.class.getSimpleName();

    //======================================================
    //------------------------Fields------------------------
    //======================================================
    @Inject
    DispatchingAndroidInjector<Activity> dispatchingActivityInjector;

    //======================================================
    //-------------------Override methods-------------------
    //======================================================

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate");
        //DaggerAppComponent.create().inject(this);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        Log.d(TAG, "onTerminate");
    }

    @Override
    public DispatchingAndroidInjector<Activity> activityInjector() {
        return dispatchingActivityInjector;
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
