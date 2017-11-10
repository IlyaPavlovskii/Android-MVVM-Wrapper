package ${packageName}.${viewDataDir};

import android.support.annotation.Nullable;

import by.mvvmwrapper.viewdata.ViewData;
import by.mvvmwrapper.wrapper.BindableGeneric;

public class ${viewDataClass} implements IViewData {

    //======================================================
    //------------------------Fields------------------------
    //======================================================
    public String text;

    //======================================================
    //----------------------Constructor---------------------
    //======================================================
    public ${viewDataClass}() {
        text = "TEXT";
    }

    //======================================================
    //--------------------Override methods------------------
    //======================================================
    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}