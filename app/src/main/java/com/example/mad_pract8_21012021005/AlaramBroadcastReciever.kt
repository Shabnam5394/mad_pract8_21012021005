package com.example.mad_pract8_21012021005

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class AlaramBroadcastReciever : BroadcastReceiver() {

    companion object {
        val ALARMKEY = "KEY"
        val ALARM_STOP = "START"
        val ALARM_START = "STOP"
    }

    override fun onReceive(context: Context, intent: Intent) {
        // This method is called when the BroadcastReceiver is receiving an Intent broadcast.
        if (intent != null) {
            val data = intent.getStringExtra(ALARMKEY)
            if (data != null) {
                val intentService = Intent(context, AlarmService::class.java)
                if (data == ALARM_START) {
                    // Start the alarm service
                    context.startService(intentService)
                } else if (data == ALARM_STOP) {
                    // Stop the alarm service
                    context.stopService(intentService)
                }
            }
        }
    }
}
