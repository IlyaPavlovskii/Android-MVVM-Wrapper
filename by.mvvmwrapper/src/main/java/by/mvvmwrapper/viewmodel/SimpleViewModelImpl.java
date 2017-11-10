package by.mvvmwrapper.viewmodel;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;

import by.mvvmwrapper.interfaces.ViewActionCallback;
import by.mvvmwrapper.viewdata.ViewData;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 10.11.2017<br>
 * Time: 12:42<br>
 * Project name: MVVMtest<br>
 * ===================================================================================
 * {@link SimpleViewModel} implementation<br>
 * ===================================================================================
 */
public abstract class SimpleViewModelImpl<TViewData extends ViewData, TViewActionCallback extends ViewActionCallback>
        implements SimpleViewModel {

    //======================================================
    //----------------------Constants-----------------------
    //======================================================
    public final String TAG = getClass().getSimpleName();

    //======================================================
    //------------------------Fields------------------------
    //======================================================
    @NonNull
    protected TViewData mViewData;
    @NonNull
    protected TViewActionCallback mActionCallback;

    //======================================================
    //---------------------Constructors---------------------
    //======================================================
    public SimpleViewModelImpl(@NonNull TViewActionCallback actionCallback) {
        this.mActionCallback = actionCallback;
    }

    public SimpleViewModelImpl(@NonNull TViewData viewData, @NonNull TViewActionCallback actionCallback) {
        mViewData = viewData;
        mActionCallback = actionCallback;
        if (mViewData == null) {
            throw new NullPointerException("ViewData must not be null");
        }
        if (mActionCallback == null) {
            throw new NullPointerException("ViewActionCallback must not be null");
        }
    }

    public void setViewData(@NonNull TViewData viewData) {
        mViewData = viewData;
        if (mViewData == null) {
            throw new NullPointerException("ViewData must not be null");
        }
    }

    public void setActionCallback(@NonNull TViewActionCallback actionCallback) {
        mActionCallback = actionCallback;
        if (mActionCallback == null) {
            throw new NullPointerException("ViewActionCallback must not be null");
        }
    }

    //======================================================
    //-------------------Override methods-------------------
    //======================================================
    @Override
    public void destroy() {
        mViewData.destroy();
        mViewData = null;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {

    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onDestroy() {

    }

}
