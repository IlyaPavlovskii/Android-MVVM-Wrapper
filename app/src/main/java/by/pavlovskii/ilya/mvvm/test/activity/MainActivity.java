package by.pavlovskii.ilya.mvvm.test.activity;

import android.support.annotation.NonNull;

import by.mvvmwrapper.activity.BaseAppCompatActivity;
import by.pavlovskii.ilya.mvvm.test.R;
import by.pavlovskii.ilya.mvvm.test.databinding.ActivityMainBinding;
import by.pavlovskii.ilya.mvvm.test.interfaces.MainViewActionCallback;
import by.pavlovskii.ilya.mvvm.test.viewdata.MainViewData;
import by.pavlovskii.ilya.mvvm.test.viewmodel.MainViewModel;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 10.11.2017<br>
 * Time: 17:32<br>
 * Project name: MVVMtest<br>
 * ===================================================================================<br>
 * Default activity implementation based on MVVM framework<br>
 * ===================================================================================<br>
 */
public class MainActivity extends BaseAppCompatActivity<MainViewModel, ActivityMainBinding>
        implements MainViewActionCallback {

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_main;
    }

    @NonNull
    @Override
    protected MainViewModel initViewModel() {
        MainViewData viewData = new MainViewData();
        return new MainViewModel(viewData, this);
    }

    //===================================================================================
    //---------------------------------View action callback------------------------------
    //===================================================================================
    @Override
    public void onFailure(Throwable throwable) {
        // TODO: 10.11.2017 Process error
    }
}
