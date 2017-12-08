package by.pavlovskii.ilya.mvvm.test.activity.main;

import android.databinding.ObservableArrayList;
import android.databinding.ObservableField;

import javax.inject.Inject;

import by.mvvmwrapper.viewdata.SimpleViewData;
import by.pavlovskii.ilya.mvvm.test.activity.main.MainActivity;
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
 * {@link MainActivity} view data component implementation<br>
 * ===================================================================================
 */
public class MainViewData extends SimpleViewData {

    public ObservableArrayList<DemoActivity> demoList = new ObservableArrayList<>();
    public ObservableField<String> info = new ObservableField<>("");

    public MainViewData() {
    }

    @Override
    public void destroy() {
        super.destroy();
        demoList.clear();
        demoList = null;
    }
}
