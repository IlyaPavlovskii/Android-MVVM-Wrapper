package by.pavlovskii.ilya.mvvm.test.models;

import android.app.Activity;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 09.05.2018<br>
 * Time: 1:12<br>
 * Project name: MVVMtest<br>
 * ===================================================================================<br>
 */
public class SampleItem {

    private final String mTitle;
    private final String mDescription;
    private final Class<? extends Activity> mActivityClass;

    public SampleItem(String mTitle, String mDescription, Class<? extends Activity> mActivityClass) {
        this.mTitle = mTitle;
        this.mDescription = mDescription;
        this.mActivityClass = mActivityClass;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getDescription() {
        return mDescription;
    }

    public Class<? extends Activity> getActivityClass() {
        return mActivityClass;
    }
}
