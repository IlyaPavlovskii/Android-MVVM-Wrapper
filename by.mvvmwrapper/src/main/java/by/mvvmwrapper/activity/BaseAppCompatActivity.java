package by.mvvmwrapper.activity;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import by.mvvmwrapper.viewmodel.IViewModel;

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
public abstract class BaseAppCompatActivity<TViewModel extends IViewModel, TViewDataBinding extends ViewDataBinding>
        extends AppCompatActivity {

    //======================================================
    //----------------------Constants-----------------------
    //======================================================
    public final String TAG = getClass().getSimpleName();

    //======================================================
    //------------------------Fields------------------------
    //======================================================
    protected TViewDataBinding mBinding;
    protected TViewModel mViewModel;

    //======================================================
    //-------------------Override methods-------------------
    //======================================================
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, getLayoutRes());

        mViewModel = getViewModel();
        mViewModel.initViewData();
        mViewModel.bindViewData(mBinding);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mBinding.unbind();
        mViewModel.destroy();
        mViewModel = null;
    }

    //======================================================
    //-------------------Abstract methods-------------------
    //======================================================
    @LayoutRes
    protected abstract int getLayoutRes();

    @NonNull
    protected abstract TViewModel getViewModel();

}

