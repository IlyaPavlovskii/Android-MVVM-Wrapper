package by.pavlovskii.ilya.mvvm.test.viewmodel;

import android.content.Context;
import android.databinding.ViewDataBinding;

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
public interface IViewModel<T extends ViewDataBinding>  {

    //======================================================
    //------------------------Fields------------------------
    //======================================================

    //======================================================
    //------------------------Methods-----------------------
    //======================================================
    void initModel();
    void bindData(Context context, T viewDataBinding);
    void destroy();
}
