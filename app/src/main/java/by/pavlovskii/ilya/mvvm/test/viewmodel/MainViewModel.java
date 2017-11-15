package by.pavlovskii.ilya.mvvm.test.viewmodel;

import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.NonNull;

import by.mvvmwrapper.viewmodel.SimpleViewModelImpl;
import by.pavlovskii.ilya.mvvm.test.databinding.ActivityMainBinding;
import by.pavlovskii.ilya.mvvm.test.interfaces.MainViewActionCallback;
import by.pavlovskii.ilya.mvvm.test.models.DemoActivity;
import by.pavlovskii.ilya.mvvm.test.storage.Constants;
import by.pavlovskii.ilya.mvvm.test.utils.DemoActivityFactory;
import by.pavlovskii.ilya.mvvm.test.viewdata.MainViewData;
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
 * ===================================================================================
 * {@link by.pavlovskii.ilya.mvvm.test.activity.MainActivity} view model component<br>
 * ===================================================================================
 */
public class MainViewModel extends SimpleViewModelImpl<MainViewData, MainViewActionCallback> {

    DemoActivityFactory mDemoActivityFactory;

    public MainViewModel(@NonNull MainViewData viewData, @NonNull MainViewActionCallback actionCallback) {
        super(viewData, actionCallback);
        mDemoActivityFactory = new DemoActivityFactory();
    }

    @Override
    public void bindViewData(@NonNull ViewDataBinding viewDataBinding) {
        ((ActivityMainBinding) viewDataBinding).setModel(mViewData);
        ((ActivityMainBinding) viewDataBinding).setDemoAdapterListener(this::doNavigation);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initDemoList();
    }

    private void doNavigation(DemoActivity item) {
        switch (item.getCommand()) {
            case Constants.Command.NAVIGATE_TO:
                mActionCallback.navigateTo(item.getScreen());
                break;
            case Constants.Command.REPLACE:
                mActionCallback.replaceScreen(item.getScreen());
                break;
            case Constants.Command.NEW_ROOT_SCREEN:
                mActionCallback.newRootScreen(item.getScreen());
                break;
            case Constants.Command.SHOW_SYSTEM_MESSAGE:
                mActionCallback.showSystemMessage(item.getScreen());
                break;
            case Constants.Command.EXIT:
                mActionCallback.exit();
                break;
        }
    }

    private void initDemoList() {
        mDemoActivityFactory.generateDemoActities()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(list -> {
                    mViewData.demoList.clear();
                    mViewData.demoList.addAll(list);
                }, throwable -> mActionCallback.onFailure(throwable));
    }


}
