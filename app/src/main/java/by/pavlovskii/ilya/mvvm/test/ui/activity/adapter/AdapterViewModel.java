package by.pavlovskii.ilya.mvvm.test.ui.activity.adapter;

import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import by.mvvmwrapper.viewmodel.SimpleViewModelImpl;
import by.pavlovskii.ilya.mvvm.test.databinding.ActivityAdapterBinding;
import by.pavlovskii.ilya.mvvm.test.utils.factory.ColorsFactory;
import io.reactivex.Completable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

import javax.inject.Inject;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 12.05.2018<br>
 * Time: 20:33<br>
 * Project name: MVVMtest<br>
 * ===================================================================================<br>
 */
public class AdapterViewModel extends SimpleViewModelImpl<AdapterViewData> {

    @NonNull
    private final ColorsFactory mColorsFactory;

    @Inject
    public AdapterViewModel(@NonNull AdapterViewData viewData,
                            @NonNull ColorsFactory colorsFactory) {
        super(viewData);
        mColorsFactory = colorsFactory;
    }

    @Override
    public void bindViewData(@NonNull ViewDataBinding viewDataBinding) {
        ((ActivityAdapterBinding) viewDataBinding).setModel(mViewData);
    }

    public Completable initList() {
        return mColorsFactory.getColors()
                .doOnSuccess(list -> mViewData.setColors(list))
                .toCompletable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
