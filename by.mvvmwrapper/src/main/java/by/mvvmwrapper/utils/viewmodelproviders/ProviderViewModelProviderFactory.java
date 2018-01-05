package by.mvvmwrapper.utils.viewmodelproviders;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import javax.inject.Provider;

import by.mvvmwrapper.viewmodel.BaseViewModel;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 12.12.2017<br>
 * Time: 19:18<br>
 * Project name: MVVMtest<br>
 * ===================================================================================<br>
 */
public class ProviderViewModelProviderFactory<T extends BaseViewModel> implements ViewModelProvider.Factory {

    private Class<T> mClass;
    private Provider<T> mProvider;

    public ProviderViewModelProviderFactory(Class<T> clazz, Provider<T> provider) {
        this.mClass = clazz;
        this.mProvider = provider;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(mClass)) {
            return (T) mProvider.get();
        }
        return null;
    }
}
