package com.example.persistentcalculation

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var ed1:EditText
    lateinit var ed2: EditText
    lateinit var mul: Button
    lateinit var txt1: TextView
    lateinit var shard: SharedPreferences
    var num1 = 0f
    var num2 = 0f
    var rsult=0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ed1 = findViewById(R.id.ed1)
        ed2 = findViewById(R.id.ed2)
        txt1 = findViewById(R.id.txt1)
        mul = findViewById(R.id.mul)
        // syntax for SharedPreferences
        shard = this.getSharedPreferences(
            getString(R.string.preference_file_key), MODE_PRIVATE)

        mul.setOnClickListener {
// step 1 i save input data in variable to use it
            var frs = ed1.text.toString()
            var frs2 = ed2.text.toString()
// step 2 i make casting for data to make it float
              num1 = frs.toFloat()
              num2 = frs2.toFloat()
             rsult = num1 * num2
//step 3 display data in textviwe
            txt1.text="$rsult"
// step 4 save data by SharedPreferences
            save()
        }
    }
    // run for saving data
    fun save() {
        with(shard.edit()) {
            val sh=  putFloat("name",rsult)
            apply()
            Toast.makeText(applicationContext,"save Data",Toast.LENGTH_SHORT).show()
        }
    }
}