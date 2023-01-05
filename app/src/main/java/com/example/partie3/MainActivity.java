package com.example.partie3;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btn;
    TextView textView;
    MyBroadcastBatteryLow mybrodcast = new MyBroadcastBatteryLow();
    IntentFilter filter = new IntentFilter();
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        filter.addAction(Intent.ACTION_BATTERY_LOW);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.btn);
        textView = (TextView) findViewById(R.id.textView);



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent fakeEventIntent = new Intent(MainActivity.this, MyReceiver.class);
                sendBroadcast(fakeEventIntent);

            }
        });


    }


    class MyBroadcastBatteryLow extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            Log.i("general","general");
            textView.setText("Evenement batterie faible recu");

        }

    }
    @Override
    protected void onResume() {
        super.onResume();
        this.registerReceiver(mybrodcast,filter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        this.unregisterReceiver(mybrodcast);

    }


}

