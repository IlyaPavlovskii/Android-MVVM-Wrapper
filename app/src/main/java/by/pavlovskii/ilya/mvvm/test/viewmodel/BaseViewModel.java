package by.pavlovskii.ilya.mvvm.test.viewmodel;

import android.databinding.ViewDataBinding;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.annotation.NonNull;

import java.lang.ref.WeakReference;

import by.pavlovskii.ilya.mvvm.test.bindmodels.IViewData;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 31.01.16<br>
 * Time: 19:03<br>
 * Project name: MVVMtest<br>
 * ===================================================================================
 * Base {@link IViewModel} realization with communication between
 * {@link by.pavlovskii.ilya.mvvm.test.activity.BaseActivity} and {@link IViewModel}.
 * Contains required fields like - {@link IViewData} and {@link ViewDataBinding}<br>
 * ===================================================================================
 */
public abstract class BaseViewModel<TViewData extends IViewData, TViewDataBinding extends ViewDataBinding>
        implements IViewModel<TViewData, TViewDataBinding> {

    //======================================================
    //----------------------Constants-----------------------
    //======================================================
    public final String TAG = getClass().getSimpleName();

    //======================================================
    //------------------------Fields------------------------
    //======================================================
    private Messenger mSenderMessenger;
    private Messenger mReceiverMessenger;
    private Handler mHandler;

    //======================================================
    //---------------------Constructors---------------------
    //======================================================
    public BaseViewModel() {
        mHandler = new IncomingHandler(this);
        mReceiverMessenger = new Messenger(mHandler);
    }

    //======================================================
    //-------------------Override methods-------------------
    //======================================================
    @NonNull
    @Override
    public IBinder getReceiverBinder() {
        return mReceiverMessenger.getBinder();
    }

    @Override
    public void setSenderBinder(@NonNull IBinder binder) {
        mSenderMessenger = new Messenger(binder);
    }

    //======================================================
    //-------------------Protected methods------------------
    //======================================================

    /**
     * Send command into activity or another subscriber
     *
     * @param message command to subscriber
     */
    protected void sendCommand(Message message) throws RemoteException {
        if (mSenderMessenger != null) {
            mSenderMessenger.send(message);
        }
    }

    //======================================================
    //-------------------Abstract methods-------------------
    //======================================================

    /**
     * Handle message from activity or another component who sent this message
     *
     * @param message command message*/
    public abstract void handleMessage(Message message);

    //======================================================
    //--------------------Inner classes---------------------
    //======================================================
    private static class IncomingHandler extends Handler {

        private WeakReference<BaseViewModel> mWeakReference;

        private IncomingHandler(@NonNull BaseViewModel viewModel) {
            mWeakReference = new WeakReference<>(viewModel);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            BaseViewModel viewModel = mWeakReference.get();

            if (msg != null && viewModel != null) {
                viewModel.handleMessage(msg);
            }
        }
    }
}
