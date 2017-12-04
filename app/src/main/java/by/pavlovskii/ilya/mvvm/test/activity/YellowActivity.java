package by.pavlovskii.ilya.mvvm.test.activity;

import android.content.Intent;
import android.os.Bundle;

import javax.inject.Inject;

import by.pavlovskii.ilya.mvvm.test.R;
import by.pavlovskii.ilya.mvvm.test.databinding.ActivityYellowBinding;
import by.pavlovskii.ilya.mvvm.test.storage.Constants;
import by.pavlovskii.ilya.mvvm.test.viewmodel.YellowViewModel;
import ru.terrakok.cicerone.Navigator;

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
public class YellowActivity extends BaseActivity<YellowViewModel, ActivityYellowBinding> {

    @Inject
    Navigator mNavigator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding.setOnRootClickListener(v -> mRouter.newRootScreen(Constants.ActivityKeys.MAIN));
        mBinding.setOnYellowClickListener(v -> mRouter.navigateTo(Constants.ActivityKeys.YELLOW));
    }

    @Override
    protected Class<YellowViewModel> getViewModelClass() {
        return YellowViewModel.class;
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_yellow;
    }

    @Override
    protected Navigator initNavigator() {
        return mNavigator;
    }
}
