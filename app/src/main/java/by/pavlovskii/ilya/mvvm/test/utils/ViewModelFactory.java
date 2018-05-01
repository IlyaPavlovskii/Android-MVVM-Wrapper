package by.pavlovskii.ilya.mvvm.test.utils;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import java.util.Map;

import javax.inject.Inject;
import javax.inject.Provider;

import by.mvvmwrapper.viewmodel.BaseViewModel;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 01.05.2018<br>
 * Time: 19:17<br>
 * Project name: MVVMtest<br>
 * ===================================================================================<br>
 */
public class ViewModelFactory implements ViewModelProvider.Factory {

    private final Map<Class<? extends BaseViewModel>, Provider<BaseViewModel>> mViewModelCreator;

    @Inject
    public ViewModelFactory(@NonNull Map<Class<? extends BaseViewModel>, Provider<BaseViewModel>> creators) {
        this.mViewModelCreator = creators;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        Provider<? extends BaseViewModel> creator = mViewModelCreator.get(modelClass);
        if (creator == null) {
            for (Map.Entry<Class<? extends BaseViewModel>, Provider<BaseViewModel>> entry : mViewModelCreator.entrySet()) {
                if (modelClass.isAssignableFrom(entry.getKey())) {
                    creator = entry.getValue();
                    break;
                }
            }
        }

        if (creator == null) {
            throw new IllegalArgumentException("Unknown ViewModel class " + modelClass);
        }
        try {
            return ((T) creator.get());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
