package by.pavlovskii.ilya.mvvm.test.ui.activity.main;

import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;

import org.joda.time.format.ISODateTimeFormat;

import by.mvvmwrapper.viewmodel.SimpleViewModelImpl;
import by.pavlovskii.ilya.mvvm.test.databinding.ActivityMainBinding;
import by.pavlovskii.ilya.mvvm.test.models.DemoActivity;
import by.pavlovskii.ilya.mvvm.test.storage.Constants;
import by.pavlovskii.ilya.mvvm.test.utils.DemoActivityFactory;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

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

    private DemoActivityFactory mDemoActivityFactory;

    @Nullable
    private ObservableEmitter<DemoActivity> mNavigateToEmitter;

    public MainViewModel(@NonNull MainViewData viewData, @NonNull DemoActivityFactory demoActivityFactory) {
        super(viewData);
        Log.d(TAG, "constructor");
        mDemoActivityFactory = demoActivityFactory;
    }

    @Override
    public void bindViewData(@NonNull ViewDataBinding viewDataBinding) {
        Log.d(TAG, "bind: " + hashCode());
        ((ActivityMainBinding) viewDataBinding).setModel(mViewData);
        ((ActivityMainBinding) viewDataBinding).setDemoAdapterListener(this::doNavigation);
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDemoList();
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

    private void initDemoList() {
        mDemoActivityFactory.generateDemoActities()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(list -> {
                    mViewData.demoList.clear();
                    mViewData.demoList.addAll(list);
                }, this::handleException);
    }

}
