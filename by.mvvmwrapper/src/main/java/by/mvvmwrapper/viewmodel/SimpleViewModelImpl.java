package by.mvvmwrapper.viewmodel;

import android.support.annotation.NonNull;

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
public abstract class SimpleViewModelImpl<T extends ViewData>
        extends BaseViewModel {

    //======================================================
    //------------------------Fields------------------------
    //======================================================
    @NonNull
    protected T mViewData;


    //======================================================
    //---------------------Constructors---------------------
    //======================================================
    public SimpleViewModelImpl() {
        super();
    }

    public SimpleViewModelImpl(@NonNull T viewData) {
        mViewData = viewData;
    }

    //======================================================
    //-------------------- Public methods ------------------
    //======================================================
    public void setViewData(@NonNull T viewData) {
        mViewData = viewData;
    }

    //======================================================
    //-------------------Override methods-------------------
    //======================================================
    @Override
    protected void onCleared() {
        super.onCleared();
        mViewData.destroy();
    }

}
