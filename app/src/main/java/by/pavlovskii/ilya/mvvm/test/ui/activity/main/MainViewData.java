package by.pavlovskii.ilya.mvvm.test.ui.activity.main;

import android.databinding.ObservableField;
import by.mvvmwrapper.viewdata.SimpleViewData;

import javax.inject.Inject;

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

    public final ObservableField<String> info = new ObservableField<>("");

    @Inject
    public MainViewData() {
    }

}
