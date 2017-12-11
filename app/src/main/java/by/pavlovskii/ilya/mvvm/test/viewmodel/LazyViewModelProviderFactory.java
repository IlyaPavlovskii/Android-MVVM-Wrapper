package by.pavlovskii.ilya.mvvm.test.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;
import android.util.Log;

import javax.inject.Provider;

import by.mvvmwrapper.viewmodel.BaseViewModel;
import by.pavlovskii.ilya.mvvm.test.activity.main.MainViewModel;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 09.12.2017<br>
 * Time: 19:34<br>
 * Project name: MVVMtest<br>
 * ===================================================================================<br>
 */
public class LazyViewModelProviderFactory<T extends BaseViewModel> implements ViewModelProvider.Factory {

    //private Lazy<T> mLazy;
    private Provider<T> mProvider;

    public LazyViewModelProviderFactory(Provider<T> provider) {
        this.mProvider = provider;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        Log.d("LazyViewModelProviderFactory", "CREATE: " + modelClass);
        if (modelClass.isAssignableFrom(MainViewModel.class)) {
            return (T) mProvider.get();
        }
        return null;
    }
}
