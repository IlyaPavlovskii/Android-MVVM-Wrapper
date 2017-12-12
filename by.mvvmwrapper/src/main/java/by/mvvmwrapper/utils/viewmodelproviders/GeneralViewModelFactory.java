package by.mvvmwrapper.utils.viewmodelproviders;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;
import android.util.Log;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Provider;

import by.mvvmwrapper.viewmodel.BaseViewModel;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 09.12.2017<br>
 * Time: 22:41<br>
 * Project name: MVVMtest<br>
 * ===================================================================================<br>
 */
public class GeneralViewModelFactory<T extends BaseViewModel> implements ViewModelProvider.Factory {

    private final static String TAG = GeneralViewModelFactory.class.getSimpleName();
    private final Map<Class<T>, Provider<T>> mProviderMap = new HashMap<>();

    public GeneralViewModelFactory() {
    }

    public GeneralViewModelFactory(Class<T> clazz, Provider<T> provider) {
        put(clazz, provider);
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        Log.d(TAG, "create: " + modelClass);

        Provider provider = mProviderMap.get(modelClass);
        if (provider != null) {
            return (T) provider.get();
        }
        return null;
    }

    public void put(Class<T> clazz, Provider<T> provider) {
        mProviderMap.put(clazz, provider);
    }

}
