package by.pavlovskii.ilya.mvvm.test.activity.yellow;

import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import javax.inject.Inject;

import by.pavlovskii.ilya.mvvm.test.R;
import by.pavlovskii.ilya.mvvm.test.activity.BaseActivity;
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
public class YellowActivity extends BaseActivity<YellowViewModel, ActivityYellowBinding> {


    @Override
    protected int getLayoutRes() {
        return R.layout.activity_yellow;
    }

    @NonNull
    @Override
    protected YellowViewModel initViewModel() {
        return null;
    }


    @Override
    protected Class<YellowViewModel> getViewModelClass() {
        return YellowViewModel.class;
    }
}
