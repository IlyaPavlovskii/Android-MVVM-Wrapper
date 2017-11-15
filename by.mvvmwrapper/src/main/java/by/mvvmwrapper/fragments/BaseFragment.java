package by.mvvmwrapper.fragments;

import android.app.Dialog;
import android.app.Fragment;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.afollestad.materialdialogs.MaterialDialog;

import java.util.List;

import by.mvvmwrapper.R;
import by.mvvmwrapper.exceptions.ExceptionHandler;
import by.mvvmwrapper.exceptions.ExceptionHandlerChain;
import by.mvvmwrapper.interfaces.DialogActionsDelegate;
import by.mvvmwrapper.interfaces.components.OnLifecycleListener;
import by.mvvmwrapper.interfaces.components.OnRequestPermissionListener;
import by.mvvmwrapper.interfaces.components.OnSaveRestoreInstanceListener;
import by.mvvmwrapper.viewmodel.ViewModel;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 11.03.16<br>
 * Time: 0:23<br>
 * Project name: MVVMtest<br>
 * ===================================================================================
 * Base {@link Fragment} realization of view component<br>
 * ===================================================================================
 */
public abstract class BaseFragment<TViewModel extends ViewModel, TViewDataBinding extends ViewDataBinding>
        extends Fragment
        implements ExceptionHandler, DialogActionsDelegate {

    //======================================================
    //----------------------Constants-----------------------
    //======================================================
    public final String TAG = getClass().getSimpleName();

    //======================================================
    //------------------------Fields------------------------
    //======================================================
    @NonNull
    protected TViewDataBinding mBinding;
    @NonNull
    protected TViewModel mViewModel;
    @NonNull
    protected ExceptionHandlerChain mExceptionHandlerChain;

    private Dialog mProgressDialog;

    //======================================================
    //-------------------Abstract methods-------------------
    //======================================================
    @LayoutRes
    protected abstract int getLayoutRes();

    @NonNull
    protected abstract TViewModel initViewModel();

    //======================================================
    //-------------------Protected methods------------------
    //======================================================
    @NonNull
    protected ExceptionHandlerChain initExceptionHandlerChain() {
        return new ExceptionHandlerChain();
    }

    protected void addExceptionHandler(@NonNull ExceptionHandler exceptionHandler) {
        mExceptionHandlerChain.addHandler(exceptionHandler);
    }

    protected void addExceptionHandlers(@NonNull ExceptionHandler... exceptionHandlers) {
        mExceptionHandlerChain.addHandlers(exceptionHandlers);
    }

    protected void addExceptionHandlers(@NonNull List<? extends ExceptionHandler> exceptionHandlers) {
        mExceptionHandlerChain.addHandlers(exceptionHandlers);
    }

    protected void removeExceptionHandler(@NonNull ExceptionHandler exceptionHandler) {
        mExceptionHandlerChain.removeHandler(exceptionHandler);
    }

    protected void removeExceptionHandlers(@NonNull ExceptionHandler... exceptionHandlers) {
        mExceptionHandlerChain.removeHandlers(exceptionHandlers);
    }

    protected void removeExceptionHandlers(@NonNull List<? extends ExceptionHandler> exceptionHandlers) {
        mExceptionHandlerChain.removeHandlers(exceptionHandlers);
    }

    //======================================================
    //-------------------Override methods-------------------
    //======================================================
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mExceptionHandlerChain = initExceptionHandlerChain();
        mViewModel = initViewModel();
        if (mViewModel == null) {
            throw new NullPointerException("ViewModel component must be initialized");
        }
        if (mViewModel instanceof OnLifecycleListener) {
            ((OnLifecycleListener) mViewModel).onCreate(savedInstanceState);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, getLayoutRes(), container, false);
        if (mBinding == null) {
            throw new NullPointerException("ViewDataBinding must be initialized");
        }
        return mBinding.getRoot();
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel.bindViewData(mBinding);
    }


    @Override
    public void onPause() {
        super.onPause();
        if (mViewModel instanceof OnLifecycleListener) {
            ((OnLifecycleListener) mViewModel).onPause();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mViewModel instanceof OnLifecycleListener) {
            ((OnLifecycleListener) mViewModel).onResume();
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        if (mViewModel instanceof OnLifecycleListener) {
            ((OnLifecycleListener) mViewModel).onStart();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mViewModel instanceof OnLifecycleListener) {
            ((OnLifecycleListener) mViewModel).onStop();
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (mViewModel instanceof OnLifecycleListener) {
            ((OnLifecycleListener) mViewModel).onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        if (mViewModel instanceof OnSaveRestoreInstanceListener) {
            ((OnSaveRestoreInstanceListener) mViewModel).onRestoreInstanceState(savedInstanceState);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (mViewModel instanceof OnSaveRestoreInstanceListener) {
            ((OnSaveRestoreInstanceListener) mViewModel).onSaveInstanceState(outState);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (mViewModel instanceof OnRequestPermissionListener) {
            ((OnRequestPermissionListener) mViewModel).onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    @Override
    public boolean handleException(@Nullable Throwable throwable) {
        boolean handled = mExceptionHandlerChain.handleException(throwable);
        if (!handled) {
            // Delegate exception handling to parent fragment
            Fragment parentFragment = null;
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN_MR1) {
                parentFragment = getParentFragment();
            }
            if (parentFragment instanceof ExceptionHandler) {
                handled = ((ExceptionHandler) parentFragment).handleException(throwable);
            }
        }
        if (!handled) {
            // Delegate exception handling to parent activity
            if (getActivity() instanceof ExceptionHandler) {
                handled = ((ExceptionHandler) getActivity()).handleException(throwable);
            }
        }
        return handled;
    }

    @NonNull
    @Override
    public Dialog getProgressDialog() {
        if (getActivity() instanceof DialogActionsDelegate) {
            return ((DialogActionsDelegate) getActivity()).getProgressDialog();
        }
        if (mProgressDialog == null) {
            mProgressDialog = getAlertDialogBuilder()
                    .progress(true, 0)
                    .build();
        }
        return mProgressDialog;
    }

    @Override
    public void showErrorDialog(@Nullable String message) {
        if (getActivity() instanceof DialogActionsDelegate) {
            ((DialogActionsDelegate) getActivity()).showErrorDialog(message);
        } else {
            getAlertDialogBuilder()
                    .title(R.string.error)
                    .title(message)
                    .build()
                    .show();
        }
    }

    @NonNull
    @Override
    public MaterialDialog.Builder getAlertDialogBuilder() {
        if (getActivity() instanceof DialogActionsDelegate) {
            return ((DialogActionsDelegate) getActivity()).getAlertDialogBuilder();
        }
        return new MaterialDialog.Builder(getActivity());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mViewModel instanceof OnLifecycleListener) {
            ((OnLifecycleListener) mViewModel).onDestroy();
        }
        mBinding.unbind();
        mViewModel.destroy();
        mBinding = null;
        mViewModel = null;
    }

}