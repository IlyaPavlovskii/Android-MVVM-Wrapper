package by.mvvmwrapper.activity;

import android.app.Dialog;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;

import com.afollestad.materialdialogs.MaterialDialog;

import by.mvvmwrapper.R;
import by.mvvmwrapper.interfaces.DialogActionsDelegate;
import by.mvvmwrapper.viewmodel.BaseViewModel;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 15.11.2017<br>
 * Time: 10:42<br>
 * Project name: MVVMtest<br>
 * ===================================================================================<br>
 * {@link BaseAppCompatActivity} extension with {@link DialogActionsDelegate} implementation<br>
 * ===================================================================================<br>
 */
public abstract class BaseDialogAppCompatActivity<TViewModel extends BaseViewModel, TViewDataBinding extends ViewDataBinding>
        extends BaseAppCompatActivity<TViewModel, TViewDataBinding>
        implements DialogActionsDelegate {

    //======================================================
    //----------------------Constants-----------------------
    //======================================================
    public final String TAG = getClass().getSimpleName();

    //======================================================
    //------------------------Fields------------------------
    //======================================================
    protected Dialog mProgressDialog;

    //======================================================
    //-------------------Override methods-------------------
    //======================================================
    @NonNull
    @Override
    public Dialog getProgressDialog() {
        if (mProgressDialog == null) {
            mProgressDialog = getAlertDialogBuilder()
                    .progress(true, 0)
                    .build();
        }
        return mProgressDialog;
    }

    @Override
    public void showErrorDialog(@Nullable String message) {
        if (!TextUtils.isEmpty(message)) {
            getAlertDialogBuilder()
                    .title(R.string.error)
                    .content(message)
                    .build()
                    .show();
        }
    }

    @NonNull
    @Override
    public MaterialDialog.Builder getAlertDialogBuilder() {
        return new MaterialDialog.Builder(this);
    }
}
