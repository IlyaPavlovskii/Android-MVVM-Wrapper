package by.pavlovskii.ilya.mvvm.test.activity.main;

import android.support.annotation.NonNull;
import android.util.Log;

import by.mvvmwrapper.dagger.scope.ActivityScope;
import by.pavlovskii.ilya.mvvm.test.di.scopes.ViewModelScope;
import by.pavlovskii.ilya.mvvm.test.fragments.timer.TimerFragmentProvider;
import by.pavlovskii.ilya.mvvm.test.utils.DemoActivityFactory;
import by.pavlovskii.ilya.mvvm.test.viewmodel.LazyViewModelProviderFactory;
import dagger.Lazy;
import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;

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
@ViewModelScope
public abstract class MainViewModelModule {

    @Provides
    @ViewModelScope
    static MainViewData viewData() {
        return new MainViewData();
    }

    @Provides
    @ViewModelScope
    static MainViewModel viewModel(@NonNull MainViewData viewData, @NonNull DemoActivityFactory demoActivityFactory) {
        Log.d("MainViewModel", "provide");
        return new MainViewModel(viewData, demoActivityFactory);
    }

    @Provides
    @ViewModelScope
    static LazyViewModelProviderFactory<MainViewModel> viewModelProviderFactory(@NonNull Lazy<MainViewModel> lazy) {
        return new LazyViewModelProviderFactory<>(lazy);
    }

    @ActivityScope
    @ContributesAndroidInjector(modules = {MainActivityModule.class})
    abstract MainActivity mainActivityInjector();

}
