package by.pavlovskii.ilya.mvvm.test.ui.activity.yellow;

import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;

import javax.inject.Inject;

import by.mvvmwrapper.viewmodel.SimpleViewModelImpl;
import by.pavlovskii.ilya.mvvm.test.databinding.ActivityYellowBinding;
import timber.log.Timber;

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

    @Inject
    public YellowViewModel(@NonNull YellowViewData viewData) {
        super(viewData);
        Timber.d("constructor");
    }

    @Override
    public void bindViewData(@NonNull ViewDataBinding viewDataBinding) {
        Timber.d("bind: %s", hashCode());
        ((ActivityYellowBinding) viewDataBinding).setModel(mViewData);
    }
}
