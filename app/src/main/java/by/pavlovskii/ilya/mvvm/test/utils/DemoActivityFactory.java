package by.pavlovskii.ilya.mvvm.test.utils;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import by.pavlovskii.ilya.mvvm.test.models.DemoActivity;
import by.pavlovskii.ilya.mvvm.test.storage.Constants;
import io.reactivex.Single;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 15.11.2017<br>
 * Time: 10:51<br>
 * Project name: MVVMtest<br>
 * ===================================================================================<br>
 * {@link by.pavlovskii.ilya.mvvm.test.models.DemoActivity} models creator<br>
 * ===================================================================================<br>
 */
public class DemoActivityFactory {

    @Inject
    public DemoActivityFactory() {
    }

    public Single<List<DemoActivity>> generateDemoActities() {
        return Single.just(new ArrayList<DemoActivity>())
                .doOnSuccess(list -> {
                    list.add(DemoActivity.create(Constants.Command.NEW_ROOT_SCREEN, Constants.ActivityKeys.MAIN));
                    list.add(DemoActivity.create(Constants.Command.REPLACE, Constants.ActivityKeys.MAIN));
                    list.add(DemoActivity.create(Constants.Command.SHOW_SYSTEM_MESSAGE, Constants.ActivityKeys.MAIN));
                    list.add(DemoActivity.create(Constants.Command.NAVIGATE_TO, Constants.ActivityKeys.MAIN));
                    list.add(DemoActivity.create(Constants.Command.EXIT, null));
                    list.add(DemoActivity.create(Constants.Command.THROW_EXCEPTION, null));
                })
                .map(list -> list);
    }
}
