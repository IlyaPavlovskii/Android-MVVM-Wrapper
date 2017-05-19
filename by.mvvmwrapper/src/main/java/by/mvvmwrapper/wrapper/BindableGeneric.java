package by.mvvmwrapper.wrapper;

import android.databinding.BaseObservable;
import android.databinding.ObservableField;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 26.01.16<br>
 * Time: 2:54<br>
 * Project name: MVVMtest<br>
 * ===================================================================================
 * Bindable generic with observable functions. Notifying all components about changes<br>
 * ===================================================================================
 */
public class BindableGeneric<T> extends BaseObservable {

    //======================================================
    //------------------------Fields------------------------
    //======================================================
    protected T mValue;

    //======================================================
    //---------------------Constructors---------------------
    //======================================================
    public BindableGeneric(T value) {
        mValue = value;
    }

    //======================================================
    //--------------------Override methods------------------
    //======================================================
    @Override
    public int hashCode() {
        return mValue == null ? 0 : mValue.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (o != null && o instanceof BindableGeneric) {
            BindableGeneric bg = (BindableGeneric) o;
            return mValue != null && mValue.equals(bg);
        } else {
            return false;
        }
    }

    @Override
    public BindableGeneric<T> clone() {
        return new BindableGeneric<>(mValue);
    }

    @Override
    public String toString() {
        return mValue != null ? mValue.toString() : null;
    }

    //======================================================
    //---------------------Public methods-------------------
    //======================================================

    /**
     * Get template value
     */
    public T getValue() {
        return mValue;
    }

    /**
     * Set new value to template variable and notify all components about changes
     *
     * @param value new template value*/
    public void set(T value) {
        if (mValue == null || !mValue.equals(value)) {
            this.mValue = value;
            notifyChange();
        }
    }

    /**
     * Set new value to template variable without notify subscribers
     *
     * @param value new template value*/
    public void setValue(T value) {
        this.mValue = value;
    }

}
