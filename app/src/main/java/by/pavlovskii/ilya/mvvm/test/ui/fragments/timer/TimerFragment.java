package by.pavlovskii.ilya.mvvm.test.ui.fragments.timer;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;

import javax.inject.Inject;

import by.pavlovskii.ilya.mvvm.test.R;
import by.pavlovskii.ilya.mvvm.test.databinding.FragmentTimerBinding;
import by.pavlovskii.ilya.mvvm.test.ui.activity.main.MainViewModel;
import by.pavlovskii.ilya.mvvm.test.ui.fragments.BaseFragment;
import timber.log.Timber;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 27.11.2017<br>
 * Time: 8:48<br>
 * Project name: MVVMtest<br>
 * ===================================================================================<br>
 */
public class TimerFragment extends BaseFragment<TimerViewModel, FragmentTimerBinding> {

    public static Fragment newInstance() {
        return new TimerFragment();
    }

    //======================================================
    //-------------------Override methods-------------------
    //======================================================
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Timber.d("onCreate");
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Timber.d("onViewCreated");
        mBinding.setOnUpdateInfoClickListener(v -> mViewModel.updateInfo());
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_timer;
    }

    @Override
    protected Class<TimerViewModel> getViewModelClass() {
        return TimerViewModel.class;
    }

}
