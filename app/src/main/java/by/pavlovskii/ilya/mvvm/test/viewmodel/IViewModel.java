package by.pavlovskii.ilya.mvvm.test.viewmodel;

import android.content.Context;
import android.databinding.ViewDataBinding;
import android.os.Handler;
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
 * //TODO Add description<br>
 * ===================================================================================
 */
public interface IViewModel<TViewData extends IViewData, TViewDataBinding extends ViewDataBinding> {

    //======================================================
    //------------------------Fields------------------------
    //======================================================

    //======================================================
    //------------------------Methods-----------------------
    //======================================================
    @NonNull
    TViewData initViewData();
    void bindViewData(@NonNull Context context, @NonNull TViewDataBinding viewDataBinding);

    @NonNull
    IBinder getReceiverBinder();

    void setSenderBinder(@NonNull IBinder binder);
    void destroy();


}
