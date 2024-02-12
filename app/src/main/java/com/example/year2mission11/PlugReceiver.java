package com.example.year2mission11;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class PlugReceiver extends BroadcastReceiver {
    int count = 0;

    /**
     * This function is called when the broadcast of a plug is received. It increases the
     * suitable counter in MainActivity.
     */
    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getExtras().getInt("state", 0) == 1)
        {
            MainActivity.increasePlugC();
            count = MainActivity.getHpPlugsCounter();
            if((count % 5 == 0) && (count != 0)) {
                Intent in = new Intent(FiveTimesPlugReceiver.LOC);
                context.sendBroadcast(in);
            }
        }

    }
}