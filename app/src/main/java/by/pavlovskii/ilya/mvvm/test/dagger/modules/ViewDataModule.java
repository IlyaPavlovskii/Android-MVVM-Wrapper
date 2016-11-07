package by.pavlovskii.ilya.mvvm.test.dagger.modules;

import android.support.annotation.NonNull;
import android.util.Log;

import by.mvvmwrapper.dagger.scope.ViewModelScope;
import by.pavlovskii.ilya.mvvm.test.handlers.ProfileHandler;
import by.pavlovskii.ilya.mvvm.test.viewdata.ProfileViewData;
import dagger.Module;
import dagger.Provides;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 07.11.16<br>
 * Time: 16:45<br>
 * Project name: MVVMtest<br>
 * ===================================================================================<br>
 * //TODO Add description<br>
 * ===================================================================================<br>
 */
@Module
public class ViewDataModule {

    //======================================================
    //---------------------Public methods-------------------
    //======================================================
    @Provides
    @NonNull
    @ViewModelScope
    public ProfileViewData provideProfileViewData() {
        Log.d("Module", "ProfileViewData");
        return new ProfileViewData();
    }

    @Provides
    public ProfileHandler provideProfileHandler(@NonNull ProfileViewData profileViewData) {
        Log.d("Module", "ProfileViewHandler");
        return new ProfileHandler(() -> profileViewData);
    }

    //======================================================
    //-----------------------Listeners----------------------
    //======================================================

    //======================================================
    //---------------------Inner classes--------------------
    //======================================================
}
