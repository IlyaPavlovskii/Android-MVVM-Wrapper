package by.mvvmwrapper.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.EditText;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 28.01.16<br>
 * Time: 22:57<br>
 * Project name: MVVMtest<br>
 * ===================================================================================
 * EditText with function to link 2 or more view component to one data<br>
 * ===================================================================================
 */
public class BindableEditText extends android.support.v7.widget.AppCompatEditText {

    //======================================================
    //------------------------Fields------------------------
    //======================================================

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
        super.setText(text, type);
        if (text != null) {
            setSelection(text.length());
        }
    }

}
