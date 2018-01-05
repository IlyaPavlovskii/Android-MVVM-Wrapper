package by.pavlovskii.ilya.mvvm.test.ui.activity.yellow.di;

import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;
import android.util.Log;

import javax.inject.Provider;

import by.mvvmwrapper.dagger.scope.ActivityScope;
import by.mvvmwrapper.utils.viewmodelproviders.ProviderViewModelProviderFactory;
import by.pavlovskii.ilya.mvvm.test.ui.activity.yellow.YellowViewData;
import by.pavlovskii.ilya.mvvm.test.ui.activity.yellow.YellowViewModel;
import dagger.Module;
import dagger.Provides;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 08.12.2017<br>
 * Time: 3:14<br>
 * Project name: MVVMtest<br>
 * ===================================================================================<br>
 */
@Module
public abstract class YellowActivityModule {

    @Provides
    @ActivityScope
    static YellowViewData viewData() {
        return new YellowViewData();
    }

    @Provides
    @ActivityScope
    static YellowViewModel viewModel(@NonNull YellowViewData viewData) {
        Log.d("YellowViewModel", "provide");
        return new YellowViewModel(viewData);
    }

//    @Provides
//    @ActivityScope
//    static ViewModelProvider.Factory factory(@NonNull Provider<YellowViewModel> viewModel) {
//        return new ProviderViewModelProviderFactory<>(YellowViewModel.class, viewModel);
//    }
}
