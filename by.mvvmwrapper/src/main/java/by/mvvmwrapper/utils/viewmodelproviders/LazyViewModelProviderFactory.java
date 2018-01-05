package by.mvvmwrapper.utils.viewmodelproviders;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import by.mvvmwrapper.viewmodel.BaseViewModel;
import dagger.Lazy;

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

    private Class<T> mClass;
    private Lazy<T> mLazy;

    public LazyViewModelProviderFactory(Class<T> clazz, Lazy<T> lazy) {
        this.mClass = clazz;
        this.mLazy = lazy;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(mClass)) {
            return (T) mLazy.get();
        }
        return null;
    }
}
