package by.pavlovskii.ilya.mvvm.test.ui.adapters;

import android.databinding.ViewDataBinding;
import android.graphics.Color;
import android.support.annotation.NonNull;
import by.mvvmwrapper.adapter.BaseRecyclerViewAdapter;
import by.pavlovskii.ilya.mvvm.test.R;
import by.pavlovskii.ilya.mvvm.test.databinding.AdapterColorBinding;

import javax.inject.Inject;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 12.05.2018<br>
 * Time: 21:10<br>
 * Project name: MVVMtest<br>
 * ===================================================================================<br>
 */
public class ColorAdapter extends BaseRecyclerViewAdapter<String, ColorAdapter.ViewHolder> {

    @Inject
    public ColorAdapter() {
    }

    @Override
    protected int getLayoutRes(int viewType) {
        return R.layout.adapter_color;
    }

    @NonNull
    @Override
    protected ColorAdapter.ViewHolder createViewHolder(@NonNull ViewDataBinding binding, int viewType) {
        return new ViewHolder((AdapterColorBinding) binding);
    }

    public class ViewHolder extends BaseRecyclerViewAdapter.ViewHolder<String, AdapterColorBinding> {

        ViewHolder(AdapterColorBinding binding) {
            super(binding);
        }

        @Override
        protected void bind(@NonNull String item) {
            mBinding.setColor(Color.parseColor(item));
        }
    }
}
