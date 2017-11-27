package by.pavlovskii.ilya.mvvm.test.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;

import javax.inject.Inject;

import by.pavlovskii.ilya.mvvm.test.R;
import by.pavlovskii.ilya.mvvm.test.databinding.ActivityMainBinding;
import by.pavlovskii.ilya.mvvm.test.interfaces.MainViewActionCallback;
import by.pavlovskii.ilya.mvvm.test.viewmodel.MainViewModel;
import dagger.android.AndroidInjection;
import ru.terrakok.cicerone.Navigator;

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
public class MainActivity extends BaseActivity<MainViewModel, ActivityMainBinding>
        implements MainViewActionCallback {

    @Inject
    MainViewModel mMainViewModel;
    @Inject
    Navigator mNavigator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_main;
    }

    @NonNull
    @Override
    protected MainViewModel initViewModel() {
        return mMainViewModel;
    }

    @Override
    protected Navigator initNavigator() {
        return mNavigator;
    }

    //===================================================================================
    //---------------------------------View action callback------------------------------
    //===================================================================================
    @Override
    public void newRootScreen(String key, Object... data) {
        mRouter.newRootScreen(key, data);
    }

    @Override
    public void replaceScreen(String key, Object... data) {
        mRouter.replaceScreen(key, data);
    }

    @Override
    public void showSystemMessage(String message) {
        mRouter.showSystemMessage(message);
    }

    @Override
    public void navigateTo(String key, Object... data) {
        mRouter.navigateTo(key, data);
    }

    @Override
    public void exit() {
        mRouter.exit();
    }

    @Override
    public void onFailure(Throwable throwable) {
        handleException(throwable);
    }

}
