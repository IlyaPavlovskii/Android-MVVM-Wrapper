package by.mvvmwrapper.exceptions;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 11.11.2017<br>
 * Time: 16:26<br>
 * Project name: MVVMtest<br>
 * ===================================================================================<br>
 * Exception handler deque chain processor. Handler uses deque and list all items in the deque
 * to find correct handler processor<br>
 * ===================================================================================<br>
 */
public class ExceptionHandlerChain implements ExceptionHandler {
    private static final String TAG = ExceptionHandlerChain.class.getSimpleName();

    @NonNull
    private Deque<ExceptionHandler> mHandlers;

    public ExceptionHandlerChain() {
        this.mHandlers = new LinkedList<>();
    }

    public void addHandler(@NonNull ExceptionHandler handler) {
        mHandlers.addLast(handler);
    }

    public void addHandlers(@NonNull ExceptionHandler... handlers) {
        addHandlers(Arrays.asList(handlers));
    }

    public void addHandlers(@NonNull List<? extends ExceptionHandler> handlers) {
        for (ExceptionHandler handler : handlers) {
            mHandlers.addLast(handler);
        }
    }

    public void removeHandler(@NonNull ExceptionHandler handler) {
        mHandlers.remove(handler);
    }

    public void removeHandlers(@NonNull ExceptionHandler... handlers) {
        addHandlers(Arrays.asList(handlers));
    }

    public void removeHandlers(@NonNull List<? extends ExceptionHandler> handlers) {
        for (ExceptionHandler handler : handlers) {
            mHandlers.remove(handler);
        }
    }

    @Override
    public boolean handleException(@Nullable Throwable throwable) {
        boolean handled = false;
        for (Iterator<ExceptionHandler> iter = mHandlers.descendingIterator(); iter.hasNext() && !handled; ) {
            ExceptionHandler handler = iter.next();
            if (handler != null) {
                handled = handler.handleException(throwable);
            } else {
                Log.d(TAG, "handleException: handler is null");
            }
        }
        return handled;
    }
}
