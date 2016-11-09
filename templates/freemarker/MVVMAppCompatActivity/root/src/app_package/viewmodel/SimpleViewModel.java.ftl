package ${packageName}.${viewModelDir};

import android.content.Context;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import by.mvvmwrapper.viewmodel.BaseViewModel;
import ${packageName}.databinding.${bindingName};
import ${packageName}.${viewDataDir}.${viewDataClass};

public class ${viewModelClass} extends BaseViewModel<${viewDataClass}> {

    //======================================================
    //------------------------Fields------------------------
    //======================================================
    
    //======================================================
    //----------------------Constructor---------------------
    //======================================================
    public ${viewModelClass}() {
        super();
    }

    //======================================================
    //-------------------Override methods-------------------
    //======================================================
    @Override
    public void injectViewData() {
    }

    @Override
    public void bindViewData(@NonNull ViewDataBinding viewDataBinding) {
        ((${bindingName}) viewDataBinding).setModel(mViewData);
    }

}
