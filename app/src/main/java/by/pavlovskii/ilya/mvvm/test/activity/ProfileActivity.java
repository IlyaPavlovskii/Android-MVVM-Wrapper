package by.pavlovskii.ilya.mvvm.test.activity;

import android.content.Context;
import android.content.Intent;
import android.databinding.BindingAdapter;
import android.os.Message;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.seppius.i18n.plurals.PluralResources;

import java.util.List;

import butterknife.OnClick;
import by.mvvmwrapper.activity.BaseActivity;
import by.pavlovskii.ilya.mvvm.test.R;
import by.pavlovskii.ilya.mvvm.test.adapters.ProfileAdapter;
import by.pavlovskii.ilya.mvvm.test.bindingmodels.ProfileViewData;
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

    @Override
    protected void handleMessage(Message msg) {
        Log.d(TAG, "Message: " + msg.what);
    }

    //======================================================
    //------------------------Events------------------------
    //======================================================
    @OnClick(R.id.vBtnCheck)
    public void onCheckClick(View view){

        Toast.makeText(view.getContext(), "Profile model: " + mViewModel.profileViewData, Toast.LENGTH_SHORT).show();
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
        mViewModel.profileViewData.name.set("Alexi");
        mViewModel.profileViewData.surname.set("Laiho");
        mViewModel.profileViewData.phone.set("9379992");
        try {
            sendCommand(Message.obtain(null, 123));
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @OnClick(R.id.vBtnChangeCheckbox)
    public void onChangeCheckBox(View view) {
        boolean val = mViewModel.profileViewData.bool.getValue();
        mViewModel.profileViewData.bool.set(!val);
        try {
            sendCommand(Message.obtain(null, 100));
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @OnClick(R.id.vBtnChangeStatus)
    public void onChangeStatus(View view) {
        mViewModel.profileViewData.status.set(55);
    }

    @OnClick(R.id.vBtnSpellChecker)
    public void onSpellCheckerClick(View view) {
        Intent intent = new Intent(view.getContext(), SpellCheckerActivity.class);
        startActivity(intent);
    }

    //======================================================
    //------------------Binding adapters--------------------
    //======================================================
    @BindingAdapter({"attr:adapter"})
    public static void bindAdapter(@NonNull RecyclerView recyclerView,
                                   @Nullable List<ProfileViewData> list) {
        if (list != null) {
            Context context = recyclerView.getContext();
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            recyclerView.setAdapter(new ProfileAdapter(context, list));
        }
    }
}
