package by.pavlovskii.ilya.mvvm.test.handlers;

import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;

import by.pavlovskii.ilya.mvvm.test.viewdata.ProfileViewData;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 15.06.16<br>
 * Time: 0:13<br>
 * Project name: MVVMtest<br>
 * ===================================================================================
 * {@link by.pavlovskii.ilya.mvvm.test.activity.ProfileActivity} action listener handler<br>
 * ===================================================================================
 */
public class ProfileHandler {

    //======================================================
    //----------------------Interface-----------------------
    //======================================================
    public interface ProfileHandlerListener {
        ProfileViewData getViewData();
    }

    //======================================================
    //------------------------Fields------------------------
    //======================================================
    @NonNull
    private final ProfileHandlerListener mProfileHandlerListener;

    //======================================================
    //---------------------Constructors---------------------
    //======================================================
    public ProfileHandler(@NonNull ProfileHandlerListener handlerListener) {
        this.mProfileHandlerListener = handlerListener;
    }

    //======================================================
    //-----------------------Listeners----------------------
    //======================================================
    public View.OnClickListener onChangeStatusListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Log.d("onClick", "Click: " + (mProfileHandlerListener.getViewData() == null));
            if (mProfileHandlerListener.getViewData() != null) {
                Log.d("onClick", "Status: " + mProfileHandlerListener.getViewData().status.getValue());
                mProfileHandlerListener.getViewData().status.set(55);
            }
        }
    };
}
