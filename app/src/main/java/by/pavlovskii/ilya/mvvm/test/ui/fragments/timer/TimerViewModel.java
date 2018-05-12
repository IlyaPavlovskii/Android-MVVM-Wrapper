package by.pavlovskii.ilya.mvvm.test.ui.fragments.timer;

import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import by.mvvmwrapper.dagger.qualifier.TopLevelDependency;
import by.mvvmwrapper.viewmodel.SimpleViewModelImpl;
import by.pavlovskii.ilya.mvvm.test.databinding.FragmentTimerBinding;
import by.pavlovskii.ilya.mvvm.test.storage.Constants;
import by.pavlovskii.ilya.mvvm.test.ui.activity.main.MainViewModel;
import io.reactivex.Observable;
import org.joda.time.format.ISODateTimeFormat;

import javax.inject.Inject;
import javax.inject.Named;

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

    @NonNull
    private final String mTag;
    @NonNull
    private final MainViewModel mMainViewModel;

    @Inject
    public TimerViewModel(@NonNull TimerViewData viewData,
                          @NonNull @Named(Constants.Dagger.TAG) String tag,
                          @NonNull @TopLevelDependency MainViewModel viewModel) {
        super(viewData);
        this.mTag = tag;
        this.mMainViewModel = viewModel;
    }

    @Override
    public void bindViewData(@NonNull ViewDataBinding viewDataBinding) {
        ((FragmentTimerBinding) viewDataBinding).setModel(mViewData);
    }

    public void updateInfo() {
        mMainViewModel.setCurrentTag(mTag);
        long time = mMainViewModel.updateInfo();
        mViewData.setTime(ISODateTimeFormat
                .hourMinuteSecond()
                .print(time));
    }

    public Observable<String> subscribeTagChanges() {
        return mMainViewModel.getSelectTagObs()
                .doOnNext(tag -> mViewData.setSelected(TextUtils.equals(mTag, tag)));
    }

}
