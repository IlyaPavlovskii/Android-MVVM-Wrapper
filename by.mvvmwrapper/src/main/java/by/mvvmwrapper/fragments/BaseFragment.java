package by.mvvmwrapper.fragments;

import android.app.Dialog;
import android.app.Fragment;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.afollestad.materialdialogs.MaterialDialog;

import by.mvvmwrapper.R;
import by.mvvmwrapper.interfaces.DialogActionsDelegate;
import by.mvvmwrapper.viewmodel.BaseViewModel;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 11.03.16<br>
 * Time: 0:23<br>
 * Project name: MVVMtest<br>
 * ===================================================================================
 * Base {@link Fragment} realization of view component<br>
 * ===================================================================================
 */
public abstract class BaseFragment<TViewModel extends BaseViewModel, TViewDataBinding extends ViewDataBinding>
        extends Fragment
        implements DialogActionsDelegate {

    //======================================================
    //----------------------Constants-----------------------
    //======================================================
    public final String TAG = getClass().getSimpleName();

    //======================================================
    //------------------------Fields------------------------
    //======================================================
    @NonNull
    protected TViewDataBinding mBinding;
    @NonNull
    protected TViewModel mViewModel;

    private Dialog mProgressDialog;

    //======================================================
    //-------------------Abstract methods-------------------
    //======================================================
    @LayoutRes
    protected abstract int getLayoutRes();

    @NonNull
    protected abstract TViewModel initViewModel();

    //======================================================
    //-------------------Override methods-------------------
    //======================================================
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = initViewModel();
        if (mViewModel == null) {
            throw new NullPointerException("IViewModel component must be initialized");
        }
        mViewModel.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, getLayoutRes(), container, false);
        if (mBinding == null) {
            throw new NullPointerException("ViewDataBinding must be initialized");
        }
        return mBinding.getRoot();
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel.bindViewData(mBinding);
    }


    @Override
    public void onPause() {
        super.onPause();
        mViewModel.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        mViewModel.onResume();
    }

    @Override
    public void onStart() {
        super.onStart();
        mViewModel.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
        mViewModel.onStop();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mViewModel.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        mViewModel.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mViewModel.onSaveInstanceState(outState);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        mViewModel.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @NonNull
    @Override
    public Dialog getProgressDialog() {
        if (getActivity() instanceof DialogActionsDelegate) {
            return ((DialogActionsDelegate) getActivity()).getProgressDialog();
        }
        if (mProgressDialog == null) {
            mProgressDialog = getAlertDialogBuilder()
                    .progress(true, 0)
                    .build();
        }
        return mProgressDialog;
    }

    @Override
    public void showErrorDialog(@Nullable String message) {
        if (getActivity() instanceof DialogActionsDelegate) {
            ((DialogActionsDelegate) getActivity()).showErrorDialog(message);
        } else {
            getAlertDialogBuilder()
                    .title(R.string.error)
                    .title(message)
                    .build()
                    .show();
        }
    }

    @NonNull
    @Override
    public MaterialDialog.Builder getAlertDialogBuilder() {
        if (getActivity() instanceof DialogActionsDelegate) {
            return ((DialogActionsDelegate) getActivity()).getAlertDialogBuilder();
        }
        return new MaterialDialog.Builder(getActivity());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mViewModel.onDestroy();
        mBinding.unbind();
        mViewModel.onDestroy();
    }

}