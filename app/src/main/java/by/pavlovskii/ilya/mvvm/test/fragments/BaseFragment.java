package by.pavlovskii.ilya.mvvm.test.fragments;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;

import javax.inject.Inject;

import by.mvvmwrapper.fragments.BaseFragmentSupport;
import by.mvvmwrapper.viewmodel.BaseViewModel;
import ru.terrakok.cicerone.Router;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 27.11.2017<br>
 * Time: 8:48<br>
 * Project name: MVVMtest<br>
 * ===================================================================================<br>
 */
public abstract class BaseFragment<TViewModel extends BaseViewModel, TViewDataBinding extends ViewDataBinding>
        extends BaseFragmentSupport<TViewModel, TViewDataBinding> {

    //======================================================
    //------------------------Fields------------------------
    //======================================================
    @Inject
    protected Router mRouter;

    @Inject
    ViewModelProvider.Factory mViewModelFactory;

    @NonNull
    @Override
    protected TViewModel initViewModel() {
        return ViewModelProviders
                .of(this, mViewModelFactory)
                .get(getViewModelClass());
    }

    protected abstract Class<TViewModel> getViewModelClass();
}
