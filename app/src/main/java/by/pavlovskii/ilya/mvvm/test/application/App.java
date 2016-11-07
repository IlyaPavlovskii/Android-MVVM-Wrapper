package by.pavlovskii.ilya.mvvm.test.application;

import android.app.Application;

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
 * //TODO Add description<br>
 * ===================================================================================
 */
public class App extends Application {

    //======================================================
    //----------------------Interfaces----------------------
    //======================================================

    //======================================================
    //----------------------Constants-----------------------
    //======================================================

    //======================================================
    //---------------------View components------------------
    //======================================================

    //======================================================
    //------------------------Fields------------------------
    //======================================================
    private static ApplicationComponent sApplicationComponent;

    //======================================================
    //---------------------Constructors---------------------
    //======================================================

    //======================================================
    //-------------------Override methods-------------------
    //======================================================

    @Override
    public void onCreate() {
        super.onCreate();
        sApplicationComponent = DaggerApplicationComponent
                .builder()
                .build();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
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
