package by.pavlovskii.ilya.mvvm.test.ui.activity.yellow;

import android.databinding.ObservableField;

import by.mvvmwrapper.viewdata.SimpleViewData;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 08.12.2017<br>
 * Time: 3:04<br>
 * Project name: MVVMtest<br>
 * ===================================================================================<br>
 */
public class YellowViewData extends SimpleViewData {

    private static int sIndex = 0;

    public final ObservableField<String> index = new ObservableField<>("Idx:" + sIndex++);

    public YellowViewData() {
        super();
    }

    @Override
    public void destroy() {
        super.destroy();
        sIndex--;
    }
}
