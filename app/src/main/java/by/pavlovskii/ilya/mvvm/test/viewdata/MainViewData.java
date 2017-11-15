package by.pavlovskii.ilya.mvvm.test.viewdata;

import android.databinding.ObservableArrayList;

import by.mvvmwrapper.viewdata.SimpleViewData;
import by.pavlovskii.ilya.mvvm.test.models.DemoActivity;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 10.11.2017<br>
 * Time: 17:33<br>
 * Project name: MVVMtest<br>
 * ===================================================================================<br>
 * {@link by.pavlovskii.ilya.mvvm.test.activity.MainActivity} view data component implementation<br>
 * ===================================================================================
 */
public class MainViewData extends SimpleViewData {

    public ObservableArrayList<DemoActivity> demoList = new ObservableArrayList<>();

    @Override
    public void destroy() {
        super.destroy();
        demoList.clear();
        demoList = null;
    }
}
