package by.pavlovskii.ilya.mvvm.test.ui.activity.adapter;

import android.databinding.BindingAdapter;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import by.mvvmwrapper.adapter.UpdateAdapter;
import by.pavlovskii.ilya.mvvm.test.R;
import by.pavlovskii.ilya.mvvm.test.databinding.ActivityAdapterBinding;
import by.pavlovskii.ilya.mvvm.test.ui.activity.BaseActivity;
import timber.log.Timber;

import javax.inject.Inject;
import javax.inject.Provider;
import java.util.List;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 12.05.2018<br>
 * Time: 20:32<br>
 * Project name: MVVMtest<br>
 * ===================================================================================<br>
 */
public class AdapterActivity extends BaseActivity<AdapterViewModel, ActivityAdapterBinding> {

    @Inject
    Provider<RecyclerView.Adapter> mAdapterProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding.setVerticalAdapter(mAdapterProvider.get());
        mBinding.setHorizontalAdapter(mAdapterProvider.get());
        addDisposable(mViewModel.initList()
                .subscribe(
                        () -> Timber.d("initList complete: "),
                        this::handleException));
    }

    @Override
    protected Class<AdapterViewModel> getViewModelClass() {
        return AdapterViewModel.class;
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_adapter;
    }

    @BindingAdapter({"bindAdapter", "bindList"})
    public static void bindAdapter(@NonNull RecyclerView recyclerView,
                                   @Nullable RecyclerView.Adapter adapter,
                                   @Nullable List list) {
        if (adapter != null) {
            if (recyclerView.getAdapter() == null) {
                recyclerView.setAdapter(adapter);
            }
            if (adapter instanceof UpdateAdapter) {
                ((UpdateAdapter) adapter).update(list);
            }
        }

    }
}
