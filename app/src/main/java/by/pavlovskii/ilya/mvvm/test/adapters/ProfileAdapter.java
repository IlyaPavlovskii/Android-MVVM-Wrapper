package by.pavlovskii.ilya.mvvm.test.adapters;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import by.pavlovskii.ilya.mvvm.test.R;
import by.pavlovskii.ilya.mvvm.test.viewdata.ProfileViewData;
import by.pavlovskii.ilya.mvvm.test.databinding.ProfileItemBinding;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 06.01.16<br>
 * Time: 12:36<br>
 * Project name: MVVMtest<br>
 * ===================================================================================
 * {@link by.pavlovskii.ilya.mvvm.test.activity.ProfileActivity} adapter. Used for binding data on
 * {@link RecyclerView} component<br>
 * ===================================================================================
 */
public class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.ProfileAdapterHolder> {

    //======================================================
    //------------------------Fields------------------------
    //======================================================
    private final LayoutInflater mInflater;
    private List<ProfileViewData> mProfileList;

    //======================================================
    //---------------------Constructors---------------------
    //======================================================
    public ProfileAdapter(Context context, List<ProfileViewData> profileList) {
        super();
        this.mInflater = LayoutInflater.from(context);
        this.mProfileList = profileList;
    }

    //======================================================
    //-------------------Override methods-------------------
    //======================================================
    @Override
    public ProfileAdapterHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.profile_item, parent, false);
        return new ProfileAdapterHolder(view);
    }

    @Override
    public void onBindViewHolder(ProfileAdapterHolder holder, int position) {
        holder.bind(getItem(position));
    }

    @Override
    public int getItemCount() {
        return mProfileList.size();
    }

    //======================================================
    //-------------------Private methods--------------------
    //======================================================
    private ProfileViewData getItem(int position) {
        return mProfileList.get(position);
    }

    //======================================================
    //---------------------Inner classes--------------------
    //======================================================
    public static class ProfileAdapterHolder extends RecyclerView.ViewHolder{

        private ProfileItemBinding binding;

        public ProfileAdapterHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }

        public void bind(ProfileViewData viewData) {
            binding.setProfile(viewData);
        }
    }
}
