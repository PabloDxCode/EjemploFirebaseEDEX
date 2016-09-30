package com.example.pgutierrezd.loginfirebasemvp;

import android.app.Application;

import com.firebase.client.Firebase;

/**
 * Created by pgutierrezd on 30/09/2016.
 */
public class AndroidChatApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        setUpFirebase();
    }

    private void setUpFirebase() {
        Firebase.setAndroidContext(this);
        Firebase.getDefaultConfig().setPersistenceEnabled(true);
    }
}
