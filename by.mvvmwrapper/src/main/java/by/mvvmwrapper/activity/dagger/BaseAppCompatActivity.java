package by.mvvmwrapper.activity.dagger;

import android.app.Fragment;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import by.mvvmwrapper.viewmodel.IViewModel;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasDispatchingFragmentInjector;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 18.04.17<br>
 * Time: 0:41<br>
 * Project name: MVVMtest<br>
 * ===================================================================================
 * Base {@link AppCompatActivity} realization of view MVVM component with
 * Dagger2 injection<br>
 * ===================================================================================
 */
public abstract class BaseAppCompatActivity<TViewModel extends IViewModel, TViewDataBinding extends ViewDataBinding>
        extends AppCompatActivity
        implements HasDispatchingFragmentInjector {
    //======================================================
    //----------------------Constants-----------------------
    //======================================================
    public final String TAG = getClass().getSimpleName();

    //======================================================
    //------------------------Fields------------------------
    //======================================================
    protected TViewDataBinding mBinding;
    @Inject
    protected TViewModel mViewModel;

    @Inject
    DispatchingAndroidInjector<Fragment> mFragmentInjector;

    //======================================================
    //-------------------Override methods-------------------
    //======================================================
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, getLayoutRes());

        if (mViewModel != null) {
            mViewModel.bindViewData(mBinding);
        }

    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mViewModel != null) {
            mViewModel.onPause();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mViewModel != null) {
            mViewModel.onResume();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (mViewModel != null) {
            mViewModel.onStart();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mViewModel != null) {
            mViewModel.onStop();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (mViewModel != null) {
            mViewModel.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (mViewModel != null) {
            mViewModel.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mBinding != null) {
            mBinding.unbind();
        }
        if (mViewModel != null) {
            mViewModel.destroy();
        }
        mBinding = null;
        mViewModel = null;
    }

    @Override
    public DispatchingAndroidInjector<Fragment> fragmentInjector() {
        return mFragmentInjector;
    }

    //======================================================
    //-------------------Abstract methods-------------------
    //======================================================
    @LayoutRes
    protected abstract int getLayoutRes();
}
