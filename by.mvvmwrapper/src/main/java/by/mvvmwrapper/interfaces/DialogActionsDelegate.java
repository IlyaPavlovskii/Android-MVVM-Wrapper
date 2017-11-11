package by.mvvmwrapper.interfaces;

import android.app.Dialog;
import android.support.annotation.Nullable;

import com.afollestad.materialdialogs.MaterialDialog;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 10.11.2017<br>
 * Time: 19:43<br>
 * Project name: MVVMtest<br>
 * ===================================================================================<br>
 * Application dialog delegate<br>
 * ===================================================================================<br>
 */
public interface DialogActionsDelegate {
    //======================================================
    //------------------------Methods-----------------------
    //======================================================
    void showErrorDialog(@Nullable String message);

    Dialog getProgressDialog();

    MaterialDialog.Builder getAlertDialogBuilder();
}
