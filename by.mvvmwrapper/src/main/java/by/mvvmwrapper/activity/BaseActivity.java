package by.mvvmwrapper.activity;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;

import by.mvvmwrapper.view.IView;
import by.mvvmwrapper.viewmodel.IViewModel;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 06.01.16<br>
 * Time: 19:53<br>
 * Project name: MVVMtest<br>
 * ===================================================================================
 * Base {@link Activity} realization of {@link IView} component<br>
 * ===================================================================================
 */
public abstract class BaseActivity<TViewModel extends IViewModel, TViewDataBinding extends ViewDataBinding>
        extends Activity implements IView {

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
