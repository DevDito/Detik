package com.satriaamrudito.detik

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import coil.load
import com.satriaamrudito.detik.adapter.RvNewsAdapter
import com.satriaamrudito.detik.databinding.ActivityDetailBinding
import kotlinx.android.synthetic.main.activity_detail.*
import timber.log.Timber

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private val rvAdapter = RvNewsAdapter()

    companion object {
        val date: String? = null
        val content: String? = null
        val image: String? = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.plant(Timber.DebugTree())
        binding = ActivityDetailBinding.inflate(layoutInflater)
        with(binding) {
            setContentView(root)

            val dates = intent.getStringExtra(date)
            val contents = intent.getStringExtra(content)
            val images = intent.getStringExtra(image)

            txt_date.text = dates
            txt_content.text = contents
            img_toolbar.load(images)
        }


    }
}