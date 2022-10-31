package com.nirwashh.android.myshoplist.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.nirwashh.android.myshoplist.databinding.ActivityMainBinding
import com.nirwashh.android.myshoplist.presentation.ShopListAdapter.Companion.MAX_POOL_SIZE
import com.nirwashh.android.myshoplist.presentation.ShopListAdapter.Companion.VIEW_TYPE_DISABLED
import com.nirwashh.android.myshoplist.presentation.ShopListAdapter.Companion.VIEW_TYPE_ENABLED

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: ShopListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.shopList.observe(this) {
            adapter.shopList = it
        }
    }

    private fun setupRecyclerView() {
        adapter = ShopListAdapter()
        with(binding.rcViewShopList) {
            adapter = adapter
            recycledViewPool.setMaxRecycledViews(VIEW_TYPE_ENABLED, MAX_POOL_SIZE)
            recycledViewPool.setMaxRecycledViews(VIEW_TYPE_DISABLED, MAX_POOL_SIZE)

        }
    }


}