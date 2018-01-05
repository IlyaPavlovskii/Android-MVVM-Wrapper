package by.pavlovskii.ilya.mvvm.test.ui.activity.main;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import by.pavlovskii.ilya.mvvm.test.models.DemoActivity;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 05.01.2018<br>
 * Time: 22:31<br>
 * Project name: MVVMtest<br>
 * ===================================================================================<br>
 */
public class MainBindingAdapter {

    @BindingAdapter({"demoAdapter"})
    public static void demoAdapter(@NonNull RecyclerView recyclerView, @Nullable List<DemoActivity> list) {
        if (list == null) {
            return;
        }
        Context context = recyclerView.getContext();

        if (recyclerView.getAdapter() == null) {
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            recyclerView.setAdapter(new DemoAdapter(context, list));
        } else if (recyclerView.getAdapter() instanceof DemoAdapter) {
            ((DemoAdapter) recyclerView.getAdapter()).setList(list);
            recyclerView.getAdapter().notifyDataSetChanged();
        }
    }

    @BindingAdapter({"demoAdapterListener"})
    public static void demoAdapterListener(@NonNull RecyclerView recyclerView,
                                           @Nullable DemoAdapter.OnDemoAdapterListener listener) {
        if (recyclerView.getAdapter() instanceof DemoAdapter) {
            ((DemoAdapter) recyclerView.getAdapter()).setOnDemoAdapterListener(listener);
        }
    }
}
