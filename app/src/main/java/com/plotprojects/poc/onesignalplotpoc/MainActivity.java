package com.plotprojects.poc.onesignalplotpoc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.onesignal.OneSignal;
import com.plotprojects.retail.android.Plot;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Plot.init(this);

        OneSignal.startInit(this)
                .inFocusDisplaying(OneSignal.OSInFocusDisplayOption.Notification)
                .unsubscribeWhenNotificationsAreDisabled(true)
                .init();
    }
}
