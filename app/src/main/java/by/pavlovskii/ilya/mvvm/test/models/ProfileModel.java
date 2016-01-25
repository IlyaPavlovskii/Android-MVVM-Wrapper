package by.pavlovskii.ilya.mvvm.test.models;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import by.pavlovskii.ilya.mvvm.test.BR;
import by.pavlovskii.ilya.mvvm.test.models.wrapper.BindableString;

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
public class ProfileModel {

    //======================================================
    //------------------------Fields------------------------
    //======================================================
    public BindableString name;
    public BindableString surname;
    public BindableString phone;

    //======================================================
    //----------------------Constructor---------------------
    //======================================================
    public ProfileModel(){
        this.name       =   new BindableString();
        this.surname    =   new BindableString();
        this.phone      =   new BindableString();
    }

    public ProfileModel(String name, String surname, String phone) {
        this.name       =   new BindableString(name);
        this.surname    =   new BindableString(surname);
        this.phone      =   new BindableString(phone);
    }



    //======================================================
    //--------------------Override methods------------------
    //======================================================
    @Override
    public String toString() {
        return "Name: " + name + ";\n "+
                "Surname: " + surname + ";\n " +
                "Phone: " + phone + ";\n";
    }

}
