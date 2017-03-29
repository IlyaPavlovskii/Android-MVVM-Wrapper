package by.pavlovskii.ilya.mvvm.test.services;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.RemoteMessage;

import static android.content.ContentValues.TAG;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 22.11.16<br>
 * Time: 1:33<br>
 * Project name: MVVMtest<br>
 * ===================================================================================<br>
 * //TODO Add description<br>
 * ===================================================================================<br>
 */
public class FirebaseInstanceIDService extends FirebaseInstanceIdService {

    //======================================================
    //-------------------Override methods-------------------
    //======================================================
    @Override
    public void onTokenRefresh() {
        // Get updated InstanceID token.
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG, "Refreshed token: " + refreshedToken);

        // If you want to send messages to this application instance or
        // manage this apps subscriptions on the server side, send the
        // Instance ID token to your app server.
        FirebaseMessaging.getInstance().subscribeToTopic("first_topic");
    }

    //======================================================
    //---------------------Init methods---------------------
    //======================================================

    //======================================================
    //------------------------Events------------------------
    //======================================================

    //======================================================
    //--------------------Private methods-------------------
    //======================================================

    //======================================================
    //-------------------Protected methods------------------
    //======================================================

    //======================================================
    //---------------------Public methods-------------------
    //======================================================

    //======================================================
    //-----------------------Listeners----------------------
    //======================================================

    //======================================================
    //---------------------Inner classes--------------------
    //======================================================
}
