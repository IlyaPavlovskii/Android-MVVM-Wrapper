package by.pavlovskii.ilya.mvvm.test.utils.binding;

import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
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
 * //TODO Add description<br>
 * ===================================================================================
 */
public class BindingAdapterMethods {

    //======================================================
    //---------------------Constructors---------------------
    //======================================================
    private BindingAdapterMethods() {
    }

    //======================================================
    //---------------------Public methods-------------------
    //======================================================
    @BindingAdapter({"attr:imageUrl", "attr:error"})
    public static void loadImage(ImageView imageView, String url, Drawable error) {
        DisplayImageOptions dio = new DisplayImageOptions.Builder()
                .showImageOnFail(error)
                .build();
        ImageLoader.getInstance().displayImage(url, imageView, dio);
    }

    @BindingAdapter({"attr:binding"})
    public static void bindEditText(EditText view,
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

    @BindingAdapter({"attr:binding"})
    public static void bindEditText(BindableEditText view,
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

    @BindingAdapter({"attr:binding"})
    public static void bindCompoundButton(CompoundButton checkBox,
                                          final BindableGeneric<Boolean> bindableBoolean) {
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
