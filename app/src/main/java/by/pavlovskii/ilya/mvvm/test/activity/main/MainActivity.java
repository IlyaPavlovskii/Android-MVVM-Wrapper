package by.pavlovskii.ilya.mvvm.test.activity.main;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

import javax.inject.Inject;

import by.pavlovskii.ilya.mvvm.test.R;
import by.pavlovskii.ilya.mvvm.test.activity.BaseActivity;
import by.pavlovskii.ilya.mvvm.test.databinding.ActivityMainBinding;
import by.pavlovskii.ilya.mvvm.test.di.Injector;
import by.pavlovskii.ilya.mvvm.test.storage.Constants;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
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
public class MainActivity extends BaseActivity<MainViewModel, ActivityMainBinding> implements HasSupportFragmentInjector {

    @Inject
    DispatchingAndroidInjector<Fragment> mFragmentInjector;
    @Inject
    Navigator mNavigator;
    //    @Inject
//    MainViewModel mMainViewModel;
    @Inject
    ViewModelProvider.Factory mFactory;

    private final CompositeDisposable mDisposable = new CompositeDisposable();

    // ===========
    @NonNull
    @Override
    protected MainViewModel initViewModel() {
        return ViewModelProviders
                .of(this, mFactory)
                .get(MainViewModel.class);
    }

    @Override
    protected Class<MainViewModel> getViewModelClass() {
        return MainViewModel.class;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Injector.getApplicationComponent()
                .mainViewModelSubComponentBuilder()
                .build()
                .mainActivitySubComponent()
                .build()
                .inject(this);
        super.onCreate(savedInstanceState);
//        if( savedInstanceState == null ){
//            Log.d(TAG, "Create fragments");
//            mRouter.replaceScreen(Constants.FragmentKeys.TIMER);
//            mRouter.replaceScreen(Constants.FragmentKeys.TIMER, 1);
//        }
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
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return mFragmentInjector;
    }

    //===================================================================================
    //---------------------------------View action callback------------------------------
    //===================================================================================
    private Disposable navigateToDisposable() {
        return initViewModel()
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
                }, throwable -> initViewModel().handleException(throwable));
    }

}
