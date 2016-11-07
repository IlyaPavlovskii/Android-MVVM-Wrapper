package by.pavlovskii.ilya.mvvm.test.viewmodel;

import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;

import javax.inject.Inject;

import by.mvvmwrapper.viewmodel.BaseViewModel;
import by.pavlovskii.ilya.mvvm.test.dagger.components.DaggerViewDataComponent;
import by.pavlovskii.ilya.mvvm.test.databinding.ActivityProfileBinding;
import by.pavlovskii.ilya.mvvm.test.handlers.ProfileHandler;
import by.pavlovskii.ilya.mvvm.test.viewdata.ProfileViewData;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 06.01.16<br>
 * Time: 19:20<br>
 * Project name: MVVMtest<br>
 * ===================================================================================
 * {@link by.pavlovskii.ilya.mvvm.test.activity.ProfileActivity} ViewModel component<br>
 * ===================================================================================
 */
public class ProfileActivityViewModel extends BaseViewModel<ProfileViewData> {

    //======================================================
    //------------------------Fields------------------------
    //======================================================
    @Inject
    ProfileHandler mProfileHandler;

    //======================================================
    //-------------------Override methods-------------------
    //======================================================
    @Override
    public void bindViewData(@NonNull ViewDataBinding viewDataBinding) {
        ((ActivityProfileBinding) viewDataBinding).setViewData(mViewData);
        ((ActivityProfileBinding) viewDataBinding).setHandler(mProfileHandler);
    }

    @Override
    protected void injectViewData() {
        DaggerViewDataComponent.create().inject(this);
    }
}
