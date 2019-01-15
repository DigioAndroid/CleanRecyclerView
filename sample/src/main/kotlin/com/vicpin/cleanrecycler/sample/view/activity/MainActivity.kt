package com.vicpin.cleanrecycler.sample.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import com.vicpin.cleanrecycler.sample.data.ItemCache
import com.vicpin.cleanrecycler.sample.data.ItemPagedService
import com.vicpin.cleanrecycler.sample.extensions.injector
import com.vicpin.cleanrecycler.sample.view.activity.DetailActivity
import com.vicpin.cleanrecycler.sample.view.adapter.AdapterItemView
import com.vicpin.cleanrecycler.view.CleanRecyclerView
import com.vicpin.cleanrecycler.view.SimpleCleanRecyclerView
import com.vicpin.cleanrecycler.sample.R
import com.vicpin.cleanrecycler.sample.model.Item
import com.vicpin.cleanrecycler.sample.model.Mapper

import com.vicpin.kpresenteradapter.SimplePresenterAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var paginated = true
    var menuItem : MenuItem? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injector.inject(this)
        setContentView(R.layout.activity_main)
        initPagedList()
    }

    fun initPagedList() {

        paginated = true
        menuItem?.title = getString(R.string.no_paginated)

        (list as? CleanRecyclerView<Item, Item>)?.let {
            val adapter = SimplePresenterAdapter(AdapterItemView::class, R.layout.adapter_item)

            it.loadPaged(adapter = adapter, cloud = ItemPagedService::class, cache = ItemCache::class, mapper = Mapper::class.java.newInstance(), customData = null)


            it.onItemClick { item, view -> DetailActivity.launchActivity(this, view.itemView.findViewById(R.id.header), item) }
        }

    }

    /*fun initNoPagedList() {

        paginated = false
        menuItem?.title = getString(R.string.paginated)

        val cleanRecyclerView = list as CleanRecyclerView<Item, Item>
        val adapter = SimplePresenterAdapter(AdapterItemView::class, R.layout.adapter_item)

        cleanRecyclerView.load(adapter, noPagedService, itemCache)

        cleanRecyclerView.onItemClick { item, view -> DetailActivity.launchActivity(this, view.itemView.findViewById(R.id.header), item) }
    }*/

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
       // menuInflater.inflate(R.menu.menu, menu)
      //  menuItem = menu?.findItem(R.id.paginated)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val cleanRecyclerView = list as SimpleCleanRecyclerView<Item>

        when(item?.itemId) {
            //R.id.paginated -> if(paginated) initNoPagedList() else initPagedList()
            R.id.vertical -> cleanRecyclerView.layoutManager = LinearLayoutManager(this)
            R.id.horizontal -> cleanRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
            R.id.grid -> cleanRecyclerView.layoutManager = GridLayoutManager(this, 2)
        }

        return true
    }

}