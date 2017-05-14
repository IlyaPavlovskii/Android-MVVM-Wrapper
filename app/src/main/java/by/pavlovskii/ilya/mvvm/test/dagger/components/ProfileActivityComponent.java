package by.pavlovskii.ilya.mvvm.test.dagger.components;

import by.pavlovskii.ilya.mvvm.test.activity.ProfileActivity;
import by.pavlovskii.ilya.mvvm.test.dagger.modules.ViewModelModule;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 08.04.17<br>
 * Time: 1:08<br>
 * Project name: MVVMtest<br>
 * ===================================================================================
 * //TODO Add description<br>
 * ===================================================================================
 */
@Subcomponent(
        modules = {
                ViewModelModule.class
        })
public interface ProfileActivityComponent extends AndroidInjector<ProfileActivity> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<ProfileActivity> {
    }
}
