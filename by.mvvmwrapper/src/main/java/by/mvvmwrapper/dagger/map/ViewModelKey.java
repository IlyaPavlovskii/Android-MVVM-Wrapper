package by.mvvmwrapper.dagger.map;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import by.mvvmwrapper.viewmodel.BaseViewModel;
import dagger.MapKey;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 01.05.2018<br>
 * Time: 19:19<br>
 * Project name: MVVMtest<br>
 * ===================================================================================<br>
 */
@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@MapKey
public @interface ViewModelKey {
    Class<? extends BaseViewModel> value();
}
