package by.mvvmwrapper.activity;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import by.mvvmwrapper.viewmodel.BaseViewModel;

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
public abstract class BaseActivity<TViewModel extends BaseViewModel, TViewDataBinding extends ViewDataBinding>
        extends Activity {

    //======================================================
    //------------------------Fields------------------------
    //======================================================
    @NonNull
    protected TViewDataBinding mBinding;
    @NonNull
    protected TViewModel mViewModel;

    //======================================================
    //-------------------Abstract methods-------------------
    //======================================================
    @LayoutRes
    protected abstract int getLayoutRes();

    @NonNull
    protected abstract TViewModel initViewModel();

    //======================================================
    //-------------------Override methods-------------------
    //======================================================
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        android.databinding.DataBindingComponent dataBindingComponent = getDataBindingComponent();
        if (dataBindingComponent == null) {
            mBinding = DataBindingUtil.setContentView(this, getLayoutRes());
        } else {
            mBinding = DataBindingUtil.setContentView(this, getLayoutRes(), dataBindingComponent);
        }
        mViewModel = initViewModel();

        if (mBinding == null) {
            throw new NullPointerException("ViewDataBinding must be initialized");
        }
        if (mViewModel == null) {
            throw new NullPointerException("IViewModel component must be initialized");
        }

        mViewModel.bindViewData(mBinding);
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
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mViewModel.onDestroy();
        mBinding.unbind();
    }

    @NonNull
    protected TViewModel getViewModel() {
        return mViewModel;
    }

    @Nullable
    protected DataBindingComponent getDataBindingComponent() {
        return null;
    }
}
