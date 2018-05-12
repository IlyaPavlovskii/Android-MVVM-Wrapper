package by.pavlovskii.ilya.mvvm.test.ui.fragments.timer;

import android.databinding.ObservableBoolean;
import android.databinding.ObservableString;
import by.mvvmwrapper.viewdata.SimpleViewData;

import javax.inject.Inject;

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

    public final ObservableString time = new ObservableString();
    public final ObservableBoolean selected = new ObservableBoolean(false);

    @Inject
    public TimerViewData() {
    }

    public void setTime(String time) {
        this.time.set(time);
    }

    public void setSelected(boolean isSelected) {
        this.selected.set(isSelected);
    }
}
