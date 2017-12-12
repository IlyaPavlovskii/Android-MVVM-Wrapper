package by.pavlovskii.ilya.mvvm.test.ui.activity;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

import javax.inject.Inject;

import by.mvvmwrapper.activity.BaseDialogAppCompatActivity;
import by.mvvmwrapper.interfaces.DialogActionsDelegate;
import by.mvvmwrapper.viewmodel.BaseViewModel;
import by.pavlovskii.ilya.mvvm.test.R;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;
import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.Router;
import ru.terrakok.cicerone.android.navigator.IActivityNavigator;
import ru.terrakok.cicerone.android.navigator.ISystemMessageActions;
import ru.terrakok.cicerone.android.navigator.ISystemMessageNavigator;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 14.11.2017<br>
 * Time: 18:35<br>
 * Project name: MVVMtest<br>
 * ===================================================================================<br>
 */
public abstract class BaseActivity<TViewModel extends BaseViewModel, TViewDataBinding extends ViewDataBinding>
        extends BaseDialogAppCompatActivity<TViewModel, TViewDataBinding>
        implements ISystemMessageActions, DialogActionsDelegate, HasSupportFragmentInjector {

    @Inject
    DispatchingAndroidInjector<Fragment> mFragmentInjector;
    @Inject
    protected Router mRouter;
    @Inject
    NavigatorHolder mNavigatorHolder;

    private Navigator mNavigator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mNavigator = initNavigator();
    }

    @NonNull
    @Override
    protected TViewModel initViewModel() {
        return ViewModelProviders
                .of(this, getViewModelProviderFactory())
                .get(getViewModelClass());
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return mFragmentInjector;
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mNavigatorHolder != null && mNavigator != null) {

            if (mNavigator instanceof IActivityNavigator) {
                ((IActivityNavigator) mNavigator).setActivity(this);
            }
            if (mNavigator instanceof ISystemMessageNavigator) {
                ((ISystemMessageNavigator) mNavigator).setSystemMessageActions(this);
            }

            mNavigatorHolder.setNavigator(mNavigator);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mNavigatorHolder != null) {

            if (mNavigator instanceof IActivityNavigator) {
                ((IActivityNavigator) mNavigator).setActivity(null);
            }
            if (mNavigator instanceof ISystemMessageNavigator) {
                ((ISystemMessageNavigator) mNavigator).setSystemMessageActions(null);
            }

            mNavigatorHolder.removeNavigator();
        }
    }


    @Override
    public void showMessage(@NonNull String message) {
        getAlertDialogBuilder()
                .title(R.string.app_name)
                .content(message)
                .build()
                .show();
    }

    protected Navigator initNavigator() {
        return null;
    }

    @NonNull
    protected abstract ViewModelProvider.Factory getViewModelProviderFactory();

    protected abstract Class<TViewModel> getViewModelClass();

}
