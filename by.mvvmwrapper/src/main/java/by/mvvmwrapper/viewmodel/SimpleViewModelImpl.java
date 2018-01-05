package by.mvvmwrapper.viewmodel;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.List;

import by.mvvmwrapper.exceptions.ExceptionHandler;
import by.mvvmwrapper.exceptions.ExceptionHandlerChain;
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
public abstract class SimpleViewModelImpl<TViewData extends ViewData>
        extends BaseViewModel implements ExceptionHandler {

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
    protected ExceptionHandlerChain mExceptionHandlerChain;

    //======================================================
    //---------------------Constructors---------------------
    //======================================================
    public SimpleViewModelImpl() {
        super();
    }

    public SimpleViewModelImpl(@NonNull TViewData viewData) {
        mViewData = viewData;
        if (mViewData == null) {
            throw new NullPointerException("ViewData must not be null");
        }
        mExceptionHandlerChain = initExceptionHandlerChain();
    }

    //======================================================
    //-------------------- Public methods ------------------
    //======================================================
    public void setViewData(@NonNull TViewData viewData) {
        mViewData = viewData;
        if (mViewData == null) {
            throw new NullPointerException("ViewData must not be null");
        }
    }

    //======================================================
    //-------------------Protected methods------------------
    //======================================================
    @NonNull
    protected ExceptionHandlerChain initExceptionHandlerChain() {
        return new ExceptionHandlerChain();
    }

    protected void addExceptionHandler(@NonNull ExceptionHandler exceptionHandler) {
        mExceptionHandlerChain.addHandler(exceptionHandler);
    }

    protected void addExceptionHandlers(@NonNull ExceptionHandler... exceptionHandlers) {
        mExceptionHandlerChain.addHandlers(exceptionHandlers);
    }

    protected void addExceptionHandlers(@NonNull List<? extends ExceptionHandler> exceptionHandlers) {
        mExceptionHandlerChain.addHandlers(exceptionHandlers);
    }

    protected void removeExceptionHandler(@NonNull ExceptionHandler exceptionHandler) {
        mExceptionHandlerChain.removeHandler(exceptionHandler);
    }

    protected void removeExceptionHandlers(@NonNull ExceptionHandler... exceptionHandlers) {
        mExceptionHandlerChain.removeHandlers(exceptionHandlers);
    }

    protected void removeExceptionHandlers(@NonNull List<? extends ExceptionHandler> exceptionHandlers) {
        mExceptionHandlerChain.removeHandlers(exceptionHandlers);
    }

    //======================================================
    //-------------------Override methods-------------------
    //======================================================
    @Override
    protected void onCleared() {
        super.onCleared();
        mViewData.destroy();
    }

    @Override
    public boolean handleException(@Nullable Throwable throwable) {
        return mExceptionHandlerChain.handleException(throwable);
    }

}
