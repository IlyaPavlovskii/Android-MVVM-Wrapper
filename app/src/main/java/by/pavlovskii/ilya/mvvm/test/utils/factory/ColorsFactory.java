package by.pavlovskii.ilya.mvvm.test.utils.factory;

import io.reactivex.Single;

import java.util.List;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 12.05.2018<br>
 * Time: 20:53<br>
 * Project name: MVVMtest<br>
 * ===================================================================================<br>
 */
public interface ColorsFactory {

    Single<List<String>> getColors();

}
