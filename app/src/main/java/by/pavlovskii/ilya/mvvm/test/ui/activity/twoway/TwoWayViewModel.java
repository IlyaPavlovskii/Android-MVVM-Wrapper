package by.pavlovskii.ilya.mvvm.test.ui.activity.twoway;

import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import by.mvvmwrapper.viewmodel.SimpleViewModelImpl;
import by.pavlovskii.ilya.mvvm.test.databinding.ActivityTwoWayBinding;

import javax.inject.Inject;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 12.05.2018<br>
 * Time: 18:01<br>
 * Project name: MVVMtest<br>
 * ===================================================================================<br>
 */
public class TwoWayViewModel extends SimpleViewModelImpl<TwoWayViewData> {

    @Inject
    public TwoWayViewModel(@NonNull TwoWayViewData viewData) {
        super(viewData);
    }

    @Override
    public void bindViewData(@NonNull ViewDataBinding viewDataBinding) {
        ((ActivityTwoWayBinding) viewDataBinding).setModel(mViewData);
    }
}
