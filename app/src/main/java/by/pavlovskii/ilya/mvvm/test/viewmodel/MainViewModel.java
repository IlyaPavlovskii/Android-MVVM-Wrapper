package by.pavlovskii.ilya.mvvm.test.viewmodel;

import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.NonNull;

import java.util.Arrays;

import by.mvvmwrapper.viewmodel.SimpleViewModelImpl;
import by.pavlovskii.ilya.mvvm.test.databinding.ActivityMainBinding;
import by.pavlovskii.ilya.mvvm.test.interfaces.MainViewActionCallback;
import by.pavlovskii.ilya.mvvm.test.viewdata.MainViewData;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 10.11.2017<br>
 * Time: 17:32<br>
 * Project name: MVVMtest<br>
 * ===================================================================================
 * {@link by.pavlovskii.ilya.mvvm.test.activity.MainActivity} view model component<br>
 * ===================================================================================
 */
public class MainViewModel extends SimpleViewModelImpl<MainViewData, MainViewActionCallback> {

    public MainViewModel(@NonNull MainViewData viewData, @NonNull MainViewActionCallback actionCallback) {
        super(viewData, actionCallback);
    }

    @Override
    public void bindViewData(@NonNull ViewDataBinding viewDataBinding) {
        ((ActivityMainBinding) viewDataBinding).setModel(mViewData);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String[] array = {"Demo 1", "Demo 2", "Demo 3", "Demo 4", "Demo 5"};
        mViewData.demoList.addAll(Arrays.asList(array));
    }
}
