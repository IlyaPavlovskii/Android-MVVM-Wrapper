package by.pavlovskii.ilya.mvvm.test.ui.activity.launch;

import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import by.mvvmwrapper.viewmodel.SimpleViewModelImpl;
import by.pavlovskii.ilya.mvvm.test.databinding.ActivityLaunchBinding;
import by.pavlovskii.ilya.mvvm.test.utils.factory.SampleItemFactory;
import io.reactivex.Completable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

import javax.inject.Inject;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 04.05.2018<br>
 * Time: 2:12<br>
 * Project name: MVVMtest<br>
 * ===================================================================================<br>
 */
public class LaunchViewModel extends SimpleViewModelImpl<LaunchViewData> {

    @NonNull
    private final SampleItemFactory mSampleItemFactory;

    @Inject
    public LaunchViewModel(@NonNull LaunchViewData viewData,
                           @NonNull SampleItemFactory sampleItemFactory) {
        super(viewData);
        mSampleItemFactory = sampleItemFactory;
    }

    @Override
    public void bindViewData(@NonNull ViewDataBinding viewDataBinding) {
        ((ActivityLaunchBinding) viewDataBinding).setModel(mViewData);
    }

    public Completable initList() {
        return mSampleItemFactory.getSampleItems()
                .doOnSuccess(mViewData::setSampleItems)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .toCompletable();
    }
}
