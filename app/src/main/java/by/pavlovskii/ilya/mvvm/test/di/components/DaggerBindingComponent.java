package by.pavlovskii.ilya.mvvm.test.di.components;

import dagger.Subcomponent;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 09.05.2018<br>
 * Time: 2:20<br>
 * Project name: MVVMtest<br>
 * ===================================================================================<br>
 */
@Subcomponent
public interface DaggerBindingComponent extends android.databinding.DataBindingComponent {

    @Subcomponent.Builder
    interface Builder {
        DaggerBindingComponent build();
    }

}
