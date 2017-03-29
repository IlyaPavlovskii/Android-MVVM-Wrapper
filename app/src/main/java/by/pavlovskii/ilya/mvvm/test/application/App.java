package by.pavlovskii.ilya.mvvm.test.application;

import android.app.Application;
import android.util.Log;

import javax.inject.Inject;

import by.pavlovskii.ilya.mvvm.test.dagger.components.ApplicationComponent;
import by.pavlovskii.ilya.mvvm.test.dagger.components.DaggerApplicationComponent;

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
public class App extends Application {

    //======================================================
    //----------------------Constants-----------------------
    //======================================================
    private static final String TAG = App.class.getSimpleName();
    //======================================================
    //------------------------Fields------------------------
    //======================================================
    private static ApplicationComponent sApplicationComponent;

    //======================================================
    //-------------------Override methods-------------------
    //======================================================

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate");
        sApplicationComponent = DaggerApplicationComponent
                .builder()
                .build();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        Log.d(TAG, "onTerminate");
    }

    //======================================================
    //---------------------Public methods-------------------
    //======================================================
    public static ApplicationComponent getApplicationComponent() {
        return sApplicationComponent;
    }

    //======================================================
    //-----------------------Listeners----------------------
    //======================================================

    //======================================================
    //---------------------Inner classes--------------------
    //======================================================
}
