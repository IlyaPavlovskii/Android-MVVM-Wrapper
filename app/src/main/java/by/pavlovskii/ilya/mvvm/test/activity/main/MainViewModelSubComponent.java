package by.pavlovskii.ilya.mvvm.test.activity.main;

import by.pavlovskii.ilya.mvvm.test.di.scopes.ViewModelScope;
import dagger.Subcomponent;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 09.12.2017<br>
 * Time: 19:07<br>
 * Project name: MVVMtest<br>
 * ===================================================================================<br>
 */
@ViewModelScope
@Subcomponent(modules = MainViewModelModule.class)
public interface MainViewModelSubComponent {

    @Subcomponent.Builder
    interface Builder {
        MainViewModelSubComponent build();
    }

    MainActivitySubComponent.Builder mainActivitySubComponent();

}
