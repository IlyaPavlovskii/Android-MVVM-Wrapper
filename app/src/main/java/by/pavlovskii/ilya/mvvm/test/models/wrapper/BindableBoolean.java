package by.pavlovskii.ilya.mvvm.test.models.wrapper;

import android.databinding.BaseObservable;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 26.01.16<br>
 * Time: 1:44<br>
 * Project name: MVVMtest<br>
 * ===================================================================================
 * //TODO Add description<br>
 * ===================================================================================
 */
public class BindableBoolean extends BaseObservable {

    //======================================================
    //------------------------Fields------------------------
    //======================================================
    protected boolean mValue;

    //======================================================
    //---------------------Constructors---------------------
    //======================================================
    public BindableBoolean() {}

    public BindableBoolean(boolean value) {
        mValue = value;
    }

    //======================================================
    //-------------------Override methods-------------------
    //======================================================
    @Override
    public int hashCode() {
        return mValue ? 1 : 0;
    }

    @Override
    public boolean equals(Object o) {
        if( o != null && o instanceof BindableBoolean){
            BindableBoolean bs = (BindableBoolean)o;
            return mValue == bs.mValue;
        } else {
            return false;
        }
    }

    @Override
    public BindableBoolean clone() {
        return new BindableBoolean(mValue);
    }

    @Override
    public String toString() {
        return String.valueOf(mValue);
    }

    //======================================================
    //---------------------Public methods-------------------
    //======================================================
    public boolean get() {
        return mValue;
    }

    public void set(boolean value) {
        if( this.mValue != value ) {
            this.mValue = value;
            notifyChange();
        }
    }

    public void setValue(boolean value){
        this.mValue = value;
    }
}
