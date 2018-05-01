package by.mvvmwrapper.fragments;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import javax.inject.Inject;

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
public abstract class BaseDaggerFragmentSupport<M extends BaseViewModel, B extends ViewDataBinding>
        extends BaseFragmentSupport<M, B> {

    //======================================================
    //------------------------Fields------------------------
    //======================================================
    @Inject
    ViewModelProvider.Factory mViewModelProviderFactory;



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
    protected M initViewModel() {
        return ViewModelProviders
                .of(this, getViewModelFactory())
                .get(getViewModelClass());
    }

    //======================================================
    //-------------------Protected methods------------------
    //======================================================
    @NonNull
    protected ViewModelProvider.Factory getViewModelFactory() {
        return mViewModelProviderFactory;
    }

    //======================================================
    //-------------------Abstract methods-------------------
    //======================================================
    protected abstract Class<M> getViewModelClass();
}

