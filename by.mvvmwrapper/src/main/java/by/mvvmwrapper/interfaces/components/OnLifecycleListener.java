package by.mvvmwrapper.interfaces.components;

import android.content.Intent;
import android.os.Bundle;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 10.11.2017<br>
 * Time: 12:43<br>
 * Project name: MVVMtest<br>
 * ===================================================================================
 * Android component lifecycle listener<br>
 * ===================================================================================
 */
public interface OnLifecycleListener {

    void onCreate(Bundle savedInstanceState);

    void onActivityResult(int requestCode, int resultCode, Intent data);

    void onPause();

    void onResume();

    void onStop();

    void onStart();

    void onDestroy();
}
