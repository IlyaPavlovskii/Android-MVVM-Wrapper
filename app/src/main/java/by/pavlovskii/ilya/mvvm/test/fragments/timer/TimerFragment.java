package by.pavlovskii.ilya.mvvm.test.fragments.timer;

import android.arch.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import javax.inject.Inject;
import javax.inject.Named;

import by.pavlovskii.ilya.mvvm.test.R;
import by.pavlovskii.ilya.mvvm.test.databinding.FragmentTimerBinding;
import by.pavlovskii.ilya.mvvm.test.fragments.BaseFragment;

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

    @Inject
    @Named("TimerViewModelProvider.Factory")
    ViewModelProvider.Factory mViewModelFactory;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mBinding.setOnUpdateInfoClickListener(v -> mViewModel.updateInfo());
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_timer;
    }

    @Override
    protected ViewModelProvider.Factory getViewModelFactory() {
        return mViewModelFactory;
    }

    @Override
    protected Class<TimerViewModel> getViewModelClass() {
        return TimerViewModel.class;
    }

    public static Fragment newInstance() {
        return new TimerFragment();
    }
}
