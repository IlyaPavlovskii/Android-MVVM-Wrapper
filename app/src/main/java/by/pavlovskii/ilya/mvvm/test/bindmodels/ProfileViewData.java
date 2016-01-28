package by.pavlovskii.ilya.mvvm.test.bindmodels;

import java.util.ArrayList;
import java.util.List;

import by.pavlovskii.ilya.mvvm.test.wrapper.BindableGeneric;

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

}
