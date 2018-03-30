package by.pavlovskii.ilya.mvvm.test.di.modules;

import javax.inject.Singleton;

import by.pavlovskii.ilya.mvvm.test.utils.DemoActivityFactory;
import dagger.Module;
import dagger.Provides;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 15.11.2017<br>
 * Time: 10:52<br>
 * Project name: MVVMtest<br>
 * ===================================================================================<br>
 * Factory helpers module<br>
 * ===================================================================================<br>
 */
@Module
public class FactoryModule {

    @Provides
    @Singleton
    public DemoActivityFactory provideDemoActivityFactory() {
        return new DemoActivityFactory();
    }
}
