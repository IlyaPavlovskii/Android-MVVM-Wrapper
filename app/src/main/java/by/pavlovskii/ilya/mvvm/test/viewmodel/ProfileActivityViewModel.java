package by.pavlovskii.ilya.mvvm.test.viewmodel;

import android.content.Context;
import android.support.annotation.NonNull;

import by.pavlovskii.ilya.mvvm.test.bindmodels.ProfileViewData;
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
public class ProfileActivityViewModel implements IViewModel<ProfileViewData, ActivityProfileBinding> {

    //======================================================
    //------------------------Fields------------------------
    //======================================================
    public ProfileViewData profileViewData;

    //======================================================
    //-------------------Override methods-------------------
    //======================================================
    @Override
    public void bindViewData(@NonNull Context context, ActivityProfileBinding viewDataBinding) {
        viewDataBinding.setProfile(profileViewData);
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

    //======================================================
    //---------------------Init methods---------------------
    //======================================================

    //======================================================
    //------------------------Events------------------------
    //======================================================

    //======================================================
    //--------------------Private methods-------------------
    //======================================================

    //======================================================
    //-------------------Protected methods------------------
    //======================================================

    //======================================================
    //---------------------Public methods-------------------
    //======================================================

    //======================================================
    //-----------------------Listeners----------------------
    //======================================================

    //======================================================
    //---------------------Inner classes--------------------
    //======================================================
}
