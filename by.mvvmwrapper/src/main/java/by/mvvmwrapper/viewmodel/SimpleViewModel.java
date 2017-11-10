package by.mvvmwrapper.viewmodel;

import by.mvvmwrapper.interfaces.components.OnLifecycleListener;
import by.mvvmwrapper.interfaces.components.OnRequestPermissionListener;
import by.mvvmwrapper.interfaces.components.OnSaveRestoreInstanceListener;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 10.11.2017<br>
 * Time: 15:40<br>
 * Project name: MVVMtest<br>
 * ===================================================================================
 * Simple view model model interface<br>
 * ===================================================================================
 */
public interface SimpleViewModel extends ViewModel, OnLifecycleListener,
        OnRequestPermissionListener, OnSaveRestoreInstanceListener {

}
