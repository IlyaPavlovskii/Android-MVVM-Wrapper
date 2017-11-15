package by.pavlovskii.ilya.mvvm.test.storage;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 15.11.2017<br>
 * Time: 10:44<br>
 * Project name: MVVMtest<br>
 * ===================================================================================<br>
 * Application constant values<br>
 * ===================================================================================<br>
 */
public class Constants {

    public static class ActivityKeys extends ru.terrakok.cicerone.Constants.ActivityKeys {
        public static final String TWO_WAY_BINDING = PREFIX + "two_way_binding";
        public static final String MAIN = PREFIX + "main";
    }

    public static class FragmentKeys extends ru.terrakok.cicerone.Constants.FragmentKeys {

    }

    public static class Command {
        public static final String NAVIGATE_TO = "navigate_to";
        public static final String NEW_ROOT_SCREEN = "new_root_screen";
        public static final String REPLACE = "replace";
        public static final String SHOW_SYSTEM_MESSAGE = "show_system_message";
        public static final String EXIT = "exit";
    }
}
