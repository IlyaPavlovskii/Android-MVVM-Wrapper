package by.pavlovskii.ilya.mvvm.test.ui.adapters;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import by.mvvmwrapper.adapter.BaseRecyclerViewAdapter;
import by.pavlovskii.ilya.mvvm.test.R;
import by.pavlovskii.ilya.mvvm.test.databinding.AdapterSampleItemBinding;
import by.pavlovskii.ilya.mvvm.test.models.SampleItem;

import javax.inject.Inject;
import java.util.Objects;

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
    protected SampleViewHolder createViewHolder(@NonNull View view) {
        return new SampleViewHolder(view);
    }

    @Override
    public Class<SampleItem> getModelClass() {
        return SampleItem.class;
    }

    public void setOnSampleItemClickListener(@Nullable OnSampleItemClickListener onSampleItemClickListener) {
        mOnSampleItemClickListener = onSampleItemClickListener;
    }

    public class SampleViewHolder extends BaseRecyclerViewAdapter.ViewHolder<SampleItem> {

        @NonNull
        private AdapterSampleItemBinding mBinding;

        SampleViewHolder(@NonNull View itemView) {
            super(itemView);
            mBinding = Objects.requireNonNull(DataBindingUtil.bind(itemView));
            mBinding.setOnItemClickListener((View.OnClickListener) v -> {
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
