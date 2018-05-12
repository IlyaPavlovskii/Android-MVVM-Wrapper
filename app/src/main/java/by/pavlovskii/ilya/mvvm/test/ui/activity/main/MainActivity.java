package by.pavlovskii.ilya.mvvm.test.ui.activity.main;

import android.os.Bundle;
import by.pavlovskii.ilya.mvvm.test.R;
import by.pavlovskii.ilya.mvvm.test.databinding.ActivityMainBinding;
import by.pavlovskii.ilya.mvvm.test.ui.activity.BaseActivity;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 10.11.2017<br>
 * Time: 17:32<br>
 * Project name: MVVMtest<br>
 * ===================================================================================<br>
 * Default activity implementation based on MVVM framework<br>
 * ===================================================================================<br>
 */
public class MainActivity extends BaseActivity<MainViewModel, ActivityMainBinding> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected Class<MainViewModel> getViewModelClass() {
        return MainViewModel.class;
    }

}
