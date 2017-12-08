package by.pavlovskii.ilya.mvvm.test.activity.main;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.util.Log;

import javax.inject.Named;
import javax.inject.Singleton;

import by.mvvmwrapper.dagger.scope.ActivityScope;
import by.pavlovskii.ilya.mvvm.test.navigator.MainNavigator;
import by.pavlovskii.ilya.mvvm.test.utils.DemoActivityFactory;
import by.pavlovskii.ilya.mvvm.test.viewmodel.AppViewModelFactory;
import dagger.Binds;
import dagger.Lazy;
import dagger.Module;
import dagger.Provides;
import ru.terrakok.cicerone.Navigator;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 24.11.2017<br>
 * Time: 17:39<br>
 * Project name: MVVMtest<br>
 * ===================================================================================<br>
 */
@Module
public abstract class MainViewModelModule {

    @Binds
    @ActivityScope
    abstract Navigator navigator(@NonNull MainNavigator navigator);

    @Provides
    @ActivityScope
    static MainViewData viewData() {
        return new MainViewData();
    }

    @Provides
    @ActivityScope
    static MainViewModel viewModel(@NonNull MainViewData viewData, @NonNull DemoActivityFactory demoActivityFactory) {
        Log.d("MainViewModel", "provide");
        return new MainViewModel(viewData, demoActivityFactory);
    }

////    @Provides
////    @Named("MainViewModelProvider.Factory")
////    static ViewModelProvider.Factory factory(@NonNull Lazy<MainViewModel> viewModel,
////                                             @NonNull AppViewModelFactory factory) {
////        factory.
////        return factory;
//////        return new ViewModelProvider.Factory() {
//////            @NonNull
//////            @Override
//////            public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
//////                if (modelClass.isAssignableFrom(viewModel.get().getClass())) {
//////                    return (T) viewModel.get();
//////                }
//////                return null;
//////            }
//////        };
//    }


}
