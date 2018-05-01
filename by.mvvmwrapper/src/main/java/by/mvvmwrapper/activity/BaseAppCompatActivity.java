package by.mvvmwrapper.activity;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import java.util.List;

import by.mvvmwrapper.exceptions.ExceptionHandler;
import by.mvvmwrapper.exceptions.ExceptionHandlerChain;
import by.mvvmwrapper.viewmodel.BaseViewModel;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 04.08.16<br>
 * Time: 13:07<br>
 * Project name: MVVMtest<br>
 * ===================================================================================
 * Application base View activity. Describe View model in MVVM architecture.
 * Extend from {@link Activity}<br>
 * ===================================================================================
 */
public abstract class BaseAppCompatActivity<M extends BaseViewModel, B extends ViewDataBinding>
        extends AppCompatActivity
        implements ExceptionHandler {

    //======================================================
    //------------------------Fields------------------------
    //======================================================
    @NonNull
    protected B mBinding;
    @NonNull
    protected M mViewModel;
    @NonNull
    protected ExceptionHandlerChain mExceptionHandlerChain;

    //======================================================
    //-------------------Abstract methods-------------------
    //======================================================
    @LayoutRes
    protected abstract int getLayoutRes();

    @NonNull
    protected abstract M initViewModel();

    //======================================================
    //-------------------Override methods-------------------
    //======================================================
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mExceptionHandlerChain = initExceptionHandlerChain();
        mViewModel = initViewModel();
        inflateBinding();

        mViewModel.bindViewData(mBinding);
        mViewModel.onCreate(savedInstanceState);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mViewModel.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mViewModel.onResume();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mViewModel.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mViewModel.onStop();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mViewModel.onSaveInstanceState(outState);
    }


    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        mViewModel.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mViewModel.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        mViewModel.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (getSupportFragmentManager() != null) {
            List<Fragment> fragments = getSupportFragmentManager().getFragments();
            if (fragments != null && !fragments.isEmpty()) {
                for (Fragment fragment : fragments) {
                    fragment.onRequestPermissionsResult(requestCode, permissions, grantResults);
                }
            }
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mViewModel.onDestroy();
        mBinding.unbind();
    }

    @Override
    public boolean handleException(@Nullable Throwable throwable) {
        return mExceptionHandlerChain.handleException(throwable);
    }

    @NonNull
    protected M getViewModel() {
        return mViewModel;
    }

    protected void inflateBinding() {
        mBinding = DataBindingUtil.setContentView(this, getLayoutRes());
    }

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

}

