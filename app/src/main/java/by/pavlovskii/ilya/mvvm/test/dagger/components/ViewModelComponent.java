package by.pavlovskii.ilya.mvvm.test.dagger.components;

import by.mvvmwrapper.dagger.scope.ActivityScope;
import by.mvvmwrapper.viewdata.ViewData;
import by.mvvmwrapper.viewmodel.ViewModel;
import by.pavlovskii.ilya.mvvm.test.activity.ProfileActivity;
import by.pavlovskii.ilya.mvvm.test.dagger.modules.ViewModelModule;
import dagger.Component;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 07.11.16<br>
 * Time: 16:53<br>
 * Project name: MVVMtest<br>
 * ===================================================================================<br>
 * {@link ViewModel} component which resolve dependencies with<br>
 * {@link ViewData}<br>
 * ===================================================================================<br>
 */
@ActivityScope
@Component(modules = {ViewModelModule.class})
public interface ViewModelComponent {

    //======================================================
    //---------------------Public methods-------------------
    //======================================================
    void inject(ProfileActivity activity);

}
