package by.pavlovskii.ilya.mvvm.test.viewmodel;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;

import java.util.ArrayList;
import java.util.List;

import by.pavlovskii.ilya.mvvm.test.adapters.ProfileAdapter;
import by.pavlovskii.ilya.mvvm.test.databinding.ActivityProfileBinding;
import by.pavlovskii.ilya.mvvm.test.models.ProfileModel;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 06.01.16<br>
 * Time: 19:20<br>
 * Project name: MVVMtest<br>
 * ===================================================================================
 * //TODO Add description<br>
 * ===================================================================================
 */
public class ProfileActivityViewModel implements IViewModel<ActivityProfileBinding>{

    //======================================================
    //------------------------Fields------------------------
    //======================================================
    public List<ProfileModel> mProfileList = new ArrayList<>();
    public ProfileModel mProfileModel;

    //======================================================
    //-------------------Override methods-------------------
    //======================================================
    @Override
    public void initModel() {
        mProfileList = new ArrayList<>();
        mProfileList.add(new ProfileModel("Ivan","Ivanov","9379992"));
        mProfileList.add(new ProfileModel("Petr","Petrov","2020327"));
        mProfileList.add(new ProfileModel("Atrem","Babuk","2020302"));
        mProfileList.add(new ProfileModel("Pikabu","Pikabushevich","1233210"));
        mProfileList.add(new ProfileModel("Ivan","Ivanov","9379992"));
        mProfileList.add(new ProfileModel("Petr","Petrov","2020327"));
        mProfileList.add(new ProfileModel("Atrem","Babuk","2020302"));
        mProfileList.add(new ProfileModel("Pikabu","Pikabushevich","1233210"));
        mProfileList.add(new ProfileModel("Ivan","Ivanov","9379992"));
        mProfileList.add(new ProfileModel("Petr","Petrov","2020327"));
        mProfileList.add(new ProfileModel("Atrem","Babuk","2020302"));
        mProfileList.add(new ProfileModel("Pikabu","Pikabushevich","1233210"));
        mProfileList.add(new ProfileModel("Ivan","Ivanov","9379992"));
        mProfileList.add(new ProfileModel("Petr","Petrov","2020327"));
        mProfileList.add(new ProfileModel("Atrem","Babuk","2020302"));
        mProfileList.add(new ProfileModel("Pikabu","Pikabushevich","1233210"));
        mProfileList.add(new ProfileModel("Ivan","Ivanov","9379992"));
        mProfileList.add(new ProfileModel("Petr","Petrov","2020327"));
        mProfileList.add(new ProfileModel("Atrem","Babuk","2020302"));
        mProfileList.add(new ProfileModel("Pikabu","Pikabushevich","1233210"));
        mProfileList.add(new ProfileModel("Ivan","Ivanov","9379992"));
        mProfileList.add(new ProfileModel("Petr","Petrov","2020327"));
        mProfileList.add(new ProfileModel("Atrem","Babuk","2020302"));
        mProfileList.add(new ProfileModel("Pikabu","Pikabushevich","1233210"));
        mProfileList.add(new ProfileModel("Ivan","Ivanov","9379992"));
        mProfileList.add(new ProfileModel("Petr","Petrov","2020327"));
        mProfileList.add(new ProfileModel("Atrem","Babuk","2020302"));
        mProfileList.add(new ProfileModel("Pikabu","Pikabushevich","1233210"));
        mProfileList.add(new ProfileModel("Ivan","Ivanov","9379992"));
        mProfileList.add(new ProfileModel("Petr","Petrov","2020327"));
        mProfileList.add(new ProfileModel("Atrem","Babuk","2020302"));
        mProfileList.add(new ProfileModel("Pikabu","Pikabushevich","1233210"));
        mProfileList.add(new ProfileModel("Ivan","Ivanov","9379992"));
        mProfileList.add(new ProfileModel("Petr","Petrov","2020327"));
        mProfileList.add(new ProfileModel("Atrem","Babuk","2020302"));
        mProfileList.add(new ProfileModel("Pikabu","Pikabushevich","1233210"));
        mProfileList.add(new ProfileModel("Ivan","Ivanov","9379992"));
        mProfileList.add(new ProfileModel("Petr","Petrov","2020327"));
        mProfileList.add(new ProfileModel("Atrem","Babuk","2020302"));
        mProfileList.add(new ProfileModel("Pikabu","Pikabushevich","1233210"));

        mProfileModel = new ProfileModel();
    }

    @Override
    public void bindData(Context context, ActivityProfileBinding viewDataBinding) {
        viewDataBinding.setProfile(mProfileModel);

        viewDataBinding.vRecyclerView.setHasFixedSize(true);
        viewDataBinding.vRecyclerView.setLayoutManager(new LinearLayoutManager(context));
        viewDataBinding.vRecyclerView.setAdapter(new ProfileAdapter(context, mProfileList));
    }

    @Override
    public void destroy() {
        mProfileList.clear();
        mProfileList = null;
    }

    //======================================================
    //---------------------Init methods---------------------
    //======================================================

    //======================================================
    //------------------------Events------------------------
    //======================================================

    //======================================================
    //--------------------Private methods-------------------
    //======================================================

    //======================================================
    //-------------------Protected methods------------------
    //======================================================

    //======================================================
    //---------------------Public methods-------------------
    //======================================================

    //======================================================
    //-----------------------Listeners----------------------
    //======================================================

    //======================================================
    //---------------------Inner classes--------------------
    //======================================================
}
