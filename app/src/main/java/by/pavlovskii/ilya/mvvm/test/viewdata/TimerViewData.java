package by.pavlovskii.ilya.mvvm.test.viewdata;

import android.databinding.ObservableField;

import javax.inject.Inject;

import by.mvvmwrapper.viewdata.SimpleViewData;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 27.11.2017<br>
 * Time: 8:51<br>
 * Project name: MVVMtest<br>
 * ===================================================================================<br>
 */
public class TimerViewData extends SimpleViewData {

    public ObservableField<String> time = new ObservableField<>("");

    @Inject
    public TimerViewData() {
    }
}
