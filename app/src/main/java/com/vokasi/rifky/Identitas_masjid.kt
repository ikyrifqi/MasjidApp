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
import kotlinx.android.synthetic.main.activity_identitas_masjid.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.back
import kotlinx.android.synthetic.main.activity_main.simpan
import kotlinx.android.synthetic.main.activity_main.txt1
import kotlinx.android.synthetic.main.activity_main.txt2
import org.json.JSONArray
import org.json.JSONObject

class Identitas_masjid : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_identitas_masjid)

        getdariserver()

        val context: Identitas_masjid = this

        simpan.setOnClickListener {
            var nama_masjid = nama_masjid.text.toString()
            var alamat_masjid = alamat_masjid.text.toString()

            postkeserver(nama_masjid, alamat_masjid)

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
        AndroidNetworking.get("http://192.168.1.16/jamsholat/identitas_masjid.php")
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject) {
                    Log.e("_kotlinResponse", response.toString())

                    val jsonArray = response.getJSONArray("result")
                    for (i in 0 until jsonArray.length()) {
                        val jsonObject = jsonArray.getJSONObject(i)
                        Log.e("_kotlinTitle", jsonObject.optString("nama_masjid"))

                        txt1.setText(jsonObject.optString("nama_masjid"))
                        txt2.setText(jsonObject.optString("alamat_masjid"))
                    }
                }

                override fun onError(anError: ANError?) {
                    Log.i("_err", anError.toString())
                }
            })
    }

    fun postkeserver(data1:String, data2:String) {

        AndroidNetworking.post("http://192.168.0.6/jamsholat/update_identitas.php")
            .addBodyParameter("nama_masjid",data1)
            .addBodyParameter("alamat_masjid",data2)
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
