package by.mvvmwrapper.utils.binding;

import android.databinding.BindingAdapter;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.util.Log;
import android.util.Pair;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import by.mvvmwrapper.utils.SeekBarChangeAdapter;
import by.mvvmwrapper.utils.TextWatcherAdapter;
import by.mvvmwrapper.utils.TypefaceHelper;
import by.mvvmwrapper.widget.BindableEditText;
import by.mvvmwrapper.wrapper.BindableGeneric;

import java.io.File;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 29.01.16<br>
 * Time: 1:06<br>
 * Project name: MVVMtest<br>
 * ===================================================================================
 * All {@link BindingAdapter} methods used in base pack methods<br>
 * ===================================================================================
 */
public class RootBindingAdapter {

    private static final String ATTR_TAG = "attr";

    /**
     * Implement base helper realization constructor
     */
    private RootBindingAdapter() {
    }

    /**
     * Fill text and tracking changes on target {@see EditText} component
     * !ATTENTION!
     * Current method have some problems with subscribe multiply {@see EditText} components to one
     * bindable argument. To avoid this problems use {@link BindableEditText}.
     *
     * @param view           target {@link BindableEditText} component
     * @param bindableString target text
     */
    @Deprecated
    @BindingAdapter({ATTR_TAG + ":binding"})
    public static void bindEditText(@NonNull EditText view,
                                    @Nullable final BindableGeneric<String> bindableString) {
        if (bindableString == null) {
            return;
        }
        Pair<BindableGeneric, TextWatcherAdapter> pair = (Pair) view.getTag();
        if (pair == null || pair.first != bindableString) {
            if (pair != null) {
                view.removeTextChangedListener(pair.second);
            }
            TextWatcherAdapter watcher = new TextWatcherAdapter() {
                @Override
                public void afterTextChanged(Editable s) {
                    bindableString.setValue(s.toString());
                }
            };
            pair = new Pair<>(bindableString, watcher);
            view.setTag(pair);
            view.addTextChangedListener(watcher);
        }
    }

    /**
     * Fill text and tracking changes on target {@see BindableEditText} component
     *
     * @param view           target {@link BindableEditText} component
     * @param bindableString target text
     */
    @Deprecated
    @BindingAdapter({ATTR_TAG + ":binding"})
    public static void bindBindableEditText(@NonNull BindableEditText view,
                                            @Nullable final BindableGeneric<String> bindableString) {
        if (bindableString == null) {
            return;
        }
        Pair<BindableGeneric, TextWatcherAdapter> pair = (Pair) view.getTag();
        if (pair == null || pair.first != bindableString) {
            if (pair != null) {
                view.removeTextChangedListener(pair.second);
            }
            TextWatcherAdapter watcher = new TextWatcherAdapter() {
                @Override
                public void afterTextChanged(Editable s) {
                    bindableString.set(s.toString());
                }
            };
            pair = new Pair<>(bindableString, watcher);
            view.setTag(pair);
            view.addTextChangedListener(watcher);
        }
    }

    /**
     * Fill checked/unchecked states to {@see CompoundButton} component and tracking changes
     *
     * @param checkBox        target {@link CompoundButton} component
     * @param bindableBoolean observable checked/unchecked state data
     */
    @Deprecated
    @BindingAdapter({ATTR_TAG + ":binding"})
    public static void bindCompoundButton(@NonNull CompoundButton checkBox,
                                          @Nullable BindableGeneric<Boolean> bindableBoolean) {
        if (bindableBoolean == null) {
            return;
        }
        CompoundButton.OnCheckedChangeListener listener = new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked != bindableBoolean.getValue()) {
                    bindableBoolean.set(isChecked);
                }
            }
        };
        checkBox.setOnCheckedChangeListener(listener);
    }

    /**
     * Set progress state value and tracking changes on {@see SeekBar} component
     *
     * @param seekBar  target {@link SeekBar} component
     * @param obsValue observable progress state value
     */
    @Deprecated
    @BindingAdapter({ATTR_TAG + ":binding"})
    public static void bindSeekBar(@NonNull SeekBar seekBar, @Nullable BindableGeneric<Integer> obsValue) {
        if (obsValue != null) {
            seekBar.setOnSeekBarChangeListener(new SeekBarChangeAdapter() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    Log.d("ACTION", "onProgressChanged. Val: " + obsValue.getValue() + " Progres: " + progress);
                    if (progress != obsValue.getValue()) {
                        obsValue.set(progress);
                    }
                }
            });
        }
    }

    @BindingAdapter("bindAssetTypeface")
    public static void bindAssetTypeface(@NonNull TextView textView, @Nullable String assetPath) {
        bindAssetTypefaceAttr(textView, assetPath);
    }

    @BindingAdapter({ATTR_TAG + ":assetTypeface"})
    public static void bindAssetTypefaceAttr(@NonNull TextView textView, @Nullable String assetPath) {
        Typeface typeface = TypefaceHelper.getTypefaceFromAssets(textView.getContext(), assetPath);
        if (typeface != null) {
            textView.setTypeface(typeface);
        }
    }

    @BindingAdapter({"bindFileTypeface"})
    public static void bindFileTypeface(@NonNull TextView textView, @Nullable String filePath) {
        bindFileTypefaceAttr(textView, filePath);
    }

    @BindingAdapter({ATTR_TAG + ":fileTypeface"})
    public static void bindFileTypefaceAttr(@NonNull TextView textView, @Nullable String filePath) {
        Typeface typeface = TypefaceHelper.getTypefaceFromFile(filePath);
        if (typeface != null) {
            textView.setTypeface(typeface);
        }
    }

    @BindingAdapter({"bindFileTypeface"})
    public static void bindFileTypeface(@NonNull TextView textView, @Nullable File typefaceFile) {
        bindFileTypefaceAttr(textView, typefaceFile);
    }

    @BindingAdapter({ATTR_TAG + ":fileTypeface"})
    public static void bindFileTypefaceAttr(@NonNull TextView textView, @Nullable File typefaceFile) {
        Typeface typeface = TypefaceHelper.getTypefaceFromFile(typefaceFile);
        if (typeface != null) {
            textView.setTypeface(typeface);
        }
    }

}
