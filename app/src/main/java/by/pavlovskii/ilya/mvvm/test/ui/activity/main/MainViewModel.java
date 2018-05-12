package by.pavlovskii.ilya.mvvm.test.ui.activity.main;

import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import by.mvvmwrapper.viewmodel.SimpleViewModelImpl;
import by.pavlovskii.ilya.mvvm.test.databinding.ActivityMainBinding;
import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import org.joda.time.format.ISODateTimeFormat;
import timber.log.Timber;

import javax.inject.Inject;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 10.11.2017<br>
 * Time: 17:32<br>
 * Project name: MVVMtest<br>
 * ===================================================================================<br>
 * {@link MainActivity} view model component<br>
 * ===================================================================================<br>
 */
public class MainViewModel extends SimpleViewModelImpl<MainViewData> {

    private final PublishSubject<String> mSelectedTagSubject = PublishSubject.create();

    @Inject
    public MainViewModel(@NonNull MainViewData viewData) {
        super(viewData);
        Timber.d("constructor: %s", hashCode());
    }

    @Override
    public void bindViewData(@NonNull ViewDataBinding viewDataBinding) {
        Timber.d("bind: %s", hashCode());
        ((ActivityMainBinding) viewDataBinding).setModel(mViewData);
    }

    // ===================================================================================
    // -------------------------------- Pubic methods ------------------------------------
    // ===================================================================================
    public long updateInfo() {
        long time = System.currentTimeMillis();
        mViewData.setTime(ISODateTimeFormat
                .timeNoMillis()
                .print(time));
        return time;
    }

    public void setCurrentTag(String tag) {
        mSelectedTagSubject.onNext(tag);
    }

    public Observable<String> getSelectTagObs() {
        return mSelectedTagSubject;
    }
}
