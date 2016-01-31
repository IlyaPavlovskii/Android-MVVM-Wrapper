package by.pavlovskii.ilya.mvvm.test.viewmodel;

import android.content.Context;
import android.os.Message;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.util.Log;

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
public class ProfileActivityViewModel extends BaseViewModel<ProfileViewData, ActivityProfileBinding> {

    //======================================================
    //------------------------Fields------------------------
    //======================================================
    public ProfileViewData profileViewData;

    //======================================================
    //-------------------Override methods-------------------
    //======================================================
    @Override
    public void bindViewData(@NonNull Context context, @NonNull ActivityProfileBinding viewDataBinding) {
        viewDataBinding.setProfile(profileViewData);
    }

    @Override
    public void handleMessage(Message message) {
        Log.d(TAG, "Message: " + message.what);
        switch (message.what) {
            case 100:
                try {
                    sendCommand(Message.obtain(null, 888666));
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    @Override
    public ProfileViewData initViewData() {
        profileViewData = new ProfileViewData();
        return profileViewData;
    }

    @Override
    public void destroy() {
        profileViewData = null;
    }

}
