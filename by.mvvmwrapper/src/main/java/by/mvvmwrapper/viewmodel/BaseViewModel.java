package by.mvvmwrapper.viewmodel;

import android.content.Context;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import javax.inject.Inject;

import by.mvvmwrapper.viewdata.IViewData;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 31.01.16<br>
 * Time: 19:03<br>
 * Project name: MVVMtest<br>
 * ===================================================================================
 * Base {@link IViewModel} realization with communication between
 * view({@link android.app.Activity} or {@link android.app.Fragment}) and {@link IViewModel}.
 * Contains required fields like - {@link IViewData} and {@link ViewDataBinding}<br>
 * ===================================================================================
 */
public abstract class BaseViewModel<TViewData extends IViewData> implements IViewModel<TViewData> {

    //======================================================
    //----------------------Constants-----------------------
    //======================================================
    public final String TAG = getClass().getSimpleName();

    //======================================================
    //------------------------Fields------------------------
    //======================================================
    @Inject
    protected TViewData mViewData;

    //======================================================
    //---------------------Constructors---------------------
    //======================================================
    public BaseViewModel() {
        injectViewData();
    }

    //======================================================
    //-------------------Override methods-------------------
    //======================================================
    @Override
    public void destroy() {
        mViewData = null;
    }

    //======================================================
    //------------------Protected methods-------------------
    //======================================================
    protected abstract void injectViewData();

}

