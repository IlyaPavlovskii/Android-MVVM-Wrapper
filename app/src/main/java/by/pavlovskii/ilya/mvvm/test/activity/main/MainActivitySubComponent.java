package by.pavlovskii.ilya.mvvm.test.activity.main;

import by.mvvmwrapper.dagger.scope.ActivityScope;
import dagger.Subcomponent;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 09.12.2017<br>
 * Time: 20:03<br>
 * Project name: MVVMtest<br>
 * ===================================================================================<br>
 */
@ActivityScope
@Subcomponent(modules = MainActivityModule.class)
public interface MainActivitySubComponent {

    @Subcomponent.Builder
    interface Builder {

        MainActivitySubComponent build();
    }

    void inject(MainActivity mainActivity);

}
