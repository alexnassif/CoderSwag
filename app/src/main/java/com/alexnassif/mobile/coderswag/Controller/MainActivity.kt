package com.alexnassif.mobile.coderswag.Controller

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.SyncStateContract
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.ArrayAdapter
import com.alexnassif.mobile.coderswag.Adapters.CategoryAdapter
import com.alexnassif.mobile.coderswag.Adapters.CategoryRecycleAdapter
import com.alexnassif.mobile.coderswag.Model.Category
import com.alexnassif.mobile.coderswag.R
import com.alexnassif.mobile.coderswag.Services.DataService
import com.alexnassif.mobile.coderswag.Utilities.EXTRA_CATEGORY
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var adapter: CategoryRecycleAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = CategoryRecycleAdapter(this, DataService.categories){
            category ->  val productIntent = Intent(this, ProductsActivity::class.java)
            productIntent.putExtra(EXTRA_CATEGORY, category.title)
            startActivity(productIntent)
        }
        categoryListView.adapter = adapter

        val layoutManager = LinearLayoutManager(this)
        categoryListView.layoutManager = layoutManager
        categoryListView.setHasFixedSize(true)
    }
}
