package by.mvvmwrapper.activity;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

import javax.inject.Inject;
import javax.inject.Provider;

import by.mvvmwrapper.utils.viewmodelproviders.ProviderViewModelProviderFactory;
import by.mvvmwrapper.viewmodel.BaseViewModel;
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
 * Time: 11:22<br>
 * Project name: MVVMtest<br>
 * ===================================================================================<br>
 * {@link BaseAppCompatActivity} extension with dependency injection modules<br>
 * ===================================================================================<br>
 */
public abstract class BaseDaggerAppCompatActivity<TViewModel extends BaseViewModel, TViewDataBinding extends ViewDataBinding>
        extends BaseAppCompatActivity<TViewModel, TViewDataBinding>
        implements HasSupportFragmentInjector {

    //===================================================================================
    //--------------------------------------Fields---------------------------------------
    //===================================================================================
    @Inject
    DispatchingAndroidInjector<Fragment> mFragmentInjector;
    @Inject
    Provider<TViewModel> mViewModelProvider;

    //===================================================================================
    //----------------------------------Abstract methods---------------------------------
    //===================================================================================
    protected abstract Class<TViewModel> getViewModelClass();

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
    protected TViewModel initViewModel() {
        return ViewModelProviders
                .of(this, getViewModelProviderFactory())
                .get(getViewModelClass());
    }

    @NonNull
    protected ViewModelProvider.Factory getViewModelProviderFactory() {
        return new ProviderViewModelProviderFactory<>(getViewModelClass(), mViewModelProvider);
    }

}
