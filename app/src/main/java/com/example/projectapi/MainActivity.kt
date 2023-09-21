package com.example.projectapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projectapi.adapter.Adapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recycle = findViewById<RecyclerView>(R.id.recycle)
        val tvAPI = findViewById<TextView>(R.id.tvAPI)

        recycle.setHasFixedSize(true)
        recycle.layoutManager = LinearLayoutManager(this)

        RetrofitClient.instance.getSurat().enqueue(object : Callback<APIResponse> {
            override fun onResponse(
                call: Call<APIResponse>,
                response: Response<APIResponse>
            ) {
                val responseCode = response.code().toString()
                tvAPI.text = responseCode

                if (response.isSuccessful) {
                    val apiResponse = response.body()
                    if (apiResponse != null) {
                        val suratResponseList = apiResponse.data

                        // Inisialisasi adapter dengan list data SuratResponse
                        val adapter = Adapter(suratResponseList)
                        recycle.adapter = adapter
                    }
                } else {
                    // Respons tidak berhasil, mungkin ada pesan kesalahan dalam respons
                    val errorBody = response.errorBody()?.string()
                    Log.e("MainActivity", "onResponse: Error Body: $errorBody")
                }


                Log.d("MainActivity", "onResponse: Response code is $responseCode") // Log response code
            }

            override fun onFailure(call: Call<APIResponse>, t: Throwable) {
                Log.e("MainActivity", "onFailure: ${t.message}", t) // Log error message and exception

                // Tambahkan kode untuk mencetak pesan kesalahan dari response jika ada
                if (t is retrofit2.HttpException) {
                    val errorBody = t.response()?.errorBody()?.string()
                    Log.e("MainActivity", "onFailure: Error Body: $errorBody")
                }
            }
        })

        Log.i("MainActivity", "onCreate: MainActivity is created") // Log onCreate event
    }
}

