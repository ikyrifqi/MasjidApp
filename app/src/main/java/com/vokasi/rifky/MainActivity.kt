package com.vokasi.rifky

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONArrayRequestListener
import com.androidnetworking.interfaces.JSONObjectRequestListener
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray
import org.json.JSONObject

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getdariserver()

        val context: MainActivity = this

            simpan.setOnClickListener {
                var shubuh = shubuh.text.toString()
                var dhuha = dhuha.text.toString()
                var dhuhur = dhuhur.text.toString()
                var ashar = ashar.text.toString()
                var maghrib = maghrib.text.toString()
                var isha = isha.text.toString()

                postkeserver(shubuh, dhuha, dhuhur, ashar, maghrib, isha)

                val intent = getIntent()
                startActivity(intent)
                finish()
            }


            back.setOnClickListener {

                val intent = Intent(context, MenuUtama::class.java)
                startActivity(intent)
                finish()
            }

        }

    fun getdariserver() {
        AndroidNetworking.get("http://192.168.1.16/jamsholat/jadwal_sholat.php")
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject) {
                    Log.e("_kotlinResponse", response.toString())

                    val jsonArray = response.getJSONArray("result")
                    for (i in 0 until jsonArray.length()) {
                        val jsonObject = jsonArray.getJSONObject(i)
                        Log.e("_kotlinTitle", jsonObject.optString("shubuh"))

                        txt1.setText("Subuh : "+jsonObject.optString("shubuh"))
                        txt2.setText("Dhuha : "+jsonObject.optString("dhuha"))
                        txt3.setText("Dzuhur : "+jsonObject.optString("dhuhur"))
                        txt4.setText("Ashar : "+jsonObject.optString("ashar"))
                        txt5.setText("Maghrib : "+jsonObject.optString("maghrib"))
                        txt6.setText("Isya : "+jsonObject.optString("isha"))
                    }
                }

                override fun onError(anError: ANError?) {
                    Log.i("_err", anError.toString())
                }
            })
    }

    fun postkeserver(data1:String, data2:String, data3:String, data4:String, data5:String, data6:String) {

        AndroidNetworking.post("http://192.168.0.6/jamsholat/update-jadwal.php")
            .addBodyParameter("shubuh",data1)
            .addBodyParameter("dhuha",data2)
            .addBodyParameter("dhuhur",data3)
            .addBodyParameter("ashar",data4)
            .addBodyParameter("maghrib",data5)
            .addBodyParameter("isha",data6)
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONArray(object : JSONArrayRequestListener {
                override fun onResponse(response: JSONArray?) {

                }

                override fun onError(anError: ANError?) {

                }
            })
    }


    }
