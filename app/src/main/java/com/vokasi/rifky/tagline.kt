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
import kotlinx.android.synthetic.main.activity_tagline.*
import org.json.JSONArray
import org.json.JSONObject

class tagline : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tagline)

        getdariserver()

        val context: tagline = this

        simpan.setOnClickListener {
            var isi_tagline = isi_tagline.text.toString()

            postkeserver(isi_tagline)

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
        AndroidNetworking.get("http://192.168.1.16/jamsholat/tagline.php")
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject) {
                    Log.e("_kotlinResponse", response.toString())

                    val jsonArray = response.getJSONArray("result")
                    for (i in 0 until jsonArray.length()) {
                        val jsonObject = jsonArray.getJSONObject(i)
                        Log.e("_kotlinTitle", jsonObject.optString("isi_tagline"))

                        txt1.setText(jsonObject.optString("isi_tagline"))
                    }
                }

                override fun onError(anError: ANError?) {
                    Log.i("_err", anError.toString())
                }
            })
    }

    fun postkeserver(data1:String) {

        AndroidNetworking.post("http://192.168.0.6/jamsholat/update_tagline.php")
            .addBodyParameter("isi_tagline",data1)
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
