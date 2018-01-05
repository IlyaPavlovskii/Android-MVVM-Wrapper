package by.mvvmwrapper.adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
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
public abstract class BaseRecyclerViewAdapter<T> extends RecyclerView.Adapter<BaseRecyclerViewAdapter.ViewHolder> {

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
    public BaseRecyclerViewAdapter(@NonNull Context context, @NonNull List<T> list) {
        mLayoutInflater = LayoutInflater.from(context);
        mList = list;
    }

    //===================================================================================
    //------------------------------- Abstract methods ----------------------------------
    //===================================================================================
    @LayoutRes
    protected abstract int getLayoutRes(int viewType);

    @NonNull
    protected abstract ViewHolder<T> createViewHolder(View view);

    @NonNull
    protected abstract T getItem(int position);

    //===================================================================================
    //------------------------------- Override methods ----------------------------------
    //===================================================================================
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(getLayoutRes(viewType), parent, false);
        return createViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        T item = getItem(position);
        holder.bind(item);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    //===================================================================================
    //-------------------------------Inner classes---------------------------------------
    //===================================================================================
    public abstract static class ViewHolder<T> extends RecyclerView.ViewHolder {

        public ViewHolder(View itemView) {
            super(itemView);
        }

        protected abstract void bind(T item);
    }
}
