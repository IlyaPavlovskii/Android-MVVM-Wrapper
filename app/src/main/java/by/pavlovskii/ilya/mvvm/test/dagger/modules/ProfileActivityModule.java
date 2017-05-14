package by.pavlovskii.ilya.mvvm.test.dagger.modules;

import android.app.Activity;

import by.pavlovskii.ilya.mvvm.test.activity.ProfileActivity;
import by.pavlovskii.ilya.mvvm.test.dagger.components.ProfileActivityComponent;
import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 08.04.17<br>
 * Time: 1:10<br>
 * Project name: MVVMtest<br>
 * ===================================================================================
 * //TODO Add description<br>
 * ===================================================================================
 */
@Module(subcomponents = ProfileActivityComponent.class)
public abstract class ProfileActivityModule {

    @Binds
    @IntoMap
    @ActivityKey(ProfileActivity.class)
    abstract AndroidInjector.Factory<? extends Activity> bindFactory(ProfileActivityComponent.Builder builder);
}
