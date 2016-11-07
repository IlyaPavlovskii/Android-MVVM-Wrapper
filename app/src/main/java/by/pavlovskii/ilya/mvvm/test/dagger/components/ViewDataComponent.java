package by.pavlovskii.ilya.mvvm.test.dagger.components;

import by.mvvmwrapper.dagger.scope.ViewModelScope;
import by.pavlovskii.ilya.mvvm.test.dagger.modules.ViewDataModule;
import by.pavlovskii.ilya.mvvm.test.viewmodel.ProfileActivityViewModel;
import dagger.Component;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 07.11.16<br>
 * Time: 17:16<br>
 * Project name: MVVMtest<br>
 * ===================================================================================<br>
 * //TODO Add description<br>
 * ===================================================================================<br>
 */
@ViewModelScope
@Component(modules = ViewDataModule.class)
public interface ViewDataComponent {

    //======================================================
    //---------------------Public methods-------------------
    //======================================================
    void inject(ProfileActivityViewModel viewModel);

}
