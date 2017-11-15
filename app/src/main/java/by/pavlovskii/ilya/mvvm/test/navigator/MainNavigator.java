package by.pavlovskii.ilya.mvvm.test.navigator;

import android.support.annotation.Nullable;

import by.pavlovskii.ilya.mvvm.test.activity.MainActivity;
import by.pavlovskii.ilya.mvvm.test.storage.Constants;
import ru.terrakok.cicerone.android.container.ActivityContainerImpl;
import ru.terrakok.cicerone.android.container.IActivityContainer;
import ru.terrakok.cicerone.android.container.ISupportFragmentContainer;
import ru.terrakok.cicerone.android.navigator.FragmentActivityNavigatorImpl;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 15.11.2017<br>
 * Time: 11:23<br>
 * Project name: MVVMtest<br>
 * ===================================================================================<br>
 */
public class MainNavigator extends FragmentActivityNavigatorImpl {
    @Nullable
    @Override
    protected ISupportFragmentContainer getSupportFragmentContainer(String screenKey, Object... transitionData) {
        return null;
    }

    @Nullable
    @Override
    protected IActivityContainer getActivityContainer(String commandKey, Object... transitionData) {
        switch (commandKey) {
            case Constants.ActivityKeys.MAIN:
                return ActivityContainerImpl.create(getActivity(), MainActivity.class);
        }
        return null;
    }
}
