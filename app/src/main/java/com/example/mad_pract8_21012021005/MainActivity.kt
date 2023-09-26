package com.example.mad_pract8_21012021005

import android.app.Activity
import android.app.AlarmManager
import android.app.DatePickerDialog
import android.app.PendingIntent
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup.Binding
import android.view.LayoutInflater
import android.view.inputmethod.InputBinding
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.core.view.WindowCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.util.Calendar


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window,false)
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)



    }
    fun setalarm(militime:Long,action: String){
        val intentalarm=Intent(applicationContext,AlaramBroadcastReciever::class.java)
        intentalarm.putExtra("",AlaramBroadcastReciever.ALARMKEY)
        val pendingIntent=PendingIntent.getBroadcast(applicationContext,2345,intentalarm,PendingIntent.FLAG_UPDATE_CURRENT)
        val manager=getSystemService(ALARM_SERVICE)as AlarmManager

        if(action==AlaramBroadcastReciever.ALARM_START){
            manager.setExact(AlarmManager.RTC_WAKEUP,militime,pendingIntent)
        }
    }




}




