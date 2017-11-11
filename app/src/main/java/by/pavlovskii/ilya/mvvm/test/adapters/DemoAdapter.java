package by.pavlovskii.ilya.mvvm.test.adapters;

import android.content.Context;
import android.support.annotation.NonNull;

import java.util.List;

import by.mvvmwrapper.adapter.BindRecyclerViewAdapter;
import by.pavlovskii.ilya.mvvm.test.R;
import by.pavlovskii.ilya.mvvm.test.databinding.AdapterDemoItemBinding;
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
public class DemoAdapter extends BindRecyclerViewAdapter<String, AdapterDemoItemBinding, DemoViewData> {

    public DemoAdapter(@NonNull Context context, @NonNull List<String> list) {
        super(context, list);
    }

    @Override
    protected int getLayoutRes(int viewType) {
        return R.layout.adapter_demo_item;
    }

    @NonNull
    @Override
    protected ViewHolder<String, AdapterDemoItemBinding, DemoViewData> createViewHolder(AdapterDemoItemBinding binding) {
        return new DemoViewHolder(binding);
    }

    private class DemoViewHolder extends ViewHolder<String, AdapterDemoItemBinding, DemoViewData> {

        DemoViewHolder(AdapterDemoItemBinding adapterDemoItemBinding) {
            super(adapterDemoItemBinding);
            adapterDemoItemBinding.setModel(mViewData);
        }

        @Override
        protected void convertToViewData(String item, DemoViewData viewData) {
            viewData.title.set(item);
        }

        @Override
        protected DemoViewData initViewData() {
            return new DemoViewData();
        }
    }
}
