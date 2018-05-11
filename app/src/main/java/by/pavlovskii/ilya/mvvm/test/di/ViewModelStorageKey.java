package by.pavlovskii.ilya.mvvm.test.di;

import by.mvvmwrapper.viewmodel.BaseViewModel;
import dagger.MapKey;

import javax.inject.Qualifier;
import java.lang.annotation.*;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 11.05.2018<br>
 * Time: 12:36<br>
 * Project name: MVVMtest<br>
 * ===================================================================================<br>
 * //TODO Add description<br>
 * ===================================================================================<br>
 */
@Documented
@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface ViewModelStorageKey {
}
