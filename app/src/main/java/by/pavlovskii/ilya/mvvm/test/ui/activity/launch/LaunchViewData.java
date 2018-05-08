package by.pavlovskii.ilya.mvvm.test.ui.activity.launch;

import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;
import android.support.annotation.NonNull;
import by.mvvmwrapper.viewdata.BaseViewData;
import by.pavlovskii.ilya.mvvm.test.models.SampleItem;

import javax.inject.Inject;
import java.util.List;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 04.05.2018<br>
 * Time: 2:12<br>
 * Project name: MVVMtest<br>
 * ===================================================================================<br>
 */
public class LaunchViewData extends BaseViewData {

    public final ObservableList<SampleItem> sampleItems = new ObservableArrayList<>();

    @Inject
    public LaunchViewData() {
    }

    public void setSampleItems(@NonNull List<SampleItem> list) {
        this.sampleItems.clear();
        this.sampleItems.addAll(list);
    }
}
