package by.mvvmwrapper.interfaces;

import io.reactivex.annotations.NonNull;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 10.11.2017<br>
 * Time: 1:08<br>
 * Project name: MVVMtest<br>
 * ===================================================================================<br>
 * Failure callback. Pass {@link Throwable} to realization<br>
 * ===================================================================================<br>
 */
public interface FailureCallback {
    void onFailure(@NonNull Throwable throwable);
}
