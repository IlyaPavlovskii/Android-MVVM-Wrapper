package by.pavlovskii.ilya.mvvm.test.viewmodel;

import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;

import org.joda.time.format.ISODateTimeFormat;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import by.mvvmwrapper.viewmodel.SimpleViewModelImpl;
import by.pavlovskii.ilya.mvvm.test.databinding.FragmentTimerBinding;
import by.pavlovskii.ilya.mvvm.test.viewdata.TimerViewData;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 27.11.2017<br>
 * Time: 8:51<br>
 * Project name: MVVMtest<br>
 * ===================================================================================<br>
 * {@link by.pavlovskii.ilya.mvvm.test.fragments.TimerFragment} view model<br>
 * ===================================================================================<br>
 */
public class TimerViewModel extends SimpleViewModelImpl<TimerViewData> {

    private final CompositeDisposable mDisposable = new CompositeDisposable();

    @Inject
    public TimerViewModel(@NonNull TimerViewData viewData) {
        super(viewData);
        mDisposable.add(timer());
    }

    @Override
    public void bindViewData(@NonNull ViewDataBinding viewDataBinding) {
        ((FragmentTimerBinding) viewDataBinding).setModel(mViewData);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mDisposable.clear();
        mViewData.destroy();
    }

    private Disposable timer() {
        return Observable.interval(1, TimeUnit.SECONDS)
                .map(instant -> ISODateTimeFormat.basicTimeNoMillis().print(instant))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(text -> mViewData.time.set(text), this::handleException);
    }
}
