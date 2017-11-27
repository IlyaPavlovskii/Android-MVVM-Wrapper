package by.pavlovskii.ilya.mvvm.test.di.modules;

import android.support.annotation.NonNull;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ru.terrakok.cicerone.Cicerone;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.Router;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 14.11.2017<br>
 * Time: 18:28<br>
 * Project name: MVVMtest<br>
 * ===================================================================================<br>
 */
@Module
@Singleton
public class RouterModule {

    //======================================================
    //---------------------Public methods-------------------
    //======================================================
    @NonNull
    @Provides
    @Singleton
    public Cicerone<Router> getCicerone() {
        return Cicerone.create();
    }

    @NonNull
    @Provides
    @Singleton
    public NavigatorHolder getNavigatorHolder(Cicerone<Router> cicerone) {
        return cicerone.getNavigatorHolder();
    }

    @NonNull
    @Provides
    @Singleton
    public Router getRouter(Cicerone<Router> cicerone) {
        return cicerone.getRouter();
    }
}
