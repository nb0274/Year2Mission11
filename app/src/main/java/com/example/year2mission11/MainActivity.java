package com.example.year2mission11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    SharedPreferences bootCounterFile;
    static TextView textViewRestart;
    static TextView textViewPlugs;
    static TextView textViewFivePlugs;
    PlugReceiver plugReceiver;
    FiveTimesPlugReceiver fiveTimesPlugReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewRestart = (TextView) findViewById(R.id.textViewRestart);
        textViewPlugs = (TextView) findViewById(R.id.textViewPlugs);
        textViewFivePlugs = (TextView) findViewById(R.id.textViewFivePlugs);

        plugReceiver = new PlugReceiver();
        fiveTimesPlugReceiver = new FiveTimesPlugReceiver();
        bootCounterFile = (SharedPreferences) getSharedPreferences("RESTARTC", MODE_PRIVATE);
        textViewRestart.setText("" + bootCounterFile.getInt("restartC", 0));
    }

    /**
     * This function increases the counter of headset plugs by one.
     */
    public static void increasePlugC() {
        textViewPlugs.setText("" + (Integer.parseInt(textViewPlugs.getText() + "") + 1));
    }

    /**
     * This function increases the counter of five headset plugs by one.
     */
    public static void increaseFiveTimesPlugC() {
        textViewFivePlugs.setText("" + (Integer.parseInt(textViewFivePlugs.getText() + "") + 1));
    }

    /**
     * This function returns the value of the headset plugs counter.
     * @return The value of the headset plugs counter.
     */
    public static int getHpPlugsCounter() {
        return Integer.parseInt("" + textViewPlugs.getText());
    }

    /**
     * This function is called when the activity is started. It registers the dynamic broadcast
     * receivers.
     */
    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter PlugFilter = new IntentFilter(Intent.ACTION_HEADSET_PLUG);
        registerReceiver(plugReceiver, PlugFilter);

        IntentFilter fiveTimesPlugFilter = new IntentFilter(FiveTimesPlugReceiver.LOC);
        registerReceiver(fiveTimesPlugReceiver, fiveTimesPlugFilter);
    }

    /**
     * This function is called when the activity is stopped. It unregisters the dynamic broadcast
     * receivers.
     */
    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(plugReceiver);
        unregisterReceiver(fiveTimesPlugReceiver);
    }
}