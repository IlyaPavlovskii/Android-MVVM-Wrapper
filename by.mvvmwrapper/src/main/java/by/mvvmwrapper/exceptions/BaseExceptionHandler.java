package by.mvvmwrapper.exceptions;

import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;

import by.mvvmwrapper.interfaces.DialogActionsDelegate;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 11.11.2017<br>
 * Time: 16:46<br>
 * Project name: MVVMtest<br>
 * ===================================================================================<br>
 * Simple {@link ExceptionHandler} implementation.<br>
 * ===================================================================================<br>
 */
public abstract class BaseExceptionHandler implements ExceptionHandler {

    @NonNull
    protected final Resources mResources;
    @NonNull
    protected final DialogActionsDelegate mDialogActionsDelegate;

    public BaseExceptionHandler(@NonNull Resources resources, @NonNull DialogActionsDelegate dialogActionsDelegate) {
        mResources = resources;
        mDialogActionsDelegate = dialogActionsDelegate;
    }

    public String getString(@StringRes int res) {
        return mResources.getString(res);
    }

    public void showErrorDialog(@StringRes int res) {
        String errorMessage = getString(res);
        mDialogActionsDelegate.showErrorDialog(errorMessage);
    }
}
