package by.pavlovskii.ilya.mvvm.test.di.components;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import by.pavlovskii.ilya.mvvm.test.activity.main.MainSubComponent;
import by.pavlovskii.ilya.mvvm.test.application.App;
import by.pavlovskii.ilya.mvvm.test.di.modules.AppModule;
import by.pavlovskii.ilya.mvvm.test.di.modules.NavigatorModule;
import by.pavlovskii.ilya.mvvm.test.di.modules.RouterModule;
import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 07.11.16<br>
 * Time: 16:50<br>
 * Project name: MVVMtest<br>
 * ===================================================================================<br>
 */
@Singleton
@Component(modules = {
        AndroidSupportInjectionModule.class,
        AppModule.class,
        RouterModule.class,
        NavigatorModule.class
})
public interface ApplicationComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        ApplicationComponent build();
    }

    void inject(App app);

    Context getContext();
}
