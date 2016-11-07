package by.pavlovskii.ilya.mvvm.test.dagger.modules;

import by.pavlovskii.ilya.mvvm.test.viewmodel.ProfileActivityViewModel;
import dagger.Module;
import dagger.Provides;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 07.11.16<br>
 * Time: 16:43<br>
 * Project name: MVVMtest<br>
 * ===================================================================================<br>
 * {@link by.mvvmwrapper.viewmodel.IViewModel} module<br>
 * ===================================================================================<br>
 */
@Module
public class ViewModelModule {

    //======================================================
    //---------------------Public methods-------------------
    //======================================================
    @Provides
    public ProfileActivityViewModel provideProfileActivityViewModel() {
        return new ProfileActivityViewModel();
    }

    //======================================================
    //-----------------------Listeners----------------------
    //======================================================

    //======================================================
    //---------------------Inner classes--------------------
    //======================================================
}
