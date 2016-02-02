package by.pavlovskii.ilya.mvvm.test.activity;

import android.os.Message;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.view.View;

import butterknife.OnClick;
import by.mvvmwrapper.activity.BaseActivity;
import by.mvvmwrapper.viewmodel.IViewModel;
import by.pavlovskii.ilya.mvvm.test.R;
import by.pavlovskii.ilya.mvvm.test.viewmodel.SpellCheckerActivityViewModel;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 02.02.16<br>
 * Time: 22:17<br>
 * Project name: MVVMtest<br>
 * ===================================================================================
 * //TODO Add description<br>
 * ===================================================================================
 */
public class SpellCheckerActivity extends BaseActivity {

    //======================================================
    //----------------------Interfaces----------------------
    //======================================================

    //======================================================
    //----------------------Constants-----------------------
    //======================================================

    //======================================================
    //---------------------View components------------------
    //======================================================

    //======================================================
    //------------------------Fields------------------------
    //======================================================

    //======================================================
    //---------------------Constructors---------------------
    //======================================================

    //======================================================
    //-------------------Override methods-------------------
    //======================================================
    @Override
    protected int getLayoutRes() {
        return R.layout.activity_spell_checker;
    }

    @NonNull
    @Override
    protected IViewModel getViewModel() {
        return new SpellCheckerActivityViewModel();
    }

    @Override
    protected void handleMessage(Message msg) {

    }

    //======================================================
    //------------------------Events------------------------
    //======================================================
    @OnClick(R.id.vBtnCheck)
    public void onCheckClick(View view) {
        try {
            sendCommand(Message.obtain(null, SpellCheckerActivityViewModel.CHECK_DATA_METHOD));
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

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
