package ${packageName}.${activityDir};

import by.mvvmwrapper.activity.BaseActivity;
<#if applicationPackage??>
    import ${applicationPackage}.R;
</#if>
import ${packageName}.R;
import ${packageName}.databinding.${bindingName};
import ${packageName}.${viewModelDir}.${viewModelClass};
import android.support.annotation.NonNull;
import android.os.Bundle;

public class ${activityClass} extends BaseActivity< ${viewModelClass}, ${bindingName} > {

    //======================================================
    //-------------------Override methods-------------------
    //======================================================
    @Override
    protected int getLayoutRes() {
        <#if generateLayout>
    	   return R.layout.${layoutName};
        <#else>
            return 0;
        </#if>
    }

    @NonNull
    @Override
    protected ${viewModelClass} getViewModel() {
        return new ${viewModelClass}(this);
    }
}
