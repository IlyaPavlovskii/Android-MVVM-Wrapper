package by.mvvmwrapper.utils.binding;

import android.databinding.BindingAdapter;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import by.mvvmwrapper.adapter.UpdateAdapter;

import javax.inject.Provider;
import java.util.List;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 14.05.2018<br>
 * Time: 2:24<br>
 * Project name: MVVMtest<br>
 * <p>
 * Bind {@link RecyclerView.Adapter} to {@link RecyclerView} and update data list methods
 */
public class RecyclerViewBindingAdapter {

    @BindingAdapter({"bindAdapter", "bindList"})
    public static void bindAdapter(@NonNull RecyclerView recyclerView,
                                   @Nullable RecyclerView.Adapter adapter,
                                   @Nullable List list) {
        bindAdapter(recyclerView, adapter);
        bindList(recyclerView, list);
    }

    /**
     * Attach {@link RecyclerView.Adapter} to {@link RecyclerView} widget
     */
    @BindingAdapter("bindAdapter")
    public static void bindAdapter(@NonNull RecyclerView recyclerView,
                                   @Nullable RecyclerView.Adapter adapter) {
        if (adapter != null && recyclerView.getAdapter() == null) {
            recyclerView.setAdapter(adapter);
        }
    }

    /**
     * Update data list on {@link RecyclerView}
     * Your {@link RecyclerView.Adapter} must implement {@link UpdateAdapter}
     */
    @BindingAdapter("bindList")
    public static void bindList(@NonNull RecyclerView recyclerView,
                                @Nullable List list) {
        if (recyclerView.getAdapter() instanceof UpdateAdapter) {
            ((UpdateAdapter) recyclerView.getAdapter())
                    .update(list);
        }
    }

    /**
     * Attach {@link RecyclerView.Adapter} to {@link RecyclerView} widget and update data list.
     * Receive adapter from dagger {@link Provider} instance.
     * Your {@link RecyclerView.Adapter} must implement {@link UpdateAdapter}
     */
    public static void bindAdapter(@NonNull Provider<? extends RecyclerView.Adapter> adapterProvider,
                                   @NonNull RecyclerView recyclerView,
                                   @Nullable List list) {
        if (list != null) {
            if (recyclerView.getAdapter() == null) {
                RecyclerView.Adapter adapter = adapterProvider.get();
                recyclerView.setAdapter(adapter);
            }
            if (recyclerView.getAdapter() instanceof UpdateAdapter) {
                ((UpdateAdapter) recyclerView.getAdapter())
                        .update(list);
            }
        }
    }

}
