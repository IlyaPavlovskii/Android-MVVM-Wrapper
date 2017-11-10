package by.mvvmwrapper.fragments;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import by.mvvmwrapper.interfaces.components.OnLifecycleListener;
import by.mvvmwrapper.interfaces.components.OnRequestPermissionListener;
import by.mvvmwrapper.interfaces.components.OnSaveRestoreInstanceListener;
import by.mvvmwrapper.viewmodel.ViewModel;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 04.08.16<br>
 * Time: 13:09<br>
 * Project name: MVVMtest<br>
 * ===================================================================================
 * Base {@link android.support.v4.app.Fragment} realization of view component<br>
 * ===================================================================================
 */
public abstract class BaseFragmentSupport<TViewModel extends ViewModel, TViewDataBinding extends ViewDataBinding>
        extends android.support.v4.app.Fragment implements OnRequestPermissionListener {

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
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (mViewModel instanceof OnRequestPermissionListener) {
            ((OnRequestPermissionListener) mViewModel).onRequestPermissionsResult(requestCode, permissions, grantResults);
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