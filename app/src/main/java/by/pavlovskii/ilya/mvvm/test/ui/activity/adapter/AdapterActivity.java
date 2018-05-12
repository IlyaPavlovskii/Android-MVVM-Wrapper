package by.pavlovskii.ilya.mvvm.test.ui.activity.adapter;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import by.pavlovskii.ilya.mvvm.test.R;
import by.pavlovskii.ilya.mvvm.test.databinding.ActivityAdapterBinding;
import by.pavlovskii.ilya.mvvm.test.ui.activity.BaseActivity;
import timber.log.Timber;

import javax.inject.Inject;
import javax.inject.Provider;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 12.05.2018<br>
 * Time: 20:32<br>
 * Project name: MVVMtest<br>
 * ===================================================================================<br>
 */
public class AdapterActivity extends BaseActivity<AdapterViewModel, ActivityAdapterBinding> {

    @Inject
    Provider<RecyclerView.Adapter> mAdapterProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding.setVerticalAdapter(mAdapterProvider.get());
        addDisposable(mViewModel.initList()
                .subscribe(
                        () -> Timber.d("initList complete: "),
                        this::handleException));
    }

    @Override
    protected Class<AdapterViewModel> getViewModelClass() {
        return AdapterViewModel.class;
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_adapter;
    }

}
