package by.pavlovskii.ilya.mvvm.test.viewmodel;

import android.content.Context;
import android.os.Message;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.util.Log;

import by.mvvmwrapper.bindmodels.IViewData;
import by.pavlovskii.ilya.mvvm.test.activity.ProfileActivity;
import by.pavlovskii.ilya.mvvm.test.bindingmodels.ProfileViewData;
import by.mvvmwrapper.viewmodel.BaseViewModel;
import by.pavlovskii.ilya.mvvm.test.databinding.ActivityProfileBinding;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 06.01.16<br>
 * Time: 19:20<br>
 * Project name: MVVMtest<br>
 * ===================================================================================
 * //TODO Add description<br>
 * ===================================================================================
 */
public class ProfileActivityViewModel extends BaseViewModel<ProfileViewData, ActivityProfileBinding, ProfileActivity> {

    //======================================================
    //------------------------Fields------------------------
    //======================================================

    //======================================================
    //-------------------Override methods-------------------
    //======================================================
    @NonNull
    @Override
    public ProfileViewData initViewData() throws ClassNotFoundException {
        return new ProfileViewData();
    }

    @Override
    public void bindViewData(@NonNull ActivityProfileBinding viewDataBinding) {
        viewDataBinding.setProfile(mViewData);
    }

    //======================================================
    //---------------------Public methods-------------------
    //======================================================
    public void change() {
        mViewData.name.set("Alexi");
        mViewData.surname.set("Laiho");
        mViewData.phone.set("9379992");
    }

    public void changeCheckBox() {
        boolean val = mViewData.bool.getValue();
        mViewData.bool.set(!val);
    }

    public ProfileViewData getViewData() {
        return mViewData;
    }

    public void changeStatus() {
        mViewData.status.set(55);
    }
}
