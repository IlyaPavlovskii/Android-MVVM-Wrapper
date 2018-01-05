package by.pavlovskii.ilya.mvvm.test;

import org.junit.Before;
import org.junit.Test;

import by.pavlovskii.ilya.mvvm.test.utils.DemoActivityFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 02.01.2018<br>
 * Time: 15:24<br>
 * Project name: MVVMtest<br>
 * ===================================================================================<br>
 */
public class DemoActivityFactoryTest {

    private DemoActivityFactory mDemoActivityFactory;

    @Before
    public void setup() {
        mDemoActivityFactory = new DemoActivityFactory();
    }

    @Test
    public void testGenerateDemoActivities() {
        mDemoActivityFactory.generateDemoActivities()
                .subscribe(list -> {
                    assertTrue(list.size() > 0);
                    assertEquals(3, list.size());
                });
    }
}
