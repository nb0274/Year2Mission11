package com.example.year2mission11;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class FiveTimesPlugReceiver extends BroadcastReceiver {
    public static final String LOC = "com.example.year2mission11.receivers.FiveTimesPlugReceiver";

    /**
     * This function is called when the broadcast of five plugs is received. It increases the
     * suitable counter in MainActivity.
     */
    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals(LOC)) {
            MainActivity.increaseFiveTimesPlugC();
        }
    }
}