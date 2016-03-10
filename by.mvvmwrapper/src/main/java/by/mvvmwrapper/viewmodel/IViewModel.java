package by.mvvmwrapper.viewmodel;

import android.app.Activity;
import android.app.Fragment;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.databinding.ViewDataBinding;
import android.os.IBinder;
import android.support.annotation.NonNull;

import by.mvvmwrapper.bindmodels.IViewData;

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
public interface IViewModel<TViewData extends IViewData,
        TViewDataBinding extends ViewDataBinding,
        TViewComponent extends ComponentCallbacks> {

    //======================================================
    //------------------------Methods-----------------------
    //======================================================
    /**
     * Initialize view data binding model
     */
    @NonNull
    TViewData initViewData() throws ClassNotFoundException;

    /**
     * Initialize View component - {@link Fragment} or {@link Activity}*/
    void initViewComponent(TViewComponent view);

    /**
     * Bind data into {@link ViewDataBinding} component
     *
     * @param viewDataBinding generic binding view element*/
    void bindViewData(@NonNull TViewDataBinding viewDataBinding);

    /**
     * Destroy View callabck*/
    void destroy();

}

