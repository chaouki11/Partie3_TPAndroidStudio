package com.example.partie3;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        Log.i("BR_TAG"," Event Received ");
        // an Intent broadcast.
        throw new UnsupportedOperationException("Not yet implemented");

    }
}