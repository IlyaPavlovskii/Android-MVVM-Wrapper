package by.pavlovskii.ilya.mvvm.test.ui.fragments.timer;

import android.databinding.BindingAdapter;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.view.View;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 13.05.2018<br>
 * Time: 2:04<br>
 * Project name: MVVMtest<br>
 * ===================================================================================<br>
 */
@Singleton
public class TimerBindingAdapter {

    @Inject
    public TimerBindingAdapter() {
    }

    @BindingAdapter("bindTextColorSelectable")
    public void bindTextColorSelectable(@NonNull View view, boolean isSelected) {
        view.setBackgroundColor(isSelected ? Color.YELLOW : Color.TRANSPARENT);
    }
}
