package com.satriaamrudito.detik

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.satriaamrudito.detik.adapter.RvNewsAdapter
import com.satriaamrudito.detik.databinding.ActivityMainBinding
import com.satriaamrudito.detik.model.ResponseNews
import com.satriaamrudito.detik.service.RetrofitBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val rvAdapter = RvNewsAdapter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.plant(Timber.DebugTree())
        binding = ActivityMainBinding.inflate(layoutInflater)
        with(binding){
            setContentView(root)
//            setSupportActionBar(toolbar)
            mainRv.adapter = rvAdapter
            mainRv.layoutManager = LinearLayoutManager(baseContext)
            mainRv.setHasFixedSize(true)
        }

        val call = RetrofitBuilder.getService().feachHeadLines()
        call.enqueue(object : Callback<ResponseNews> {
            override fun onFailure(call: Call<ResponseNews>, t: Throwable){
                Timber.e(t.localizedMessage)
            }
            override fun onResponse(call: Call<ResponseNews>, response: Response<ResponseNews>){
                Timber.d(response.body()?.totalResults.toString())
                val listArticlesItem = response.body()?.articles
                listArticlesItem.let {
                    it?.let { it1 -> rvAdapter.addData(it1) }
                }
            }
        })
    }
}