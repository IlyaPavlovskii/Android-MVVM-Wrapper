package by.mvvmwrapper.viewdata;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 20.05.17<br>
 * Time: 12:16<br>
 * Project name: MVVMtest<br>
 * ===================================================================================
 * //TODO Add description<br>
 * ===================================================================================
 */
public class BaseViewData implements ViewData {

    protected String TAG = this.getClass().getSimpleName();

    @Override
    public void destroy() {

    }

//    private Map<BaseObservable, Pair<rx.Observable, Subscriber>> mObservablePairMap;
//    private Map<BaseObservable, Observable.OnPropertyChangedCallback> mObservableCallbackMap;
//
//    private rx.Observable mBufferObservable;
//    private Subscriber mBufferSubscriber;
//
//    public BaseViewData() {
//        mObservablePairMap = new HashMap<>();
//        mObservableCallbackMap = new HashMap<>();
//    }
//
//    @Override
//    public void destroy(){
//        if( mObservableCallbackMap != null && !mObservableCallbackMap.isEmpty() ){
//            for(Map.Entry<BaseObservable, Observable.OnPropertyChangedCallback> entry : mObservableCallbackMap.entrySet()){
//                if( entry.getValue() != null ){
//                    entry.getKey().removeOnPropertyChangedCallback( entry.getValue() );
//                }
//            }
//            mObservableCallbackMap.clear();
//        }
//        mObservableCallbackMap = null;
//
//        if( mObservablePairMap != null && !mObservablePairMap.isEmpty()){
//            for(Map.Entry<BaseObservable, Pair<rx.Observable, Subscriber>> entry : mObservablePairMap.entrySet()){
//                if( entry.getValue() != null ){
//                    Subscriber subscriber = entry.getValue().second;
//
//                    if( subscriber != null && subscriber.isUnsubscribed() ){
//                        subscriber.unsubscribe();
//                    }
//                }
//            }
//            mObservablePairMap.clear();
//        }
//        mObservablePairMap = null;
//
//        mBufferObservable = null;
//        mBufferSubscriber = null;
//    }
//
//    // TODO: 20.05.17 TEST
//    public <T> rx.Observable<T> getObservable(@NonNull ObservableField<T> baseObservable){
//        if( mObservablePairMap.containsKey(baseObservable) ){
//            return mObservablePairMap.get(baseObservable).first;
//        } else {
//            mBufferObservable = rx.Observable.create(subscriber -> {
//                mBufferSubscriber = subscriber;
//            });
//
//            Pair<rx.Observable, Subscriber> pair = new Pair<>(mBufferObservable, mBufferSubscriber);
//
//            Observable.OnPropertyChangedCallback mCallback = new Observable.OnPropertyChangedCallback() {
//                @Override
//                public void onPropertyChanged(Observable sender, int propertyId) {
//                    pair.second.onNext( baseObservable.get() );
//                }
//            };
//            baseObservable.addOnPropertyChangedCallback(mCallback);
//
//            mObservablePairMap.put(baseObservable, pair);
//
//            return pair.first;
//        }
//    }
//
}
