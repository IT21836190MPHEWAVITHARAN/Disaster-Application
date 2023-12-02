package com.example.disaster

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ImargancyContact : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imargancy_contact)

        val callfire:Button = findViewById(R.id.callFire)
        val callpolice:Button = findViewById(R.id.callPiolice)
        val callAmbulance:Button = findViewById(R.id.callAmbulance)
        val callDoctor:Button = findViewById(R.id.callDoctor)
        val medicalWeb:Button = findViewById(R.id.medicalWeb)
        val firsaidTip:Button = findViewById(R.id.firsaidTip)
        val wethernews:Button = findViewById(R.id.wethernews)

        callfire.setOnClickListener{
            val number = "+94712536789"
            val  uri = Uri.parse(String.format("tel:$number"))
            val intent = Intent()
            intent.action = Intent.ACTION_DIAL
            intent.data = uri
            startActivity(intent)
        }

        callpolice.setOnClickListener{
            val number = "911"
            val  uri = Uri.parse(String.format("tel:$number"))
            val intent = Intent()
            intent.action = Intent.ACTION_DIAL
            intent.data = uri
            startActivity(intent)
        }

        callAmbulance.setOnClickListener{
            val number = "7788"
            val  uri = Uri.parse(String.format("tel:$number"))
            val intent = Intent()
            intent.action = Intent.ACTION_DIAL
            intent.data = uri
            startActivity(intent)
        }

        callDoctor.setOnClickListener{
            val number = "6969"
            val  uri = Uri.parse(String.format("tel:$number"))
            val intent = Intent()
            intent.action = Intent.ACTION_DIAL
            intent.data = uri
            startActivity(intent)
        }


        medicalWeb.setOnClickListener{

            val url ="https://www.Medicalcentral.com"
            val uri = Uri.parse(url)
            val intent = Intent()
            intent.action = Intent.ACTION_VIEW
            intent.data = uri
            startActivity(intent)

        }

        firsaidTip.setOnClickListener{

            val url ="https://www.Fire.com"
            val uri = Uri.parse(url)
            val intent = Intent()
            intent.action = Intent.ACTION_VIEW
            intent.data = uri
            startActivity(intent)

        }

        wethernews.setOnClickListener{

            val url ="https://www.Wethercenter.com"
            val uri = Uri.parse(url)
            val intent = Intent()
            intent.action = Intent.ACTION_VIEW
            intent.data = uri
            startActivity(intent)

        }






    }
}