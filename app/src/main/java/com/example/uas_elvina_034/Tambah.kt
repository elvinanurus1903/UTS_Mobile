package com.example.uas_elvina_034

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONObjectRequestListener
import kotlinx.android.synthetic.main.activity_dashboard.*
import kotlinx.android.synthetic.main.activity_dashboard.tambah
import kotlinx.android.synthetic.main.activity_tambah.*
import org.json.JSONObject

class Tambah : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tambah)
        val context = this

        tambah.setOnClickListener{

            var data_judul = judul.text.toString()
            var data_waktu= waktu.text.toString()
            var data_penulis= penulis.text.toString()
            var data_isi= isi.text.toString()
            postkeserver(data_judul,data_waktu,data_penulis, data_isi)

            val intent = Intent(context,MainActivity::class.java)
            startActivity(intent)

        }
    }

    fun postkeserver(data1:String, data2:String, data3:String, data4:String){


        AndroidNetworking.post("http://172.30.60.83/Mobile_terapan/insert_data.php")
            .addBodyParameter("judul_berita", data1)
            .addBodyParameter("waktu_berita", data2)
            .addBodyParameter("penulis_berita", data3)
            .addBodyParameter("isi_berita", data4)
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject) {


                }

                override fun onError(anError: ANError) { // handle error

                }
            })
    }
}
