package by.pavlovskii.ilya.mvvm.test.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.EditText;

import java.util.concurrent.Semaphore;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 28.01.16<br>
 * Time: 22:57<br>
 * Project name: MVVMtest<br>
 * ===================================================================================
 * //TODO Add description<br>
 * ===================================================================================
 */
public class BindableEditText extends EditText {

    //======================================================
    //----------------------Constants-----------------------
    //======================================================
    private static final String TAG = BindableEditText.class.getSimpleName();

    //======================================================
    //------------------------Fields------------------------
    //======================================================
    private volatile boolean mAcquireFlag;

    //======================================================
    //---------------------Constructors---------------------
    //======================================================
    public BindableEditText(Context context) {
        this(context, null);
    }

    public BindableEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BindableEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    //======================================================
    //-------------------Override methods-------------------
    //======================================================
    @Override
    public void setText(CharSequence text, BufferType type) {
        if (!mAcquireFlag) {
            super.setText(text, type);
            if (hasFocus() && !TextUtils.isEmpty(text)) {
                setSelection(text.length());
            }
        }
        mAcquireFlag = false;
    }

    //======================================================
    //--------------------Public methods--------------------
    //======================================================
    public void acquire() {
        mAcquireFlag = true;
    }

}
