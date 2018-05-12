package by.pavlovskii.ilya.mvvm.test.ui.adapters;

import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import by.mvvmwrapper.adapter.BaseRecyclerViewAdapter;
import by.pavlovskii.ilya.mvvm.test.R;
import by.pavlovskii.ilya.mvvm.test.databinding.AdapterSampleItemBinding;
import by.pavlovskii.ilya.mvvm.test.models.SampleItem;

import javax.inject.Inject;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 09.05.2018<br>
 * Time: 1:46<br>
 * Project name: MVVMtest<br>
 * ===================================================================================<br>
 */
public class SampleItemAdapter extends BaseRecyclerViewAdapter<SampleItem, SampleItemAdapter.SampleViewHolder> {

    public interface OnSampleItemClickListener {
        void onSampleClick(SampleItem item);
    }

    @Nullable
    private OnSampleItemClickListener mOnSampleItemClickListener;

    @Inject
    public SampleItemAdapter() {
    }

    @Override
    protected int getLayoutRes(int viewType) {
        return R.layout.adapter_sample_item;
    }

    @NonNull
    @Override
    protected SampleViewHolder createViewHolder(@NonNull ViewDataBinding binding, int viewType) {
        return new SampleViewHolder((AdapterSampleItemBinding) binding);
    }

    @Override
    public Class<SampleItem> getModelClass() {
        return SampleItem.class;
    }

    public void setOnSampleItemClickListener(@Nullable OnSampleItemClickListener onSampleItemClickListener) {
        mOnSampleItemClickListener = onSampleItemClickListener;
    }

    public class SampleViewHolder extends BaseRecyclerViewAdapter.ViewHolder<SampleItem, AdapterSampleItemBinding> {

        SampleViewHolder(@NonNull AdapterSampleItemBinding itemView) {
            super(itemView);
            mBinding.setOnItemClickListener(v -> {
                if (mOnSampleItemClickListener != null) {
                    mOnSampleItemClickListener.onSampleClick(mBinding.getModel());
                }
            });
        }

        @Override
        protected void bind(@NonNull SampleItem item) {
            mBinding.setModel(item);
        }
    }
}
