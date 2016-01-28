package by.pavlovskii.ilya.mvvm.test.activity;

import android.databinding.BindingAdapter;
import android.databinding.BindingConversion;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SeekBar;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import butterknife.ButterKnife;
import by.pavlovskii.ilya.mvvm.test.models.wrapper.BindableGeneric;
import by.pavlovskii.ilya.mvvm.test.utils.TextWatcherAdapter;
import by.pavlovskii.ilya.mvvm.test.view.BindableEditText;
import by.pavlovskii.ilya.mvvm.test.viewmodel.IViewModel;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 06.01.16<br>
 * Time: 19:53<br>
 * Project name: MVVMtest<br>
 * ===================================================================================
 * //TODO Add description<br>
 * ===================================================================================
 */
public abstract class BaseActivity<T extends IViewModel> extends AppCompatActivity {

    //======================================================
    //----------------------Constants-----------------------
    //======================================================
    public final String TAG = getClass().getSimpleName();

    //======================================================
    //------------------------Fields------------------------
    //======================================================
    protected ViewDataBinding mBinding;
    protected T mViewModel;

    //======================================================
    //-------------------Override methods-------------------
    //======================================================

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, getLayoutRes());
        ButterKnife.bind(this);

        mViewModel = getViewModel();
        mViewModel.initModel();
        mViewModel.bindData(this, mBinding);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
        mBinding.unbind();
        mViewModel.destroy();
        mViewModel = null;
    }

    //======================================================
    //-------------------Abstract methods-------------------
    //======================================================
    @LayoutRes
    protected abstract int getLayoutRes();
    @NonNull
    protected abstract T getViewModel();


    //======================================================
    //------------------Binding conversions-----------------
    //======================================================
    @BindingConversion
    public static String convertBindableToString(@Nullable BindableGeneric<String> bindableString) {
        if( bindableString != null){
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

    //======================================================
    //--------------------Binding adapters------------------
    //======================================================
    @BindingAdapter({"attr:imageUrl","attr:error"})
    public static void loadImage(ImageView imageView, String url, Drawable error){
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
    public static void bindCompoundButton(CompoundButton checkBox, final BindableGeneric<Boolean> bindableBoolean) {
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
    public static void bindProgressBar(SeekBar seekBar, final BindableGeneric<Integer> bindableInteger) {
        if (bindableInteger == null) {
            return;
        }
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (progress != bindableInteger.getValue()) {
                    bindableInteger.setValue(progress);
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
