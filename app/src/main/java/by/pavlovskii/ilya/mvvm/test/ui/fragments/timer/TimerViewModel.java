package by.pavlovskii.ilya.mvvm.test.ui.fragments.timer;

import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;

import org.joda.time.format.ISODateTimeFormat;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import by.mvvmwrapper.viewmodel.SimpleViewModelImpl;
import by.pavlovskii.ilya.mvvm.test.databinding.FragmentTimerBinding;
import by.pavlovskii.ilya.mvvm.test.ui.activity.main.MainViewModel;
import dagger.Lazy;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 27.11.2017<br>
 * Time: 8:51<br>
 * Project name: MVVMtest<br>
 * ===================================================================================<br>
 * {@link TimerFragment} view model<br>
 * ===================================================================================<br>
 */
public class TimerViewModel extends SimpleViewModelImpl<TimerViewData> {

    private final MainViewModel mMainViewModel;
    private final CompositeDisposable mDisposable = new CompositeDisposable();

    @Inject
    public TimerViewModel(@NonNull TimerViewData viewData, @NonNull Lazy<MainViewModel> lazy) {
        super(viewData);
        mMainViewModel = lazy.get();
        Timber.d("constructor. VM: %s Lazy code: %s", mMainViewModel.hashCode(), lazy.hashCode());
        mDisposable.add(timer());
    }

    @Override
    public void bindViewData(@NonNull ViewDataBinding viewDataBinding) {
        Timber.d("bind%s", hashCode());
        ((FragmentTimerBinding) viewDataBinding).setModel(mViewData);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mDisposable.clear();
    }

    private Disposable timer() {
        return Observable.interval(1, TimeUnit.SECONDS)
                .map(instant -> ISODateTimeFormat.basicTimeNoMillis().print(instant))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(mViewData::setTime, this::handleException);
    }

    public void updateInfo() {
        mMainViewModel.updateInfo();
    }
}
