package by.pavlovskii.ilya.mvvm.test.viewmodel;

import android.content.Context;
import android.os.Message;
import android.support.annotation.NonNull;
import android.util.Log;

import by.mvvmwrapper.viewmodel.BaseViewModel;
import by.pavlovskii.ilya.mvvm.test.bindingmodels.SpellCheckerViewData;
import by.pavlovskii.ilya.mvvm.test.databinding.ActivitySpellCheckerBinding;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 02.02.16<br>
 * Time: 22:26<br>
 * Project name: MVVMtest<br>
 * ===================================================================================
 * //TODO Add description<br>
 * ===================================================================================
 */
public class SpellCheckerActivityViewModel extends BaseViewModel<SpellCheckerViewData, ActivitySpellCheckerBinding> {

    //======================================================
    //----------------------Interfaces----------------------
    //======================================================

    //======================================================
    //----------------------Constants-----------------------
    //======================================================
    public final static int CHECK_DATA_METHOD = 1;

    //======================================================
    //------------------------Fields------------------------
    //======================================================

    //======================================================
    //---------------------Constructors---------------------
    //======================================================

    //======================================================
    //-------------------Override methods-------------------
    //======================================================
    @NonNull
    @Override
    public SpellCheckerViewData initViewData() {
        return new SpellCheckerViewData();
    }

    @Override
    public void bindViewData(@NonNull Context context, @NonNull ActivitySpellCheckerBinding viewDataBinding) {
        viewDataBinding.setModel(mModel);
    }

    @Override
    public void handleMessage(@NonNull Message message) {
        switch (message.what) {
            case CHECK_DATA_METHOD:
                checkData();
                break;
        }
    }

    //======================================================
    //--------------------Private methods-------------------
    //======================================================
    private void checkData() {
        Log.d(TAG, "Check data: " + mModel.search);
    }
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
