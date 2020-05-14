package com.vokasi.rifky

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONObjectRequestListener
import kotlinx.android.synthetic.main.activity_menu_utama.*
import org.json.JSONObject

class MenuUtama : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_utama)

//        findViewById<TextView>(R.id.textView)
//        TextView.selected(true)

        getdariserver()

        val context: MenuUtama = this

        button1.setOnClickListener {

            val intent = Intent(context, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        button2.setOnClickListener {

            val intent = Intent(context, Identitas_masjid::class.java)
            startActivity(intent)
            finish()
        }

        button3.setOnClickListener {

            val intent = Intent(context, pengumuman::class.java)
            startActivity(intent)
            finish()
        }

        button4.setOnClickListener {

            val intent = Intent(context, marquee::class.java)
            startActivity(intent)
            finish()
        }

        button5.setOnClickListener {

            val intent = Intent(context, tagline::class.java)
            startActivity(intent)
            finish()
        }

        button6.setOnClickListener {

            val intent = Intent(context, slideshow::class.java)
            startActivity(intent)
            finish()
        }
    }

    fun getdariserver() {
        AndroidNetworking.get("http://192.168.1.16/jamsholat/marquee.php")
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject) {
                    Log.e("_kotlinResponse", response.toString())

                    val jsonArray = response.getJSONArray("result")
                    for (i in 0 until jsonArray.length()) {
                        val jsonObject = jsonArray.getJSONObject(i)
                        Log.e("_kotlinTitle", jsonObject.optString("isi_marquee"))

                        runtext.setText(jsonObject.optString("isi_marquee"))
                    }
                }

                override fun onError(anError: ANError?) {
                    Log.i("_err", anError.toString())
                }
            })
    }
}
