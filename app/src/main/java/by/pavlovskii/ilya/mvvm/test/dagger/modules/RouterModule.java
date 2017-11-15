package by.pavlovskii.ilya.mvvm.test.dagger.modules;

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
    @Singleton
    @Provides
    public Cicerone<Router> getCicerone() {
        return Cicerone.create();
    }

    @NonNull
    @Singleton
    @Provides
    public NavigatorHolder getNavigatorHolder(Cicerone<Router> cicerone) {
        return cicerone.getNavigatorHolder();
    }

    @NonNull
    @Singleton
    @Provides
    public Router getRouter(Cicerone<Router> cicerone) {
        return cicerone.getRouter();
    }
}
