package by.mvvmwrapper.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 10.11.2017<br>
 * Time: 17:46<br>
 * Project name: MVVMtest<br>
 * ===================================================================================<br>
 * Base recycler view adapter implementation for generic<br>
 * ===================================================================================<br>
 */
public abstract class BaseRecyclerViewAdapter<T, H extends BaseRecyclerViewAdapter.ViewHolder>
        extends RecyclerView.Adapter<H>
        implements UpdateAdapter<T> {

    //===================================================================================
    //----------------------------------- Fields ----------------------------------------
    //===================================================================================
    @Nullable
    protected List<T> mList;

    //===================================================================================
    //--------------------------------- Constructor -------------------------------------
    //===================================================================================

    public BaseRecyclerViewAdapter() {
    }

    public BaseRecyclerViewAdapter(@Nullable List<T> list) {
        mList = list;
    }

    //===================================================================================
    //------------------------------- Abstract methods ----------------------------------
    //===================================================================================
    @LayoutRes
    protected abstract int getLayoutRes(int viewType);

    @NonNull
    protected abstract H createViewHolder(@NonNull ViewDataBinding binding, int viewType);

    //===================================================================================
    //------------------------------- Override methods ----------------------------------
    //===================================================================================
    @NonNull
    @Override
    public H onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewDataBinding binding = DataBindingUtil.inflate(
                getLayoutInflater(parent),
                getLayoutRes(viewType),
                parent,
                false);
        return createViewHolder(binding, viewType);
    }

    @Override
    public void onBindViewHolder(@NonNull H holder, int position) {
        T item = getItem(position);
        holder.bind(item);
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    @Override
    public void update(List<T> list) {
        this.mList = list;
        notifyDataSetChanged();
    }

    //===================================================================================
    //------------------------------ Protected methods ----------------------------------
    //===================================================================================
    @NonNull
    protected T getItem(int position) {
        if (mList != null && (position >= 0 && position < mList.size())) {
            return mList.get(position);
        }
        throw new IndexOutOfBoundsException();
    }

    @NonNull
    protected LayoutInflater getLayoutInflater(@NonNull View view) {
        return getLayoutInflater(view.getContext());
    }

    @NonNull
    protected LayoutInflater getLayoutInflater(@NonNull Context context) {
        return LayoutInflater.from(context);
    }

    //===================================================================================
    //-------------------------------Inner classes---------------------------------------
    //===================================================================================
    public abstract static class ViewHolder<T, B extends ViewDataBinding>
            extends RecyclerView.ViewHolder {

        @NonNull
        protected B mBinding;

        public ViewHolder(B binding) {
            super(binding.getRoot());
            mBinding = binding;
        }

        protected abstract void bind(@NonNull T item);

    }
}
