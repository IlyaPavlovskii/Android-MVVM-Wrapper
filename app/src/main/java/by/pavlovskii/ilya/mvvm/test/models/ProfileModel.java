package by.pavlovskii.ilya.mvvm.test.models;

import by.pavlovskii.ilya.mvvm.test.models.wrapper.BindableGeneric;

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
    public BindableGeneric<String> name;
    public BindableGeneric<String> surname;
    public BindableGeneric<String> phone;
    public BindableGeneric<Boolean> checkbox;

    //======================================================
    //----------------------Constructor---------------------
    //======================================================
    public ProfileModel(){
        this.name = new BindableGeneric<>(null);
        this.surname = new BindableGeneric<>(null);
        this.phone = new BindableGeneric<>(null);
        this.checkbox = new BindableGeneric<>(false);
    }

    public ProfileModel(String name, String surname, String phone) {
        this.name = new BindableGeneric<>(name);
        this.surname = new BindableGeneric<>(surname);
        this.phone = new BindableGeneric<>(phone);
    }

    //======================================================
    //--------------------Override methods------------------
    //======================================================
    @Override
    public String toString() {
        return "Name: " + name + ";\n "+
                "Surname: " + surname + ";\n " +
                "Phone: " + phone + ";\n" +
                "Checkbox: " + checkbox + ";\n";
    }

}
