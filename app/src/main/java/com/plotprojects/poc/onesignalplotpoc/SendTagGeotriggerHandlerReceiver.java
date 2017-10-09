package com.plotprojects.poc.onesignalplotpoc;

import android.util.Log;

import com.onesignal.OneSignal;
import com.plotprojects.retail.android.Geotrigger;
import com.plotprojects.retail.android.GeotriggerHandlerReceiver;

import java.util.List;

public class SendTagGeotriggerHandlerReceiver extends GeotriggerHandlerReceiver {

    static final String LOG_TAG = "Send tag Handler";

    @Override
    public List<Geotrigger> handleGeotriggers(List<Geotrigger> geotriggers) {

        for (Geotrigger geotrigger : geotriggers) {
            String data = geotrigger.getData();
            String now = String.valueOf(System.currentTimeMillis());
            OneSignal.sendTag(data,now);
            Log.d(LOG_TAG, "Sent tag " + "(" + data + ", " + now + ")");
        }
        return geotriggers;
    }
}