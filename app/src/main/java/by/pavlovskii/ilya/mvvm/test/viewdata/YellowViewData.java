package by.pavlovskii.ilya.mvvm.test.viewdata;

import android.databinding.ObservableField;
import android.util.Log;

import javax.inject.Inject;

import by.mvvmwrapper.viewdata.BaseViewData;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 03.12.2017<br>
 * Time: 15:42<br>
 * Project name: MVVMtest<br>
 * ===================================================================================<br>
 */
public class YellowViewData extends BaseViewData {

    private static int sCounter = 0;

    public ObservableField<String> text = new ObservableField<>();

    @Inject
    public YellowViewData() {
        ++sCounter;
        text.set("Counter: " + sCounter);
        Log.d(TAG, "constructor. Counter: " + sCounter);
    }

    @Override
    public void destroy() {
        super.destroy();
        --sCounter;
        Log.d(TAG, "destroy. Counter: " + sCounter);
    }
}
