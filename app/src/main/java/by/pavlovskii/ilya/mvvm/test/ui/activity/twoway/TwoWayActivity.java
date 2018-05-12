package by.pavlovskii.ilya.mvvm.test.ui.activity.twoway;

import by.pavlovskii.ilya.mvvm.test.R;
import by.pavlovskii.ilya.mvvm.test.databinding.ActivityTwoWayBinding;
import by.pavlovskii.ilya.mvvm.test.ui.activity.BaseActivity;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 09.05.2018<br>
 * Time: 1:40<br>
 * Project name: MVVMtest<br>
 * ===================================================================================<br>
 */
public class TwoWayActivity extends BaseActivity<TwoWayViewModel, ActivityTwoWayBinding> {

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_two_way;
    }

    @Override
    protected Class<TwoWayViewModel> getViewModelClass() {
        return TwoWayViewModel.class;
    }
}
