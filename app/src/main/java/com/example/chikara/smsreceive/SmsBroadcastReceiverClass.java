package com.example.chikara.smsreceive;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

/**
 * Created by chikara on 11/30/17.
 */

public class SmsBroadcastReceiverClass extends BroadcastReceiver {

    public static final String SMS_BUNDLE = "pdus";
    private static smsInterface mAnInterface;

    public void onReceive(Context context, Intent intent) {
        Bundle intentExtras = intent.getExtras();
        if (intentExtras != null) {
            Object[] sms = (Object[]) intentExtras.get(SMS_BUNDLE);
            String smsMessageStr = "";
            for (int i = 0; i < sms.length; ++i) {
                SmsMessage smsMessage = SmsMessage.createFromPdu((byte[]) sms[i]);

                String smsBody = smsMessage.getMessageBody().toString();
                String address = smsMessage.getOriginatingAddress();

                smsMessageStr += "SMS From: " + address + "\n";
                smsMessageStr += smsBody + "\n";
            }
            mAnInterface.receiveMessage(smsMessageStr);
            Toast.makeText(context, smsMessageStr, Toast.LENGTH_SHORT).show();
        }
    }

    public static void smsListiner(smsInterface anInterface) {
        mAnInterface = anInterface;
    }

    interface smsInterface {
        public void receiveMessage(String sms);
    }

}