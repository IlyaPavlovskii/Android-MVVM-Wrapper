package by.pavlovskii.ilya.mvvm.test.dagger.components;

import by.pavlovskii.ilya.mvvm.test.activity.ProfileActivity;
import by.pavlovskii.ilya.mvvm.test.application.App;
import by.pavlovskii.ilya.mvvm.test.dagger.modules.ProfileActivityModule;
import dagger.Component;
import dagger.Subcomponent;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 08.04.17<br>
 * Time: 1:13<br>
 * Project name: MVVMtest<br>
 * ===================================================================================
 * //TODO Add description<br>
 * ===================================================================================
 */
@Component(
        modules = {
                AndroidInjectionModule.class,
                ProfileActivityModule.class
        })
public interface AppComponent {

    @Component.Builder
    abstract class Builder extends AndroidInjector.Builder<App> {
    }

    void inject(App app);
}
