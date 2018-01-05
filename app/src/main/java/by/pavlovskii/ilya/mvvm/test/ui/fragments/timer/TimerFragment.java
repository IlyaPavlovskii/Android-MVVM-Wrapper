package by.pavlovskii.ilya.mvvm.test.ui.fragments.timer;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;

import by.pavlovskii.ilya.mvvm.test.R;
import by.pavlovskii.ilya.mvvm.test.databinding.FragmentTimerBinding;
import by.pavlovskii.ilya.mvvm.test.ui.fragments.BaseFragment;

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
        Log.d(TAG, "onCreate");
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d(TAG, "onAttach");
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d(TAG, "onViewCreated");
        mBinding.setOnUpdateInfoClickListener(v -> getViewModel().updateInfo());
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
