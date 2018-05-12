package by.pavlovskii.ilya.mvvm.test.ui.activity.adapter.di;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import by.mvvmwrapper.dagger.map.ViewModelKey;
import by.mvvmwrapper.viewmodel.BaseViewModel;
import by.pavlovskii.ilya.mvvm.test.ui.activity.adapter.AdapterViewModel;
import by.pavlovskii.ilya.mvvm.test.ui.activity.adapter.impl.ColorsFactoryImpl;
import by.pavlovskii.ilya.mvvm.test.ui.adapters.ColorAdapter;
import by.pavlovskii.ilya.mvvm.test.utils.factory.ColorsFactory;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 12.05.2018<br>
 * Time: 20:56<br>
 * Project name: MVVMtest<br>
 * ===================================================================================<br>
 */
@Module
public abstract class AdapterModule {

    @Binds
    abstract RecyclerView.Adapter bindRecyclerView(@NonNull ColorAdapter adapter);

    @Binds
    abstract ColorsFactory bindColorsFactory(@NonNull ColorsFactoryImpl impl);

    @Binds
    @IntoMap
    @ViewModelKey(AdapterViewModel.class)
    abstract BaseViewModel bindAdapterViewModel(@NonNull AdapterViewModel viewModel);
}
