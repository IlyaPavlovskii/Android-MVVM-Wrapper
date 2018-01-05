package by.pavlovskii.ilya.mvvm.test.ui.activity.main;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import javax.inject.Inject;

import by.pavlovskii.ilya.mvvm.test.R;
import by.pavlovskii.ilya.mvvm.test.databinding.ActivityMainBinding;
import by.pavlovskii.ilya.mvvm.test.di.Injector;
import by.pavlovskii.ilya.mvvm.test.storage.Constants;
import by.pavlovskii.ilya.mvvm.test.ui.activity.BaseActivity;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import ru.terrakok.cicerone.Navigator;
import timber.log.Timber;

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
public class MainActivity extends BaseActivity<MainViewModel, ActivityMainBinding> {

    @Inject
    Navigator mNavigator;

    private final CompositeDisposable mDisposable = new CompositeDisposable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            Timber.d("TimerFragment. Replace");
            mRouter.navigateTo(Constants.FragmentKeys.TIMER);
            mRouter.navigateTo(Constants.FragmentKeys.TIMER, 1);
        }
    }

    @Nullable
    @Override
    protected android.databinding.DataBindingComponent getDataBindingComponent() {
        return Injector.getApplicationComponent();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mDisposable.addAll(navigateToDisposable());
    }

    @Override
    protected void onStop() {
        super.onStop();
        mDisposable.clear();
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected Navigator initNavigator() {
        return mNavigator;
    }

    @Override
    protected Class<MainViewModel> getViewModelClass() {
        return MainViewModel.class;
    }

    //===================================================================================
    //---------------------------------View action callback------------------------------
    //===================================================================================
    private Disposable navigateToDisposable() {
        return getViewModel()
                .navigateToScreen()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(demoActivity -> {
                    switch (demoActivity.getCommand()) {
                        case Constants.Command.NAVIGATE_TO:
                            mRouter.navigateTo(demoActivity.getScreen());
                            break;
                        case Constants.Command.REPLACE:
                            mRouter.replaceScreen(demoActivity.getScreen());
                            break;
                        case Constants.Command.NEW_ROOT_SCREEN:
                            mRouter.newRootScreen(demoActivity.getScreen());
                            break;
                        case Constants.Command.SHOW_SYSTEM_MESSAGE:
                            mRouter.showSystemMessage(demoActivity.getScreen());
                            break;
                        case Constants.Command.EXIT:
                            mRouter.exit();
                            break;
                    }
                }, throwable -> getViewModel().handleException(throwable));
    }

}
