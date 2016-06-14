package by.pavlovskii.ilya.mvvm.test.activity;

import android.support.annotation.NonNull;

import by.mvvmwrapper.activity.BaseActivity;
import by.pavlovskii.ilya.mvvm.test.R;
import by.pavlovskii.ilya.mvvm.test.databinding.ActivityProfileBinding;
import by.pavlovskii.ilya.mvvm.test.viewmodel.ProfileActivityViewModel;
/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 06.01.16<br>
 * Time: 12:30<br>
 * Project name: MVVMtest<br>
 * ===================================================================================
 * Binding collection data to list view<br>
 * ===================================================================================
 */
public class ProfileActivity extends BaseActivity<ProfileActivityViewModel, ActivityProfileBinding> {

    //======================================================
    //----------------------Constants-----------------------
    //======================================================
    private static final String TAG = ProfileActivity.class.getSimpleName();

    //======================================================
    //-------------------Override methods-------------------
    //======================================================
    @Override
    protected int getLayoutRes() {
        return R.layout.activity_profile;
    }

    @NonNull
    @Override
    protected ProfileActivityViewModel getViewModel() {
        return new ProfileActivityViewModel();
    }

}
