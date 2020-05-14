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
import kotlinx.android.synthetic.main.activity_main.back
import kotlinx.android.synthetic.main.activity_main.simpan
import kotlinx.android.synthetic.main.activity_main.txt1
import kotlinx.android.synthetic.main.activity_main.txt2
import kotlinx.android.synthetic.main.activity_pengumuman.*
import org.json.JSONArray
import org.json.JSONObject

class
pengumuman : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pengumuman)

        getdariserver()

        val context: pengumuman = this

        simpan.setOnClickListener {
            var judul_pengumuman = judul_pengumuman.text.toString()
            var isi_pengumuman = isi_pengumuman.text.toString()

            postkeserver(judul_pengumuman, isi_pengumuman)

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
        AndroidNetworking.get("http://192.168.1.16/jamsholat/pengumuman_masjid.php")
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject) {
                    Log.e("_kotlinResponse", response.toString())

                    val jsonArray = response.getJSONArray("result")
                    for (i in 0 until jsonArray.length()) {
                        val jsonObject = jsonArray.getJSONObject(i)
                        Log.e("_kotlinTitle", jsonObject.optString("judul_pengumuman"))

                        txt1.setText(jsonObject.optString("judul_pengumuman"))
                        txt2.setText(jsonObject.optString("isi_pengumuman"))
                    }
                }

                override fun onError(anError: ANError?) {
                    Log.i("_err", anError.toString())
                }
            })
    }

    fun postkeserver(data1:String, data2:String) {

        AndroidNetworking.post("http://192.168.0.6/jamsholat/update_pengumuman.php")
            .addBodyParameter("judul_pengumuman",data1)
            .addBodyParameter("isi_pengumuman",data2)
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
