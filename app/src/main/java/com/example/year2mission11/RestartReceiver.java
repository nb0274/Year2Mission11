package com.example.year2mission11;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.BroadcastReceiver;
import android.content.Intent;

public class RestartReceiver extends BroadcastReceiver {
    // trying to fix a commit issue
    int count = 0;
    SharedPreferences restartSharedPref;
    SharedPreferences.Editor prefEditor;

    /**
     * This method is called when the BroadcastReceiver is receiving an Intent broadcast.
     * @param context The Context in which the receiver is running.
     * @param intent The Intent being received.
     */
    @Override
    public void onReceive(Context context, Intent intent) {
        restartSharedPref = (SharedPreferences) context.getSharedPreferences("RESTARTC", MODE_PRIVATE);
        prefEditor = restartSharedPref.edit();
        count = restartSharedPref.getInt("restartC", 0);
        prefEditor.putInt("restartC", count + 1);
        prefEditor.commit();
    }
}