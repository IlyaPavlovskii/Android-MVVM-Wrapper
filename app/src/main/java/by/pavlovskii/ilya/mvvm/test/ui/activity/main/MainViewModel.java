package by.pavlovskii.ilya.mvvm.test.ui.activity.main;

import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import by.mvvmwrapper.viewmodel.SimpleViewModelImpl;
import by.pavlovskii.ilya.mvvm.test.databinding.ActivityMainBinding;
import by.pavlovskii.ilya.mvvm.test.models.DemoActivity;
import by.pavlovskii.ilya.mvvm.test.storage.Constants;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
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

    @Nullable
    private ObservableEmitter<DemoActivity> mNavigateToEmitter;

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
    public Observable<DemoActivity> navigateToScreen() {
        return Observable.create(e -> mNavigateToEmitter = e);
    }

    public void updateInfo() {
        long time = System.currentTimeMillis();
        mViewData.info.set("Info updated at: " + ISODateTimeFormat
                .basicTime()
                .print(time));
    }


    // ===================================================================================
    // ------------------------------- Private methods -----------------------------------
    // ===================================================================================
    private void doNavigation(@NonNull DemoActivity item) {
        if (mNavigateToEmitter != null) {
            if (TextUtils.equals(Constants.Command.THROW_EXCEPTION, item.getCommand())) {
                mNavigateToEmitter.onError(new RuntimeException("Synthetic exception"));
            } else {
                mNavigateToEmitter.onNext(item);
            }
        }
    }

}
