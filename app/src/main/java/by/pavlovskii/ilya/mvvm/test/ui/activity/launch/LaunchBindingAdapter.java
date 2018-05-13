package by.pavlovskii.ilya.mvvm.test.ui.activity.launch;

import android.databinding.BindingAdapter;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import by.mvvmwrapper.adapter.UpdateAdapter;
import by.mvvmwrapper.utils.binding.RecyclerViewBindingAdapter;
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
        RecyclerViewBindingAdapter.bindAdapter(mAdapterProvider, recyclerView, list);
    }

    @BindingAdapter("bindSampleAdapter")
    public static void bindAdapter(@NonNull RecyclerView recyclerView, @Nullable List<SampleItem> list) {
        if (list != null) {
            if (recyclerView.getAdapter() == null) {
                RecyclerView.Adapter adapter = new SampleItemAdapter();
                recyclerView.setAdapter(adapter);
            }
            if (recyclerView.getAdapter() instanceof UpdateAdapter) {
                ((UpdateAdapter) recyclerView.getAdapter())
                        .update(list);
            }
        }
    }

    @BindingAdapter("bindOnSampleItemClickListener")
    public void bindOnSampleItemClickListener(@NonNull RecyclerView recyclerView,
                                              @Nullable SampleItemAdapter.OnSampleItemClickListener listener) {
        if (recyclerView.getAdapter() instanceof SampleItemAdapter) {
            ((SampleItemAdapter) recyclerView.getAdapter()).setOnSampleItemClickListener(listener);
        }
    }
}
