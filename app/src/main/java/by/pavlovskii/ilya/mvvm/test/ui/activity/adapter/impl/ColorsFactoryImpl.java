package by.pavlovskii.ilya.mvvm.test.ui.activity.adapter.impl;

import by.pavlovskii.ilya.mvvm.test.utils.factory.ColorsFactory;
import io.reactivex.Observable;
import io.reactivex.Single;

import javax.inject.Inject;
import java.util.List;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 12.05.2018<br>
 * Time: 20:57<br>
 * Project name: MVVMtest<br>
 * ===================================================================================<br>
 */
public class ColorsFactoryImpl implements ColorsFactory {

    @Inject
    public ColorsFactoryImpl() {
    }

    @Override
    public Single<List<String>> getColors() {
        return Observable.fromArray(getColorsArray())
                .toList();
    }

    private String[] getColorsArray() {
        return new String[]{
                "#9400D3",
                "#4B0082",
                "#0000FF",
                "#00FF00",
                "#FFFF00",
                "#FF7F00",
                "#FF0000"
        };
    }


}
