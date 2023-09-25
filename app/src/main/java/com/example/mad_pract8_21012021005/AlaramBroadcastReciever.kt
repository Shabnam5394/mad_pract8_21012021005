package com.example.mad_pract8_21012021005

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class AlaramBroadcastReciever : BroadcastReceiver() {

    companion object{
        val ALARMKEY="shabnam"
        val ALARM_STOP="muskan"
        val ALARM_START="sana"
    }
    override fun onReceive(context: Context, intent: Intent) {
        // This method is called when the BroadcastReceiver is receiving an Intent broadcast.
        val data=intent.getStringExtra(ALARMKEY)
        val intentService=Intent(context,AlarmService::class.java)
        if(data==ALARMKEY){

            context.startService(intentService)
        }
        else if(data== ALARM_STOP){
            context.stopService(intentService)
        }

    }

}