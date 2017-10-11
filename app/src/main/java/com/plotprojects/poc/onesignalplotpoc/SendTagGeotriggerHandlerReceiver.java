package com.plotprojects.poc.onesignalplotpoc;

import android.util.Log;

import com.onesignal.OneSignal;
import com.plotprojects.retail.android.Geotrigger;
import com.plotprojects.retail.android.GeotriggerHandlerReceiver;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class SendTagGeotriggerHandlerReceiver extends GeotriggerHandlerReceiver {

    static final String LOG_TAG = "Send tag Handler";

    @Override
    public List<Geotrigger> handleGeotriggers(List<Geotrigger> geotriggers) {

        for (Geotrigger geotrigger : geotriggers) {
            String data = geotrigger.getData();
            try {
                JSONObject jObject = new JSONObject(data);
                String key = jObject.getString("key");
                String now = String.valueOf(System.currentTimeMillis()/1000); // in seconds
                OneSignal.sendTag(key,now);
                Log.d(LOG_TAG, "Sent tag " + "(" + key + ", " + now + ")");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return geotriggers;
    }
}