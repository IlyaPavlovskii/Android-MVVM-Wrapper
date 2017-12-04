package by.pavlovskii.ilya.mvvm.test.viewmodel;

import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;

import javax.inject.Inject;

import by.mvvmwrapper.viewmodel.SimpleViewModelImpl;
import by.pavlovskii.ilya.mvvm.test.databinding.ActivityYellowBinding;
import by.pavlovskii.ilya.mvvm.test.viewdata.YellowViewData;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 03.12.2017<br>
 * Time: 15:41<br>
 * Project name: MVVMtest<br>
 * ===================================================================================<br>
 */
public class YellowViewModel extends SimpleViewModelImpl<YellowViewData> {

    @Inject
    public YellowViewModel(@NonNull YellowViewData viewData) {
        super(viewData);
    }

    @Override
    public void bindViewData(@NonNull ViewDataBinding viewDataBinding) {
        ((ActivityYellowBinding) viewDataBinding).setModel(mViewData);
    }

}
