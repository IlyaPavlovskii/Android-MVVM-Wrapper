package by.pavlovskii.ilya.mvvm.test.bindingmodels;

import by.mvvmwrapper.bindmodels.IViewData;
import by.mvvmwrapper.wrapper.BindableGeneric;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 02.02.16<br>
 * Time: 22:25<br>
 * Project name: MVVMtest<br>
 * ===================================================================================
 * //TODO Add description<br>
 * ===================================================================================
 */
public class SpellCheckerViewData implements IViewData {

    //======================================================
    //------------------------Fields------------------------
    //======================================================
    public BindableGeneric<String> search;

    //======================================================
    //---------------------Constructors---------------------
    //======================================================
    public SpellCheckerViewData() {
        search = new BindableGeneric<>(null);
    }

    public SpellCheckerViewData(BindableGeneric<String> search) {
        this.search = search;
    }

}
