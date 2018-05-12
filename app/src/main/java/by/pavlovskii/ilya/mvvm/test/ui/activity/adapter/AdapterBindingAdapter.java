package by.pavlovskii.ilya.mvvm.test.ui.activity.adapter;

import android.databinding.BindingAdapter;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import by.mvvmwrapper.utils.binding.RootBindingAdapter;
import by.pavlovskii.ilya.mvvm.test.ui.adapters.ColorAdapter;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;
import java.util.List;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 12.05.2018<br>
 * Time: 21:37<br>
 * Project name: MVVMtest<br>
 * ===================================================================================<br>
 */
@Singleton
public class AdapterBindingAdapter {

    @NonNull
    private final Provider<? extends RecyclerView.Adapter> mAdapterProvider;

    @Inject
    public AdapterBindingAdapter(@NonNull Provider<ColorAdapter> adapterProvider) {
        mAdapterProvider = adapterProvider;
    }

    @BindingAdapter("bindColorAdapter")
    public void bindColorAdapter(@NonNull RecyclerView recyclerView, @Nullable List<String> list) {
        RootBindingAdapter.bindAdapter(mAdapterProvider, recyclerView, list);
    }
}
