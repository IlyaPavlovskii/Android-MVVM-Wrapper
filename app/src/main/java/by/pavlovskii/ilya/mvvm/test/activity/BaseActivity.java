package by.pavlovskii.ilya.mvvm.test.activity;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.NonNull;

import javax.inject.Inject;

import by.mvvmwrapper.activity.BaseDialogAppCompatActivity;
import by.mvvmwrapper.interfaces.DialogActionsDelegate;
import by.mvvmwrapper.viewmodel.BaseViewModel;
import by.pavlovskii.ilya.mvvm.test.R;
import dagger.android.AndroidInjection;
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
        implements ISystemMessageActions, DialogActionsDelegate {

    @Inject
    protected Router mRouter;
    @Inject
    NavigatorHolder mNavigatorHolder;

    @Inject
    ViewModelProvider.Factory mViewModelFactory;

    private Navigator mNavigator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        mNavigator = initNavigator();
    }

    @NonNull
    @Override
    protected TViewModel initViewModel() {
        return ViewModelProviders
                .of(this, mViewModelFactory)
                .get(getViewModelClass());
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

    protected abstract Class<TViewModel> getViewModelClass();

}
