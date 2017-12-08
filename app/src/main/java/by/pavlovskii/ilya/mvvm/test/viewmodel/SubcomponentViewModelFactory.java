package by.pavlovskii.ilya.mvvm.test.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;
import android.util.Log;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Singleton;

import by.pavlovskii.ilya.mvvm.test.activity.main.MainSubComponent;
import by.pavlovskii.ilya.mvvm.test.activity.main.MainViewModel;
import by.pavlovskii.ilya.mvvm.test.fragments.timer.TimerSubComponent;
import by.pavlovskii.ilya.mvvm.test.fragments.timer.TimerViewModel;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 08.12.2017<br>
 * Time: 14:37<br>
 * Project name: MVVMtest<br>
 * ===================================================================================<br>
 */
@Singleton
public class SubcomponentViewModelFactory implements ViewModelProvider.Factory {

    static final String TAG = SubcomponentViewModelFactory.class.getSimpleName();
    //private final Map<Class, Callable<? extends ViewModel>> creators = new HashMap<>();
    private final Map<Class, Object> creators = new HashMap<>();

    public SubcomponentViewModelFactory(MainSubComponent.Builder mainBuilder) {
        creators.put(MainViewModel.class, mainBuilder);
    }

    public void addCreator(TimerSubComponent.Builder timerBuilder) {
        creators.put(TimerViewModel.class, timerBuilder);
    }

    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        //Callable<? extends ViewModel> creator = creators.get(modelClass);
        Log.d(TAG, "create: " + modelClass);
        Object object = creators.get(modelClass);
        try {
            if (modelClass.isAssignableFrom(MainViewModel.class)) {
                return (T) ((MainSubComponent.Builder) object)
                        .build()
                        .viewModel();
            } else if (modelClass.isAssignableFrom(TimerViewModel.class)) {
                return (T) ((TimerSubComponent.Builder) object)
                        .build()
                        .viewModel();
            }
        } catch (Throwable t) {
            return null;
        }
        return null;
    }

//        if (creator == null) {
//            for (Map.Entry<Class, Callable<? extends ViewModel>> entry : creators.entrySet()) {
//                if (modelClass.isAssignableFrom(entry.getKey())) {
//                    creator = entry.getValue();
//                    break;
//                }
//            }
//        }
//        if (creator == null) {
//            throw new IllegalArgumentException("Unknown model class " + modelClass);
//        }
//        try {
//            return (T) creator.call();
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    @Override
//    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
//        Callable<? extends ViewModel> creator = creators.get(modelClass);
//        Log.d(TAG, "create: " + modelClass);
//        if (creator == null) {
//            for (Map.Entry<Class, Callable<? extends ViewModel>> entry : creators.entrySet()) {
//                if (modelClass.isAssignableFrom(entry.getKey())) {
//                    creator = entry.getValue();
//                    break;
//                }
//            }
//        }
//        if (creator == null) {
//            throw new IllegalArgumentException("Unknown model class " + modelClass);
//        }
//        try {
//            return (T) creator.call();
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
}
