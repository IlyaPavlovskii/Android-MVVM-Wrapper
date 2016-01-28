package by.pavlovskii.ilya.mvvm.test.activity;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.seppius.i18n.plurals.PluralResources;

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
        PluralResources pr = null;
        try {
            pr = new PluralResources(getResources());
            pr.setTreatZero(true);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        for (int i = 0; i <= 10; i++) {
            String val = pr.getQuantityString(R.plurals.plurals_1, i);
            Log.d(TAG, "Val: " + val);
        }
        Log.d(TAG, "===================================");
        for (int i = 0; i <= 10; i++) {
            String val = getResources().getQuantityString(R.plurals.plurals_1, i, i);
            Log.d(TAG, "Val: " + val);
        }
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

    @OnClick(R.id.vBtnChangeStatus)
    public void onChangeStatus(View view) {
        ProfileModel profileModel = mViewModel.mProfileModel;
        profileModel.status.set(66);
    }
}
