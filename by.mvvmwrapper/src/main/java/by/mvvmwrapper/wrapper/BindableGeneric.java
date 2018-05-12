package by.mvvmwrapper.wrapper;

import android.databinding.BaseObservable;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 26.01.16<br>
 * Time: 2:54<br>
 * Project name: MVVMtest<br>
 * ===================================================================================
 * Deprecated. Use default two-way binding '@={}' expression for this feature. In the case of @={variable.field}
 * the binder will create the same code as before, but with additional code for getting the value from the View
 * and setting it back to your object.
 *
 * Bindable generic with observable functions. Notifying all components about changes<br>
 * ===================================================================================
 */
@Deprecated
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
     * @param value new template value
     */
    public void set(T value) {
        if (mValue == null || !mValue.equals(value)) {
            this.mValue = value;
            notifyChange();
        }
    }

    /**
     * Set new value to template variable without notify subscribers
     *
     * @param value new template value
     */
    public void setValue(T value) {
        this.mValue = value;
    }

}
