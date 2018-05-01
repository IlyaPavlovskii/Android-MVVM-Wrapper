package by.pavlovskii.ilya.mvvm.test.di.modules;

import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import by.pavlovskii.ilya.mvvm.test.utils.ViewModelFactory;
import dagger.Binds;
import dagger.Module;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 01.05.2018<br>
 * Time: 19:20<br>
 * Project name: MVVMtest<br>
 * ===================================================================================<br>
 */
@Module
public abstract class ViewModelModule {

    @Binds
    @NonNull
    abstract ViewModelProvider.Factory bindViewModelFactory(@NonNull ViewModelFactory factory);

}
