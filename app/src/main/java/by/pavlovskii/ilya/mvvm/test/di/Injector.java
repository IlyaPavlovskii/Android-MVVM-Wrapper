package by.pavlovskii.ilya.mvvm.test.di;

import android.databinding.DataBindingUtil;

import by.pavlovskii.ilya.mvvm.test.application.App;
import by.pavlovskii.ilya.mvvm.test.di.components.ApplicationComponent;
import by.pavlovskii.ilya.mvvm.test.di.components.DaggerApplicationComponent;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 27.11.2017<br>
 * Time: 20:12<br>
 * Project name: MVVMtest<br>
 * ===================================================================================<br>
 */
public class Injector {
    private Injector() {
    }

    private static ApplicationComponent sApplicationComponent;

    public static void init(App app) {
        sApplicationComponent = DaggerApplicationComponent.builder()
                .application(app)
                .build();
        sApplicationComponent.inject(app);
        DataBindingUtil.setDefaultComponent(sApplicationComponent);
    }

    public static ApplicationComponent getApplicationComponent() {
        return sApplicationComponent;
    }
}
