package by.pavlovskii.ilya.mvvm.test.fragments;

import android.support.annotation.NonNull;

import javax.inject.Inject;

import by.mvvmwrapper.viewmodel.IViewModel;
import by.pavlovskii.ilya.mvvm.test.R;
import by.pavlovskii.ilya.mvvm.test.databinding.FragmentTimerBinding;
import by.pavlovskii.ilya.mvvm.test.viewmodel.TimerViewModel;

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

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_timer;
    }

    @NonNull
    @Override
    protected TimerViewModel initViewModel() {
        return mViewModel;
    }

    @Override
    protected Class<TimerViewModel> getViewModelClass() {
        return TimerViewModel.class;
    }
}
