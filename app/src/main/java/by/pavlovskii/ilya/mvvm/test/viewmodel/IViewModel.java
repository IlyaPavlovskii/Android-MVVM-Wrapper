package by.pavlovskii.ilya.mvvm.test.viewmodel;

import android.content.Context;
import android.databinding.ViewDataBinding;
import android.os.IBinder;
import android.support.annotation.NonNull;

import by.pavlovskii.ilya.mvvm.test.bindmodels.IViewData;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 06.01.16<br>
 * Time: 19:21<br>
 * Project name: MVVMtest<br>
 * ===================================================================================
 * Base ViewModel(form MVVM pattern) description<br>
 * Contains generic fields with {@link IViewData} (view data binding model) and
 * {@link ViewDataBinding}(compile time element which receive with android.databinding library)
 * ===================================================================================
 */
public interface IViewModel<TViewData extends IViewData, TViewDataBinding extends ViewDataBinding> {

    //======================================================
    //------------------------Methods-----------------------
    //======================================================

    /**
     * Initialize view data binding model
     */
    @NonNull
    TViewData initViewData();

    /**
     * Bind data into {@link ViewDataBinding} component
     *
     * @param context activity or service context
     * @param viewDataBinding generic binding view element*/
    void bindViewData(@NonNull Context context, @NonNull TViewDataBinding viewDataBinding);

    /**
     * Binder element to communicate between View and ViewModel*/
    @NonNull
    IBinder getReceiverBinder();

    /**
     * Set binder from View component into ViewModel. Need initialize for achievement
     * communication function between View and ViewModel components
     *
     * @param binder {@link android.os.Messenger} handler*/
    void setSenderBinder(@NonNull IBinder binder);

    /**
     * Destroy View callabck*/
    void destroy();


}
