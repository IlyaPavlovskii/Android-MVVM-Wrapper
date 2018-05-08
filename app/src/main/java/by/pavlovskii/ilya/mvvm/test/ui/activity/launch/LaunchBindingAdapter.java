package by.pavlovskii.ilya.mvvm.test.ui.activity.launch;

import android.databinding.BindingAdapter;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import by.mvvmwrapper.utils.binding.RootBindingAdapter;
import by.pavlovskii.ilya.mvvm.test.models.SampleItem;
import by.pavlovskii.ilya.mvvm.test.ui.adapters.SampleItemAdapter;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;
import java.util.List;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 09.05.2018<br>
 * Time: 1:25<br>
 * Project name: MVVMtest<br>
 * ===================================================================================<br>
 */
@Singleton
public class LaunchBindingAdapter {

    @NonNull
    private final Provider<? extends RecyclerView.Adapter> mAdapterProvider;

    @Inject
    public LaunchBindingAdapter(@NonNull Provider<SampleItemAdapter> adapterProvider) {
        this.mAdapterProvider = adapterProvider;
    }

    @BindingAdapter("bindSampleAdapter")
    public void bindSampleAdapter(@NonNull RecyclerView recyclerView, @Nullable List<SampleItem> list) {
        RootBindingAdapter.bindAdapter(mAdapterProvider, recyclerView, list, SampleItem.class);
    }
}
