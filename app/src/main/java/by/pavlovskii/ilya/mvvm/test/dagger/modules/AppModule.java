package by.pavlovskii.ilya.mvvm.test.dagger.modules;

import android.content.Context;
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
    //------------------------Fields------------------------
    //======================================================
    @NonNull
    private Context mContext;

    //======================================================
    //---------------------Constructors---------------------
    //======================================================
    public AppModule(@NonNull Context context) {
        mContext = context;
    }

    //======================================================
    //---------------------Public methods-------------------
    //======================================================
    @Singleton
    @Provides
    @NonNull
    public Context provideContext() {
        return mContext;
    }

}
