package by.pavlovskii.ilya.mvvm.test.models;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 15.11.2017<br>
 * Time: 10:47<br>
 * Project name: MVVMtest<br>
 * ===================================================================================<br>
 * Demo activity keys entity. Contains work key for {@link ru.terrakok.cicerone.Router} and
 * screen command<br>
 * ===================================================================================<br>
 */
public class DemoActivity {

    @NonNull
    private final String mCommand;
    @Nullable
    private final String mScreen;

    public static DemoActivity create(@NonNull String command, @Nullable String screen) {
        return new DemoActivity(command, screen);
    }

    public DemoActivity(@NonNull String command, @Nullable String screen) {
        mCommand = command;
        mScreen = screen;
    }

    @NonNull
    public String getCommand() {
        return mCommand;
    }

    @Nullable
    public String getScreen() {
        return mScreen;
    }
}
