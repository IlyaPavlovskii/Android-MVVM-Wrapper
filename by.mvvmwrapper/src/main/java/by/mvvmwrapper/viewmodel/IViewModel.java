package by.mvvmwrapper.viewmodel;

import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;

import by.mvvmwrapper.viewdata.IViewData;

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
public interface IViewModel<TViewData extends IViewData> {

    //======================================================
    //------------------------Methods-----------------------
    //======================================================
    /**
     * Initialize view data binding model
     */
    @NonNull
    TViewData initViewData();

    /**
     * Bind  view data into {@link ViewDataBinding} component
     *
     * @param viewDataBinding binding view element*/
    void bindViewData(@NonNull ViewDataBinding viewDataBinding);

    /**
     * Destroy View callabck*/
    void destroy();

}

