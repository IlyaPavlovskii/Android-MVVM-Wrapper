package by.mvvmwrapper.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 27.11.2017<br>
 * Time: 16:38<br>
 * Project name: MVVMtest<br>
 * ===================================================================================<br>
 */
public abstract class BaseViewModel extends ViewModel implements SimpleViewModel {

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {

    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onDestroy() {

    }
}
