package by.pavlovskii.ilya.mvvm.test.activity.yellow;

import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.util.Log;

import by.mvvmwrapper.viewmodel.SimpleViewModelImpl;
import by.pavlovskii.ilya.mvvm.test.databinding.ActivityYellowBinding;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 08.12.2017<br>
 * Time: 3:03<br>
 * Project name: MVVMtest<br>
 * ===================================================================================<br>
 */
public class YellowViewModel extends SimpleViewModelImpl<YellowViewData> {

    public YellowViewModel(@NonNull YellowViewData viewData) {
        super(viewData);
        Log.d(TAG, "constructor");
    }

    @Override
    public void bindViewData(@NonNull ViewDataBinding viewDataBinding) {
        Log.d(TAG, "bind" + hashCode());
        ((ActivityYellowBinding) viewDataBinding).setModel(mViewData);
    }
}
