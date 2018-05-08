package by.pavlovskii.ilya.mvvm.test.navigator;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import by.pavlovskii.ilya.mvvm.test.R;
import by.pavlovskii.ilya.mvvm.test.storage.Constants;
import by.pavlovskii.ilya.mvvm.test.ui.activity.main.MainActivity;
import by.pavlovskii.ilya.mvvm.test.ui.activity.yellow.YellowActivity;
import by.pavlovskii.ilya.mvvm.test.ui.fragments.timer.TimerFragment;
import ru.terrakok.cicerone.android.container.ActivityContainerImpl;
import ru.terrakok.cicerone.android.container.IActivityContainer;
import ru.terrakok.cicerone.android.container.ISupportFragmentContainer;
import ru.terrakok.cicerone.android.container.SupportFragmentContainerImpl;
import ru.terrakok.cicerone.android.navigator.FragmentActivityNavigatorImpl;
import ru.terrakok.cicerone.commands.Replace;

import javax.inject.Inject;
import javax.inject.Singleton;

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
@Singleton
public class MainNavigator extends FragmentActivityNavigatorImpl {

    @Inject
    public MainNavigator() {
    }

    @Nullable
    @Override
    protected ISupportFragmentContainer getSupportFragmentContainer(String screenKey, Object... transitionData) {
        if (Constants.FragmentKeys.TIMER.equals(screenKey)) {
            if (isEmptyData(transitionData)) {
                return SupportFragmentContainerImpl.create(R.id.vFlContainer, TimerFragment.newInstance());
            } else {
                return SupportFragmentContainerImpl.create(R.id.vFlContainer1, TimerFragment.newInstance());
            }
        }
        return null;
    }

    @Nullable
    @Override
    protected IActivityContainer getActivityContainer(String commandKey, Object... transitionData) {
        if (Constants.ActivityKeys.MAIN.equals(commandKey)) {
            return ActivityContainerImpl.create(getActivity(), MainActivity.class);
        } else if (Constants.ActivityKeys.YELLOW.equals(commandKey)) {
            return ActivityContainerImpl.create(getActivity(), YellowActivity.class);
        }
        return null;
    }

    @Override
    protected void replace(@NonNull Replace command) {
        super.replace(command);
    }
}
