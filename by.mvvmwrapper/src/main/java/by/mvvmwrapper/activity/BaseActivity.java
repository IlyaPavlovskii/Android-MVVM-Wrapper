package by.mvvmwrapper.activity;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import java.lang.ref.WeakReference;

import butterknife.ButterKnife;
import by.mvvmwrapper.viewmodel.IViewModel;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 06.01.16<br>
 * Time: 19:53<br>
 * Project name: MVVMtest<br>
 * ===================================================================================
 * //TODO Add description<br>
 * ===================================================================================
 */
public abstract class BaseActivity<TViewModel extends IViewModel> extends AppCompatActivity {

    //======================================================
    //----------------------Constants-----------------------
    //======================================================
    public final String TAG = getClass().getSimpleName();

    //======================================================
    //------------------------Fields------------------------
    //======================================================
    protected ViewDataBinding mBinding;
    protected TViewModel mViewModel;

    private Messenger mSenderMessenger;
    private Messenger mReceiverMessenger;

    //======================================================
    //-------------------Override methods-------------------
    //======================================================

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, getLayoutRes());
        ButterKnife.bind(this);

        mViewModel = getViewModel();
        mViewModel.initViewData();
        mViewModel.bindViewData(this, mBinding);

        mSenderMessenger = new Messenger(mViewModel.getReceiverBinder());
        mReceiverMessenger = new Messenger(new IncomingHandler(this));

        mViewModel.setSenderBinder(mReceiverMessenger.getBinder());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
        mBinding.unbind();
        mViewModel.destroy();
        mViewModel = null;

        mSenderMessenger = null;
        mReceiverMessenger = null;
    }

    //======================================================
    //-------------------Protected methods------------------
    //======================================================
    protected void sendCommand(Message message) throws RemoteException {
        if (mSenderMessenger != null) {
            mSenderMessenger.send(message);
        }
    }

    //======================================================
    //-------------------Abstract methods-------------------
    //======================================================
    @LayoutRes
    protected abstract int getLayoutRes();
    @NonNull
    protected abstract TViewModel getViewModel();

    protected abstract void handleMessage(Message msg);

    //======================================================
    //--------------------Inner classes---------------------
    //======================================================
    private static class IncomingHandler extends Handler {

        private WeakReference<BaseActivity> mWeakReference;

        private IncomingHandler(@NonNull BaseActivity activity) {
            mWeakReference = new WeakReference<>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            BaseActivity activity = mWeakReference.get();

            if (msg != null && activity != null && !activity.isFinishing()) {
                activity.handleMessage(msg);
            }
        }
    }
}
