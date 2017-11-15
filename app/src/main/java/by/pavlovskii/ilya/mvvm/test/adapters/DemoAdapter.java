package by.pavlovskii.ilya.mvvm.test.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.List;

import by.mvvmwrapper.adapter.BindRecyclerViewAdapter;
import by.pavlovskii.ilya.mvvm.test.R;
import by.pavlovskii.ilya.mvvm.test.databinding.AdapterDemoItemBinding;
import by.pavlovskii.ilya.mvvm.test.models.DemoActivity;
import by.pavlovskii.ilya.mvvm.test.viewdata.DemoViewData;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 10.11.2017<br>
 * Time: 19:12<br>
 * Project name: MVVMtest<br>
 * ===================================================================================<br>
 */
public class DemoAdapter extends BindRecyclerViewAdapter<DemoActivity, AdapterDemoItemBinding, DemoViewData> {

    public interface OnDemoAdapterListener {
        void onActivityClick(@Nullable DemoActivity key);
    }

    @Nullable
    private OnDemoAdapterListener mOnDemoAdapterListener;

    public DemoAdapter(@NonNull Context context, @NonNull List<DemoActivity> list) {
        super(context, list);
    }

    @Override
    protected int getLayoutRes(int viewType) {
        return R.layout.adapter_demo_item;
    }

    @NonNull
    @Override
    protected ViewHolder<DemoActivity, AdapterDemoItemBinding, DemoViewData> createViewHolder(AdapterDemoItemBinding binding) {
        return new DemoViewHolder(binding);
    }

    public void setOnDemoAdapterListener(@Nullable OnDemoAdapterListener onDemoAdapterListener) {
        mOnDemoAdapterListener = onDemoAdapterListener;
    }

    private class DemoViewHolder extends ViewHolder<DemoActivity, AdapterDemoItemBinding, DemoViewData> {

        private DemoActivity mDemoActivity;

        DemoViewHolder(AdapterDemoItemBinding adapterDemoItemBinding) {
            super(adapterDemoItemBinding);
            adapterDemoItemBinding.setModel(mViewData);
            adapterDemoItemBinding.setOnClickListener(view -> {
                if (mOnDemoAdapterListener != null) {
                    mOnDemoAdapterListener.onActivityClick(mDemoActivity);
                }
            });
        }

        @Override
        protected void convertToViewData(DemoActivity item, DemoViewData viewData) {
            mDemoActivity = item;
            viewData.title.set(item.getCommand() + ":" + item.getScreen());
        }

        @Override
        protected DemoViewData initViewData() {
            return new DemoViewData();
        }
    }
}
