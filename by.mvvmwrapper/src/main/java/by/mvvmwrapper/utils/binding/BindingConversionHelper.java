package by.mvvmwrapper.utils.binding;

import android.databinding.BindingConversion;
import android.support.annotation.Nullable;
import by.mvvmwrapper.wrapper.BindableGeneric;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 29.01.16<br>
 * Time: 1:03<br>
 * Project name: MVVMtest<br>
 * ===================================================================================
 * Deprecated helper. Use default two way binding expression
 * <p>
 * All {@link BindingConversion} methods to fast conversion {@link BindableGeneric}
 * to target primitive<br>
 * ===================================================================================
 */
@Deprecated
public class BindingConversionHelper {

    //======================================================
    //---------------------Constructors---------------------
    //======================================================
    private BindingConversionHelper() {
    }

    //======================================================
    //--------------------Private methods-------------------
    //======================================================
    @Nullable
    @BindingConversion
    public static String convertToString(@Nullable BindableGeneric<String> bindableString) {
        if (bindableString != null) {
            return bindableString.getValue();
        } else {
            return null;
        }
    }

    @BindingConversion
    public static boolean convertToBoolean(@Nullable BindableGeneric<Boolean> bindableBoolean) {
        if (bindableBoolean != null) {
            return bindableBoolean.getValue();
        } else {
            return false;
        }
    }

    @BindingConversion
    public static int convertToInteger(@Nullable BindableGeneric<Integer> bindableInteger) {
        if (bindableInteger != null) {
            return bindableInteger.getValue();
        } else {
            return 0;
        }
    }

    @Nullable
    @BindingConversion
    public static <T> Set<T> convertToSet(@Nullable BindableGeneric<Set<T>> bindable) {
        if (bindable != null) {
            return bindable.getValue();
        } else {
            return null;
        }
    }

    @Nullable
    @BindingConversion
    public static <K, V> Map<K, V> convertToMap(@Nullable BindableGeneric<Map<K, V>> bindable) {
        if (bindable != null) {
            return bindable.getValue();
        } else {
            return null;
        }
    }

    @Nullable
    @BindingConversion
    public static <T> List<T> convertToList(@Nullable BindableGeneric<List<T>> bindable) {
        if (bindable != null) {
            return bindable.getValue();
        } else {
            return null;
        }
    }

}
