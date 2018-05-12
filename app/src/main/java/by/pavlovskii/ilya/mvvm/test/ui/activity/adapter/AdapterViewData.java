package by.pavlovskii.ilya.mvvm.test.ui.activity.adapter;

import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;
import android.support.annotation.NonNull;
import by.mvvmwrapper.viewdata.BaseViewData;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.List;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 12.05.2018<br>
 * Time: 20:32<br>
 * Project name: MVVMtest<br>
 * ===================================================================================<br>
 */
public class AdapterViewData extends BaseViewData {

    public final ObservableList<String> colors = new ObservableArrayList<>();
    public final ObservableList<Integer> failureColors = new ObservableArrayList<>();

    @Inject
    public AdapterViewData() {
        failureColors.addAll(Arrays.asList(1, 2, 3, 4, 5));
    }

    @Override
    public void destroy() {
        super.destroy();
        colors.clear();
        failureColors.clear();
    }

    public void setColors(@NonNull List<String> list) {
        this.colors.clear();
        this.colors.addAll(list);
    }
}
