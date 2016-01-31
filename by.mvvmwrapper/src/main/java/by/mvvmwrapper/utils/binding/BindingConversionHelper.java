package by.mvvmwrapper.utils.binding;

import android.databinding.BindingConversion;
import android.support.annotation.Nullable;

import by.mvvmwrapper.wrapper.BindableGeneric;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 29.01.16<br>
 * Time: 1:03<br>
 * Project name: MVVMtest<br>
 * ===================================================================================
 * All {@link BindingConversion} methods to fast conversion {@link BindableGeneric}
 * to target primitive<br>
 * ===================================================================================
 */
public class BindingConversionHelper {

    //======================================================
    //---------------------Constructors---------------------
    //======================================================

    /**
     * Implement base helper realization constructor
     */
    private BindingConversionHelper() {
    }

    //======================================================
    //--------------------Private methods-------------------
    //======================================================
    @BindingConversion
    public static String convertBindableToString(@Nullable BindableGeneric<String> bindableString) {
        if (bindableString != null) {
            return bindableString.getValue();
        } else {
            return null;
        }
    }

    @BindingConversion
    public static boolean convertBindableToBoolean(@Nullable BindableGeneric<Boolean> bindableBoolean) {
        if (bindableBoolean != null) {
            return bindableBoolean.getValue();
        } else {
            return false;
        }
    }

    @BindingConversion
    public static int convertBindableToInteger(@Nullable BindableGeneric<Integer> bindableInteger) {
        if (bindableInteger != null) {
            return bindableInteger.getValue();
        } else {
            return 0;
        }
    }

}
