package by.mvvmwrapper.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import by.mvvmwrapper.viewdata.ViewData;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 10.11.2017<br>
 * Time: 17:56<br>
 * Project name: MVVMtest<br>
 * ===================================================================================<br>
 * Recycler view base on {@link ViewDataBinding}<br>
 * ===================================================================================<br>
 */
public abstract class BindRecyclerViewAdapter<T, TViewDataBinding extends ViewDataBinding, TViewData extends ViewData> extends RecyclerView.Adapter<BindRecyclerViewAdapter.ViewHolder> {
    //===================================================================================
    //----------------------------------- Fields ----------------------------------------
    //===================================================================================
    @NonNull
    protected List<T> mList;
    @NonNull
    protected LayoutInflater mLayoutInflater;

    //===================================================================================
    //--------------------------------- Constructor -------------------------------------
    //===================================================================================
    public BindRecyclerViewAdapter(@NonNull Context context, @NonNull List<T> list) {
        mLayoutInflater = LayoutInflater.from(context);
        mList = list;
    }

    //===================================================================================
    //------------------------------- Abstract methods ----------------------------------
    //===================================================================================
    @LayoutRes
    protected abstract int getLayoutRes(int viewType);

    @NonNull
    protected abstract BindRecyclerViewAdapter.ViewHolder<T, TViewDataBinding, TViewData> createViewHolder(TViewDataBinding binding);

    //===================================================================================
    //------------------------------- Override methods ----------------------------------
    //===================================================================================
    @Override
    public BindRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int layoutRes = getLayoutRes(viewType);
        TViewDataBinding binding = DataBindingUtil.inflate(mLayoutInflater, layoutRes, parent, false);
        return createViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(BindRecyclerViewAdapter.ViewHolder holder, int position) {
        T item = getItem(position);
        holder.bind(item);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    //===================================================================================
    //------------------------------Protected methods------------------------------------
    //===================================================================================
    @NonNull
    protected T getItem(int position) {
        return mList.get(position);
    }

    public void setList(List<T> list) {
        this.mList = list;
    }

    //===================================================================================
    //-------------------------------Inner classes---------------------------------------
    //===================================================================================
    public abstract static class ViewHolder<T, TViewDataBinding, TViewData>
            extends RecyclerView.ViewHolder {

        protected TViewData mViewData;

        public ViewHolder(TViewDataBinding binding) {
            super(((ViewDataBinding) binding).getRoot());
            mViewData = initViewData();
            if (mViewData == null) {
                throw new NullPointerException("ViewData must not be null");
            }
        }

        protected void bind(T item) {
            convertToViewData(item, mViewData);
        }

        protected abstract void convertToViewData(T item, TViewData viewData);

        protected abstract TViewData initViewData();

    }
}
