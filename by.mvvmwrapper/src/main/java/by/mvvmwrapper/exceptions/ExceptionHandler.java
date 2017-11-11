package by.mvvmwrapper.exceptions;

import android.support.annotation.Nullable;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 11.11.2017<br>
 * Time: 16:26<br>
 * Project name: MVVMtest<br>
 * ===================================================================================<br>
 * Exceptions handler. Different handlers can be used in chain to process different kinds of
 * exceptions<br>
 * ===================================================================================<br>
 */
public interface ExceptionHandler {
    /**
     * Exception handling logic.
     *
     * @param throwable exception
     * @return true - exception consumed, false - exception should be passed to the next handler
     */
    boolean handleException(@Nullable Throwable throwable);
}
