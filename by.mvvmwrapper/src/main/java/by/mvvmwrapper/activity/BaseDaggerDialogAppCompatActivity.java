package by.mvvmwrapper.activity;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

import javax.inject.Inject;

import by.mvvmwrapper.utils.viewmodelproviders.LazyViewModelProviderFactory;
import by.mvvmwrapper.viewmodel.BaseViewModel;
import dagger.Lazy;
import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 13.12.2017<br>
 * Time: 11:28<br>
 * Project name: MVVMtest<br>
 * ===================================================================================<br>
 * {@link BaseDialogAppCompatActivity} extension with dependency injection modules<br>
 * ===================================================================================<br>
 */
public abstract class BaseDaggerDialogAppCompatActivity<VM extends BaseViewModel, DB extends ViewDataBinding>
        extends BaseDialogAppCompatActivity<VM, DB>
        implements HasSupportFragmentInjector {

    //===================================================================================
    //--------------------------------------Fields---------------------------------------
    //===================================================================================
    @Inject
    DispatchingAndroidInjector<Fragment> mFragmentInjector;
    @Inject
    Lazy<VM> mViewModelLazy;

    //===================================================================================
    //----------------------------------Abstract methods---------------------------------
    //===================================================================================
    protected abstract Class<VM> getViewModelClass();

    //===================================================================================
    //----------------------------------Override methods---------------------------------
    //===================================================================================
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return mFragmentInjector;
    }

    @NonNull
    @Override
    protected VM initViewModel() {
        return ViewModelProviders
                .of(this, getViewModelProviderFactory())
                .get(getViewModelClass());
    }

    @NonNull
    protected ViewModelProvider.Factory getViewModelProviderFactory() {
        return new LazyViewModelProviderFactory<>(getViewModelClass(), mViewModelLazy);
    }
}
