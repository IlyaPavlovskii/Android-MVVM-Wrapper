package by.mvvmwrapper.interfaces.components;

import android.os.Bundle;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 10.11.2017<br>
 * Time: 15:37<br>
 * Project name: MVVMtest<br>
 * ===================================================================================
 */
public interface OnSaveRestoreInstanceListener {

    void onSaveInstanceState(Bundle outState);

    void onRestoreInstanceState(Bundle savedInstanceState);

}
