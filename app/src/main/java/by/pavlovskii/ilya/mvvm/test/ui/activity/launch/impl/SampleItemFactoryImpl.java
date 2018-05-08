package by.pavlovskii.ilya.mvvm.test.ui.activity.launch.impl;

import android.app.Activity;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import by.pavlovskii.ilya.mvvm.test.R;
import by.pavlovskii.ilya.mvvm.test.models.SampleItem;
import by.pavlovskii.ilya.mvvm.test.ui.activity.twoway.TwoWayActivity;
import by.pavlovskii.ilya.mvvm.test.utils.factory.SampleItemFactory;
import io.reactivex.Observable;
import io.reactivex.Single;

import javax.inject.Inject;
import java.util.List;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 09.05.2018<br>
 * Time: 1:21<br>
 * Project name: MVVMtest<br>
 * ===================================================================================<br>
 */
public class SampleItemFactoryImpl implements SampleItemFactory {

    @NonNull
    private final Resources mResources;

    @Inject
    public SampleItemFactoryImpl(@NonNull Resources resources) {
        mResources = resources;
    }

    @Override
    public Single<List<SampleItem>> getSampleItems() {
        return Observable.fromArray(buildSampleArray())
                .toList();
    }

    @NonNull
    private SampleItem[] buildSampleArray() {
        return new SampleItem[]{
                makeSample(
                        R.string.sample_title_two_way_binding,
                        R.string.sample_description_two_way_binding,
                        TwoWayActivity.class)
        };
    }

    private SampleItem makeSample(@StringRes int titleRes, @StringRes int descriptionRes,
                                  @NonNull Class<? extends Activity> clazz) {
        return new SampleItem(getString(titleRes), getString(descriptionRes), clazz);
    }

    private String getString(@StringRes int stringRes) {
        return mResources.getString(stringRes);
    }
}
