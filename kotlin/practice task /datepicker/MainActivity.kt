package com.example.datepicker

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.Dialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import android.widget.TimePicker
import androidx.fragment.app.DialogFragment
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    lateinit var bbt1: Button
    lateinit var bbt2: Button

    companion object {
        lateinit var txt1: TextView
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bbt1 = findViewById(R.id.btn1)
        bbt2 = findViewById(R.id.btn2)
        txt1 = findViewById(R.id.Edit1)


        bbt1.setOnClickListener {
            var a1 = MydatePicker()
            a1.show(supportFragmentManager, "selectdate")

        }

        bbt2.setOnClickListener {
            var a1 = MyTimePicker()
            a1.show(supportFragmentManager, "selecttime")


        }
    }

    class MydatePicker : DialogFragment(), DatePickerDialog.OnDateSetListener {
        override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
            var c = Calendar.getInstance()
            var date = c.get(Calendar.DATE)
            var month = c.get(Calendar.DAY_OF_MONTH)
            var year = c.get(Calendar.YEAR)

            return DatePickerDialog(requireActivity(), this, year, month, date)
        }

        override fun onDateSet(p0: DatePicker?, p1: Int, p2: Int, p3: Int) {
            MainActivity.txt1.setText("$p1-$p2-$p3")
        }
    }

    class MyTimePicker : DialogFragment(), TimePickerDialog.OnTimeSetListener {
        override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
            var c = Calendar.getInstance()
            var hour = c.get(Calendar.HOUR_OF_DAY)
            var minute = c.get(Calendar.MINUTE)


            return TimePickerDialog(requireActivity(), this, hour, minute, false)
        }

        override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
            MainActivity.txt1.setText("$hourOfDay : $minute")
        }
    }
}


