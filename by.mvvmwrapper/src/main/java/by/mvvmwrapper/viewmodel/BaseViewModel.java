package by.mvvmwrapper.viewmodel;

import android.content.ComponentCallbacks;
import android.databinding.ViewDataBinding;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.annotation.NonNull;

import java.lang.ref.WeakReference;

import by.mvvmwrapper.bindmodels.IViewData;

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
 * {@link by.mvvmwrapper.activity.BaseActivity} and {@link IViewModel}.
 * Contains required fields like - {@link IViewData} and {@link ViewDataBinding}<br>
 * ===================================================================================
 */
public abstract class BaseViewModel<TViewData extends IViewData,
        TViewDataBinding extends ViewDataBinding,
        TViewComponent extends ComponentCallbacks>
        implements IViewModel<TViewData, TViewDataBinding, TViewComponent> {

    //======================================================
    //----------------------Constants-----------------------
    //======================================================
    public final String TAG = getClass().getSimpleName();

    //======================================================
    //------------------------Fields------------------------
    //======================================================
    protected TViewComponent mViewComponent;
    protected TViewData mViewData;

    //======================================================
    //---------------------Constructors---------------------
    //======================================================
    public BaseViewModel() {
        try {
            mViewData = initViewData();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //======================================================
    //-------------------Override methods-------------------
    //======================================================
    @Override
    public void initViewComponent(TViewComponent view) {
        this.mViewComponent = view;
    }

    @Override
    public void destroy() {
        mViewData = null;
    }
}

