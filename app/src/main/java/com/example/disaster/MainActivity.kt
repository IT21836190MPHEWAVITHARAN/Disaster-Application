package com.example.disaster

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var addDisBtn:Button= findViewById(R.id.addDisasterBtn)
        addDisBtn.setOnClickListener{
            var intent = Intent(this,AddDisasters::class.java)
            startActivity(intent)
        }


        var contactus:Button= findViewById(R.id.contactBtn)
        contactus.setOnClickListener{
            var intent = Intent(this,ImargancyContact::class.java)
            startActivity(intent)
        }
    }
}