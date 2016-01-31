package by.pavlovskii.ilya.mvvm.test.utils;

import android.databinding.BindingConversion;
import android.support.annotation.Nullable;

import java.util.List;

import by.mvvmwrapper.wrapper.BindableGeneric;
import by.pavlovskii.ilya.mvvm.test.bindingmodels.ProfileViewData;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 01.02.16<br>
 * Time: 2:02<br>
 * Project name: MVVMtest<br>
 */
public class BindingConversionHelper {

    //======================================================
    //---------------------Constructors---------------------
    //======================================================
    private BindingConversionHelper() {
    }

    //======================================================
    //---------------------Public methods-------------------
    //======================================================
    @BindingConversion
    public static List<ProfileViewData> convertBindableToProfileViewDataList(
            @Nullable BindableGeneric<List<ProfileViewData>> bindableList) {
        if (bindableList != null) {
            return bindableList.getValue();
        } else {
            return null;
        }
    }
//
//    @BindingConversion
//    public static String convertBindableToString(@Nullable BindableGeneric<String> bindableString) {
//        if (bindableString != null) {
//            return bindableString.getValue();
//        } else {
//            return null;
//        }
//    }
//
//    @BindingConversion
//    public static boolean convertBindableToBoolean(@Nullable BindableGeneric<Boolean> bindableBoolean) {
//        if (bindableBoolean != null) {
//            return bindableBoolean.getValue();
//        } else {
//            return false;
//        }
//    }
//
//    @BindingConversion
//    public static int convertBindableToInteger(@Nullable BindableGeneric<Integer> bindableInteger) {
//        if (bindableInteger != null) {
//            return bindableInteger.getValue();
//        } else {
//            return 0;
//        }
//    }
}
