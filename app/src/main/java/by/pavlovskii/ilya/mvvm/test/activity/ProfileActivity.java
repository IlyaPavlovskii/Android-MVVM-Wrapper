package by.pavlovskii.ilya.mvvm.test.activity;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Toast;

import butterknife.OnClick;
import by.pavlovskii.ilya.mvvm.test.R;
import by.pavlovskii.ilya.mvvm.test.models.ProfileModel;
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
public class ProfileActivity extends BaseActivity<ProfileActivityViewModel> {

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

    //======================================================
    //------------------------Events------------------------
    //======================================================
    @OnClick(R.id.vBtnCheck)
    public void onCheckClick(View view){
        Toast.makeText(view.getContext(), "Profile model: " + mViewModel.mProfileModel, Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.vBtnChange)
    public void onChangeClick(View view){
        ProfileModel profileModel = mViewModel.mProfileModel;
        profileModel.name.set("Ivan");
        profileModel.surname.set("Ivanov");
        profileModel.phone.set("9379992");
    }

    @OnClick(R.id.vBtnChangeCheckbox)
    public void onChangeCheckBox(View view) {
        ProfileModel profileModel = mViewModel.mProfileModel;
        profileModel.bool.set(!profileModel.bool.getValue());
    }


}
