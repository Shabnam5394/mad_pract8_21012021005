package com.example.mad_pract8_21012021005

import android.app.AlarmManager
import android.app.DatePickerDialog
import android.app.PendingIntent
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.util.Calendar


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fab: FloatingActionButton = findViewById(R.id.fabalarmbutton)


        fab.setOnClickListener {
            val textView: TextView = findViewById(R.id.showdate) // Your TextView
            fab.setOnClickListener {
                showDatePickerDialog(textView)
            }
        }
    }
    fun setalarm(militime:Long,action: String){
        val intentalarm=Intent(applicationContext,AlaramBroadcastReciever::class.java)
        intentalarm.putExtra(AlaramBroadcastReciever.ALARMKEY)
        val pendingIntent=PendingIntent.getBroadcast(applicationContext,2345,intentalarm,PendingIntent.FLAG_UPDATE_CURRENT)
        val manager=getSystemService(ALARM_SERVICE)as AlarmManager

        if(action==AlaramBroadcastReciever.ALARM_START){
            manager.setExact(AlarmManager.RTC_WAKEUP,militime,pendingIntent)
        }
    }

    private fun showDatePickerDialog(textView: TextView) {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener { _, selectedYear, selectedMonth, selectedDay ->
                // Handle the selected date
                val selectedDate = "$selectedDay/${selectedMonth + 1}/$selectedYear" // Format as needed
                textView.text = selectedDate
            },
            year,
            month,
            dayOfMonth
        )

        // Show the date picker dialog
        datePickerDialog.show()
    }


}