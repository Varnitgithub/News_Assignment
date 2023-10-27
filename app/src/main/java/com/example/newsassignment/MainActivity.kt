package com.example.newsassignment

import android.app.ActionBar.LayoutParams
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.browser.customtabs.CustomTabsIntent
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsassignment.databinding.MainActivityBinding
import com.example.newsassignment.models.Article
import com.example.newsassignment.models.NewstypeModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity(), Adapterclass.clicked, NewsTypeAdapter.clicked {
    private lateinit var binding: MainActivityBinding
    private lateinit var adapterclass: Adapterclass
    private lateinit var newsTypeAdapter: NewsTypeAdapter
    val mviewmodel: viewmodel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.main_activity)
        binding.progressBar.visibility = View.VISIBLE



        //adapter initialization
        adapterclass = Adapterclass(this, this)
        newsTypeAdapter = NewsTypeAdapter(this, this)

        //recyclerview 1
        binding.recyclerview.layoutManager = LinearLayoutManager(this)
        binding.recyclerview.adapter = adapterclass

        //recyclerview 2
        binding.recyclerviewHorizontal.layoutManager =
            GridLayoutManager(this, 1, GridLayoutManager.HORIZONTAL, false)
        binding.recyclerviewHorizontal.adapter = newsTypeAdapter


        //viewmodel data

        val arrayofNewsType = arrayOf(
            NewstypeModel("apple"), NewstypeModel("android"),
            NewstypeModel("exploration"),
            NewstypeModel("stock market"),
            NewstypeModel("covid-19"),
            NewstypeModel("world cup"),
            NewstypeModel("entertainment"),
        )
        val newstype = ArrayList<NewstypeModel>()
        newstype.addAll(arrayofNewsType)
        newsTypeAdapter.updateItems(newstype)

        mviewmodel.getnews("tesla")
        mviewmodel.user.observe(this) {
            when (it) {
                is Response.loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                    Log.d("TAGGGGGGG", "onCreate: Loading")
                }

                is Response.success -> {
                    adapterclass.updateItems(it.data?.articles as ArrayList<Article>)
                    binding.progressBar.visibility = View.GONE
                    Log.d("TAGGGGGGG", "onCreate: success")

                }

                is Response.error -> {
                    binding.progressBar.visibility = View.GONE

                    Log.d("TAGGGGGGG", "onCreate: error")

                }

                else -> {
                    Log.d("TAGGGGGGG", "onCreate: else case")

                }
            }
        }
    }

    override fun onItemClick(model: Article, position: Int) {
        val builder = CustomTabsIntent.Builder()
        val customTabsIntent = builder.build()
        customTabsIntent.launchUrl(this@MainActivity, Uri.parse(model.url))
    }

    override fun onItemClick(model: NewstypeModel, position: Int) {
        val type = model.type
        mviewmodel.getnews(type)
        observeNews()

    }

    fun observeNews() {
        mviewmodel.user.observe(this) {

            when (it) {
                is Response.loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                    Log.d("TAGGGGGGG", "onCreate: Loading")
                }

                is Response.success -> {
                    adapterclass.updateItems(it.data?.articles as ArrayList<Article>)
                    binding.progressBar.visibility = View.GONE
                    Log.d("TAGGGGGGG", "onCreate: success")

                }

                is Response.error -> {
                    binding.progressBar.visibility = View.GONE

                    Log.d("TAGGGGGGG", "onCreate: error")

                }

                else -> {
                    Log.d("TAGGGGGGG", "onCreate: else case")

                }
            }
        }
    }
}