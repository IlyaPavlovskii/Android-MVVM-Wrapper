package by.pavlovskii.ilya.mvvm.test.ui.activity.twoway;

import android.databinding.ObservableBoolean;
import android.databinding.ObservableString;
import by.mvvmwrapper.viewdata.BaseViewData;

import javax.inject.Inject;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 12.05.2018<br>
 * Time: 18:00<br>
 * Project name: MVVMtest<br>
 * ===================================================================================<br>
 */
public class TwoWayViewData extends BaseViewData {

    public final ObservableString text = new ObservableString();
    public final ObservableBoolean checkBoxState = new ObservableBoolean(false);
    public final ObservableBoolean switchState = new ObservableBoolean(true);
    public final ObservableBoolean toggleState = new ObservableBoolean(true);
    public final ObservableBoolean globalState = new ObservableBoolean(false);

    @Inject
    public TwoWayViewData() {
    }
}
