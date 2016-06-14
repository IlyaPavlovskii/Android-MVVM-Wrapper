package by.mvvmwrapper.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.text.TextUtils;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 15.06.16<br>
 * Time: 1:06<br>
 * Project name: MVVMtest<br>
 * ===================================================================================
 * Helper for work with custom typefaces. Read custom typeface from assets storage or
 * file storage.<br>
 * ===================================================================================
 */
public class TypefaceHelper {

    //======================================================
    //------------------------Fields------------------------
    //======================================================
    private static Map<String, Typeface> sTypefaceBuffer = new HashMap<>();

    //======================================================
    //---------------------Constructors---------------------
    //======================================================
    private TypefaceHelper() {
    }

    //======================================================
    //---------------------Public methods-------------------
    //======================================================

    @Nullable
    public static Typeface getTypefaceFromAssets(@NonNull Context context, @StringRes int stringRes) {
        return getTypefaceFromAssets(context, context.getString(stringRes));
    }

    @Nullable
    public static Typeface getTypefaceFromAssets(@NonNull Context context, @Nullable String typefacePath) {
        Typeface typeface = null;
        if (!TextUtils.isEmpty(typefacePath)) {
            if (sTypefaceBuffer.containsKey(typefacePath)) {
                typeface = sTypefaceBuffer.get(typefacePath);
            } else {
                AssetManager assets = context.getAssets();
                typeface = Typeface.createFromAsset(assets, typefacePath);
                sTypefaceBuffer.put(typefacePath, typeface);
            }
        }
        return typeface;
    }

    @Nullable
    public static Typeface getTypefaceFromFile(@Nullable File typefaceFile) {
        Typeface typeface = null;
        if (typefaceFile != null) {
            if (sTypefaceBuffer.containsKey(typefaceFile.getAbsolutePath())) {
                typeface = sTypefaceBuffer.get(typefaceFile.getAbsolutePath());
            } else {
                typeface = Typeface.createFromFile(typefaceFile.getAbsolutePath());
                sTypefaceBuffer.put(typefaceFile.getAbsolutePath(), typeface);
            }
        }
        return typeface;
    }

    @Nullable
    public static Typeface getTypefaceFromFile(@Nullable String filePath) {
        Typeface typeface = null;
        if (!TextUtils.isEmpty(filePath)) {
            if (sTypefaceBuffer.containsKey(filePath)) {
                typeface = sTypefaceBuffer.get(filePath);
            } else {
                typeface = Typeface.createFromFile(filePath);
                sTypefaceBuffer.put(filePath, typeface);
            }
        }
        return typeface;
    }

    //======================================================
    //-----------------------Listeners----------------------
    //======================================================

    //======================================================
    //---------------------Inner classes--------------------
    //======================================================
}
