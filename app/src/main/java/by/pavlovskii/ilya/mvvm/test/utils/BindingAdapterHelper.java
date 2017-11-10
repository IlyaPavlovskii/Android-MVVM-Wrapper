package by.pavlovskii.ilya.mvvm.test.utils;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import by.pavlovskii.ilya.mvvm.test.adapters.DemoAdapter;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 15.06.16<br>
 * Time: 0:18<br>
 * Project name: MVVMtest<br>
 * ===================================================================================
 * All {@link BindingAdapter} methods used in current project<br>
 * ===================================================================================
 */
public class BindingAdapterHelper {

    //======================================================
    //---------------------Constructors---------------------
    //======================================================

    /**
     * Implement default constructor
     */
    private BindingAdapterHelper() {
    }

    //======================================================
    //---------------------Public methods-------------------
    //======================================================
    @BindingAdapter({"attr:demoAdapter"})
    public static void demoAdapter(@NonNull RecyclerView recyclerView, @Nullable List<String> list) {
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

}
