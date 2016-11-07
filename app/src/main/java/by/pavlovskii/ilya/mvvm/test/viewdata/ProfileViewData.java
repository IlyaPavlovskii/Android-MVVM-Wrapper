package by.pavlovskii.ilya.mvvm.test.viewdata;

import android.support.annotation.Nullable;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import by.mvvmwrapper.viewdata.IViewData;
import by.mvvmwrapper.wrapper.BindableGeneric;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 06.01.16<br>
 * Time: 12:40<br>
 * Project name: MVVMtest<br>
 * ===================================================================================
 * //TODO Add description<br>
 * ===================================================================================
 */
public class ProfileViewData implements IViewData {

    //======================================================
    //------------------------Fields------------------------
    //======================================================
    public BindableGeneric<String> name;
    public BindableGeneric<String> surname;
    public BindableGeneric<String> phone;
    public BindableGeneric<Boolean> bool;
    public BindableGeneric<Integer> status;
    public BindableGeneric<List<ProfileViewData>> profiles;

    //======================================================
    //----------------------Constructor---------------------
    //======================================================
    public ProfileViewData() {
        this.name = new BindableGeneric<>(null);
        this.surname = new BindableGeneric<>(null);
        this.phone = new BindableGeneric<>(null);
        this.bool = new BindableGeneric<>(false);
        this.status = new BindableGeneric<>(0);

        List<ProfileViewData> list = new ArrayList<>();
        list.add(new ProfileViewData("Eric", "Cartman", "2020327"));
        list.add(new ProfileViewData("Kenny", "McCormick", "911"));
        list.add(new ProfileViewData("Stan", "Marsh", "6661313"));
        list.add(new ProfileViewData("Kyle", "Broflovski", "9379992"));
        list.add(new ProfileViewData("Wendy", "Testaburger", ""));
        list.add(new ProfileViewData("Butters", "Stotch", ""));
        list.add(new ProfileViewData("Terrance", "", ""));
        list.add(new ProfileViewData("Phillip", "", ""));
        list.add(new ProfileViewData("Ugly", "Bob", ""));
        list.add(new ProfileViewData("Al", "Big Gay", ""));
        list.add(new ProfileViewData("Ike", "Broflovski", ""));
        list.add(new ProfileViewData("Chief", "", ""));
        list.add(new ProfileViewData("Mr.", "Hankey", ""));
        list.add(new ProfileViewData("Mr.", "Garrison", ""));
        list.add(new ProfileViewData("Jimmy", "Valmer", ""));
        list.add(new ProfileViewData("Timmy", "Burch", ""));
        this.profiles = new BindableGeneric<>(list);

    }

    public ProfileViewData(@Nullable String name, @Nullable String surname, @Nullable String phone) {
        this.name = new BindableGeneric<>(name);
        this.surname = new BindableGeneric<>(surname);
        this.phone = new BindableGeneric<>(phone);
        this.bool = new BindableGeneric<>(false);
        this.status = new BindableGeneric<>(0);
        this.profiles = new BindableGeneric<>(new ArrayList<>());
    }

    //======================================================
    //--------------------Override methods------------------
    //======================================================
    @Override
    public String toString() {
        return "Name: " + name + ";\n "+
                "Surname: " + surname + ";\n " +
                "Phone: " + phone + ";\n" +
                "Checkbox: " + bool + ";\n" +
                "Status: " + status + ";\n";
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
