package by.pavlovskii.ilya.mvvm.test.dagger.modules;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

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
@Module
public class AppModule {

    //======================================================
    //---------------------Constructors---------------------
    //======================================================
    public AppModule() {
    }

    //======================================================
    //---------------------Public methods-------------------
    //======================================================
    @NonNull
    @Provides
    @Singleton
    public Resources provideResources(@NonNull Context context) {
        return context.getResources();
    }

}
