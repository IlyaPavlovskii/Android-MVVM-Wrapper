package by.pavlovskii.ilya.mvvm.test.dagger.components;

import android.content.Context;

import javax.inject.Singleton;

import by.pavlovskii.ilya.mvvm.test.application.App;
import by.pavlovskii.ilya.mvvm.test.dagger.modules.AppModule;
import by.pavlovskii.ilya.mvvm.test.dagger.modules.NavigatorModule;
import by.pavlovskii.ilya.mvvm.test.dagger.modules.RouterModule;
import dagger.BindsInstance;
import dagger.Component;

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
        AppModule.class,
        RouterModule.class,
        NavigatorModule.class
})
public interface ApplicationComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder context(Context context);

        ApplicationComponent build();
    }

    void inject(App app);
}
