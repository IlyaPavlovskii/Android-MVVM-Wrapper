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
    public ${viewModelClass}(@NonNull Context context) {
        super(context);
    }

    //======================================================
    //-------------------Override methods-------------------
    //======================================================
    @NonNull
    @Override
    public ${viewDataClass} initViewData() {
        return new ${viewDataClass}();
    }

    @Override
    public void bindViewData(@NonNull ViewDataBinding viewDataBinding) {
        ((${bindingName}) viewDataBinding).setModel(mViewData);
    }

}
