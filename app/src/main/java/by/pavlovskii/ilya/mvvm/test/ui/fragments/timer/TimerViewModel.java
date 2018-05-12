package by.pavlovskii.ilya.mvvm.test.ui.fragments.timer;

import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import by.mvvmwrapper.viewmodel.SimpleViewModelImpl;
import by.pavlovskii.ilya.mvvm.test.databinding.FragmentTimerBinding;
import by.mvvmwrapper.dagger.qualifier.TopLevelDependency;
import by.pavlovskii.ilya.mvvm.test.ui.activity.main.MainViewModel;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import org.joda.time.format.ISODateTimeFormat;
import timber.log.Timber;

import javax.inject.Inject;
import java.util.concurrent.TimeUnit;

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

    @Inject
    public TimerViewModel(@NonNull TimerViewData viewData,
                          @NonNull @TopLevelDependency MainViewModel viewModel) {
        super(viewData);
        mMainViewModel = viewModel;
    }

    @Override
    public void bindViewData(@NonNull ViewDataBinding viewDataBinding) {
        Timber.d("bind%s", hashCode());
        ((FragmentTimerBinding) viewDataBinding).setModel(mViewData);
    }

    public Observable<String> timer() {
        return Observable.interval(1, TimeUnit.SECONDS)
                .map(instant -> ISODateTimeFormat.basicTimeNoMillis().print(instant))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(mViewData::setTime);
    }

    public void updateInfo() {
        mMainViewModel.updateInfo();
    }
}
