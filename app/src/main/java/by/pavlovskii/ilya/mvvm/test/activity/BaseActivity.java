package by.pavlovskii.ilya.mvvm.test.activity;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import by.pavlovskii.ilya.mvvm.test.viewmodel.IViewModel;
/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 06.01.16<br>
 * Time: 19:53<br>
 * Project name: MVVMtest<br>
 * ===================================================================================
 * //TODO Add description<br>
 * ===================================================================================
 */
public abstract class BaseActivity<TViewModel extends IViewModel> extends AppCompatActivity {

    //======================================================
    //----------------------Constants-----------------------
    //======================================================
    public final String TAG = getClass().getSimpleName();

    //======================================================
    //------------------------Fields------------------------
    //======================================================
    protected ViewDataBinding mBinding;
    protected TViewModel mViewModel;

    //======================================================
    //-------------------Override methods-------------------
    //======================================================

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, getLayoutRes());
        ButterKnife.bind(this);

        mViewModel = getViewModel();
        mViewModel.initViewData();
        mViewModel.bindViewData(this, mBinding);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
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
