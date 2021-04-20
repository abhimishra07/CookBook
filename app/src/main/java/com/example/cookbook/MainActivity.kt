package com.example.cookbook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadFood()
    }
private fun loadFood(){
    val queue = Volley.newRequestQueue(this)
    val url = "www.themealdb.com/api/json/v1/1/random.php"

// Request a string response from the provided URL.
    val jsonObjectRequest = JsonObjectRequest(
        Request.Method.GET, url,null,
        { response ->
         val url= response.getString("strMealThumb")
            Glide.with(this).load(url).into(FoodImageView)
        },
        {

        })

// Add the request to the RequestQueue.
    queue.add(jsonObjectRequest)
}
    fun NextFood(view: View) {

    }
}