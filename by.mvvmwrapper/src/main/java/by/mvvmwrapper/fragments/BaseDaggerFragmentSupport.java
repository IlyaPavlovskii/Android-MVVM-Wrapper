package by.mvvmwrapper.fragments;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import javax.inject.Inject;
import javax.inject.Provider;

import by.mvvmwrapper.utils.viewmodelproviders.ProviderViewModelProviderFactory;
import by.mvvmwrapper.viewmodel.BaseViewModel;
import dagger.android.support.AndroidSupportInjection;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 13.12.2017<br>
 * Time: 11:30<br>
 * Project name: MVVMtest<br>
 * ===================================================================================<br>
 * {@link BaseFragmentSupport} extension with dependency injection modules<br>
 * ===================================================================================<br>
 */
public abstract class BaseDaggerFragmentSupport<TViewModel extends BaseViewModel, TViewDataBinding extends ViewDataBinding>
        extends BaseFragmentSupport<TViewModel, TViewDataBinding> {

    //======================================================
    //------------------------Fields------------------------
    //======================================================
    @Inject
    Provider<TViewModel> mViewModelProvider;

    //======================================================
    //-------------------Override methods-------------------
    //======================================================
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidSupportInjection.inject(this);
        super.onCreate(savedInstanceState);
    }

    @NonNull
    @Override
    protected TViewModel initViewModel() {
        return ViewModelProviders
                .of(this, getViewModelFactory())
                .get(getViewModelClass());
    }

    //======================================================
    //-------------------Protected methods------------------
    //======================================================
    @NonNull
    protected ViewModelProvider.Factory getViewModelFactory() {
        return new ProviderViewModelProviderFactory<>(getViewModelClass(), mViewModelProvider);
    }

    //======================================================
    //-------------------Abstract methods-------------------
    //======================================================
    protected abstract Class<TViewModel> getViewModelClass();
}

