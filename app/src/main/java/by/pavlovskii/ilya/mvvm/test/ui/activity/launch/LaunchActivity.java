package by.pavlovskii.ilya.mvvm.test.ui.activity.launch;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import by.pavlovskii.ilya.mvvm.test.R;
import by.pavlovskii.ilya.mvvm.test.databinding.ActivityLaunchBinding;
import by.pavlovskii.ilya.mvvm.test.models.SampleItem;
import by.pavlovskii.ilya.mvvm.test.ui.activity.BaseActivity;
import timber.log.Timber;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 04.05.2018<br>
 * Time: 2:11<br>
 * Project name: MVVMtest<br>
 * ===================================================================================<br>
 */
public class LaunchActivity extends BaseActivity<LaunchViewModel, ActivityLaunchBinding> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addDisposable(mViewModel
                .initList()
                .subscribe(
                        () -> Timber.d("Init list"),
                        this::handleException)
        );
        mBinding.setOnSampleClickListener(this::navigateTo);
    }

    @Override
    protected Class<LaunchViewModel> getViewModelClass() {
        return LaunchViewModel.class;
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_launch;
    }

    private void navigateTo(@NonNull SampleItem item) {
        Intent intent = new Intent(this, item.getActivityClass());
        startActivity(intent);
    }
}
