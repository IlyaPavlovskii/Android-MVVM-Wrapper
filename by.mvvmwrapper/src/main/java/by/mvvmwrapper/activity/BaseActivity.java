package by.mvvmwrapper.activity;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.List;

import by.mvvmwrapper.exceptions.ExceptionHandler;
import by.mvvmwrapper.exceptions.ExceptionHandlerChain;
import by.mvvmwrapper.interfaces.components.OnLifecycleListener;
import by.mvvmwrapper.interfaces.components.OnRequestPermissionListener;
import by.mvvmwrapper.interfaces.components.OnSaveRestoreInstanceListener;
import by.mvvmwrapper.viewmodel.ViewModel;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 06.01.16<br>
 * Time: 19:53<br>
 * Project name: MVVMtest<br>
 * ===================================================================================
 * Base {@link Activity} realization of view MVVM component<br>
 * ===================================================================================
 */
public abstract class BaseActivity<TViewModel extends ViewModel, TViewDataBinding extends ViewDataBinding>
        extends Activity
        implements ExceptionHandler {

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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mExceptionHandlerChain = initExceptionHandlerChain();
        mBinding = DataBindingUtil.setContentView(this, getLayoutRes());
        mViewModel = initViewModel();

        if (mBinding == null) {
            throw new NullPointerException("ViewDataBinding must be initialized");
        }
        if (mViewModel == null) {
            throw new NullPointerException("ViewModel component must be initialized");
        }

        mViewModel.bindViewData(mBinding);
        if (mViewModel instanceof OnLifecycleListener) {
            ((OnLifecycleListener) mViewModel).onCreate(savedInstanceState);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mViewModel instanceof OnLifecycleListener) {
            ((OnLifecycleListener) mViewModel).onPause();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mViewModel instanceof OnLifecycleListener) {
            ((OnLifecycleListener) mViewModel).onResume();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (mViewModel instanceof OnLifecycleListener) {
            ((OnLifecycleListener) mViewModel).onStart();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mViewModel instanceof OnLifecycleListener) {
            ((OnLifecycleListener) mViewModel).onStop();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (mViewModel instanceof OnSaveRestoreInstanceListener) {
            ((OnSaveRestoreInstanceListener) mViewModel).onSaveInstanceState(outState);
        }
    }


    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (mViewModel instanceof OnSaveRestoreInstanceListener) {
            ((OnSaveRestoreInstanceListener) mViewModel).onRestoreInstanceState(savedInstanceState);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (mViewModel instanceof OnLifecycleListener) {
            ((OnLifecycleListener) mViewModel).onActivityResult(requestCode, resultCode, data);
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
        return mExceptionHandlerChain.handleException(throwable);
    }

    @Override
    protected void onDestroy() {
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
