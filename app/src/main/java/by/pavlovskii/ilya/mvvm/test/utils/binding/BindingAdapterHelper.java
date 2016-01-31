package by.pavlovskii.ilya.mvvm.test.utils.binding;

import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.util.Pair;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import by.pavlovskii.ilya.mvvm.test.wrapper.BindableGeneric;
import by.pavlovskii.ilya.mvvm.test.utils.TextWatcherAdapter;
import by.pavlovskii.ilya.mvvm.test.view.BindableEditText;

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
public class BindingAdapterHelper {

    //======================================================
    //---------------------Constructors---------------------
    //======================================================

    /**
     * Implement base helper realization constructor
     */
    private BindingAdapterHelper() {
    }

    //======================================================
    //---------------------Public methods-------------------
    //======================================================

    /**
     * Load image from URL address to target {@see ImageView} component
     *
     * @param imageView target {@link ImageView} component
     * @param url       image URL address
     * @param error     error {@link Drawable}, used when something is wrong to loading by current
     *                  URL address
     */
    @BindingAdapter({"attr:imageUrl", "attr:errorImage"})
    public static void loadImage(@NonNull ImageView imageView, @Nullable String url,
                                 @Nullable Drawable error) {
        DisplayImageOptions dio = new DisplayImageOptions.Builder()
                .showImageOnFail(error)
                .build();
        ImageLoader.getInstance().displayImage(url, imageView, dio);
    }

    /**
     * Load image from URL address to target {@see ImageView } component
     *
     * @param imageView target {@link ImageView} component
     * @param url       image URL address
     */
    @BindingAdapter({"attr:imageUrl"})
    public static void loadImage(@NonNull ImageView imageView, @Nullable String url) {
        ImageLoader.getInstance().displayImage(url, imageView);
    }

    /**
     * Fill text and tracking changes on target {@see EditText} component
     * !WARNING!
     * Current method have some problems with subscribe multiply {@see EditText} components to one
     * bindable argument. To avoid this problems use {@link BindableEditText}.
     *
     * @param view target {@link BindableEditText} component
     * @param bindableString target text*/
    @BindingAdapter({"attr:binding"})
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
     * @param view target {@link BindableEditText} component
     * @param bindableString target text*/
    @BindingAdapter({"attr:binding"})
    public static void bindEditText(@NonNull BindableEditText view,
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
                    view.acquire();
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
     * @param checkBox target {@link CompoundButton} component
     * @param bindableBoolean observable checked/unchecked state data*/
    @BindingAdapter({"attr:binding"})
    public static void bindCompoundButton(@NonNull CompoundButton checkBox,
                                          @Nullable BindableGeneric<Boolean> bindableBoolean) {
        if (bindableBoolean == null) {
            return;
        }
        CompoundButton.OnCheckedChangeListener listener = (buttonView, isChecked) -> {
            if (isChecked != bindableBoolean.getValue()) {
                bindableBoolean.set(isChecked);
            }
        };
        checkBox.setOnCheckedChangeListener(listener);
    }

    /**
     * Set progress state value and tracking changes on {@see SeekBar} component
     *
     * @param seekBar target {@link SeekBar} component
     * @param bindableInteger observable progress state value*/
    @BindingAdapter({"attr:binding"})
    public static void bindProgressBar(SeekBar seekBar,
                                       final BindableGeneric<Integer> bindableInteger) {
        if (bindableInteger == null) {
            return;
        }
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (progress != bindableInteger.getValue()) {
                    bindableInteger.set(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
