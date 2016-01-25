package by.pavlovskii.ilya.mvvm.test.models.wrapper;

import android.databinding.BaseObservable;
import android.text.TextUtils;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 26.01.16<br>
 * Time: 0:39<br>
 * Project name: MVVMtest<br>
 * ===================================================================================
 * //TODO Add description<br>
 * ===================================================================================
 */
public class BindableString extends BaseObservable {

    //======================================================
    //------------------------Fields------------------------
    //======================================================
    protected String mValue;

    //======================================================
    //---------------------Constructors---------------------
    //======================================================
    public BindableString(){}

    public BindableString(String value) {
        mValue = value;
    }

    //======================================================
    //--------------------Override methods------------------
    //======================================================
    @Override
    public int hashCode() {
        return TextUtils.isEmpty(mValue) ? null : mValue.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if( o != null && o instanceof BindableString){
            BindableString bs = (BindableString)o;
            return TextUtils.equals(mValue, bs.mValue);
        } else {
            return false;
        }
    }

    @Override
    public BindableString clone() {
        return new BindableString(mValue);
    }

    @Override
    public String toString() {
        return mValue;
    }

    //======================================================
    //---------------------Public methods-------------------
    //======================================================
    public String getValue(){
        return mValue;
    }

    public void set(String value) {
        if (!TextUtils.equals(this.mValue, value)) {
            this.mValue = value;
            notifyChange();
        }
    }

    public void setValue(String value){
        this.mValue = value;
    }

}
