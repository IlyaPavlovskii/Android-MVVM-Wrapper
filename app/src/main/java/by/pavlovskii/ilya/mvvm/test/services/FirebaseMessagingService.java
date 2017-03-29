package by.pavlovskii.ilya.mvvm.test.services;

import android.util.Log;

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
public class FirebaseMessagingService extends com.google.firebase.messaging.FirebaseMessagingService {

    //======================================================
    //-------------------Override methods-------------------
    //======================================================
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        // Handle data payload of FCM messages.
        Log.d(TAG, "FCM Message Id: " + remoteMessage.getMessageId());
        Log.d(TAG, "FCM Notification Message: " + remoteMessage.getNotification());
        Log.d(TAG, "FCM Data Message: " + remoteMessage.getData());
        Log.d(TAG, "==========================================================");
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
