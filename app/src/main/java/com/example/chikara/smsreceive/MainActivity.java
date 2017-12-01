package com.example.chikara.smsreceive;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SmsBroadcastReceiverClass.smsListiner(new SmsBroadcastReceiverClass.smsInterface() {
            @Override
            public void receiveMessage(String sms) {

            }
        });
    }
}
