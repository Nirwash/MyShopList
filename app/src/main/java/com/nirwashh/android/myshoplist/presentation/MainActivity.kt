package com.nirwashh.android.myshoplist.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.nirwashh.android.myshoplist.R
import com.nirwashh.android.myshoplist.databinding.ActivityMainBinding
import com.nirwashh.android.myshoplist.domain.ShopItem

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.shopList.observe(this) {
            showList(it)
        }
    }

    private fun showList(list: List<ShopItem>) {
        val linearlayout = binding.list
        linearlayout.removeAllViews()
        for (shopItem in list) {
            val layoutId = if (shopItem.enabled)
                R.layout.item_shop_enabled
            else
                R.layout.item_shop_disabled

            val view = LayoutInflater.from(this).inflate(layoutId, linearlayout, false)
            val tvName = view.findViewById<TextView>(R.id.tvName)
            val tvCount = view.findViewById<TextView>(R.id.tvCount)
            tvName.text = shopItem.name
            tvCount.text = shopItem.count.toString()
            view.setOnLongClickListener {
                viewModel.changeEnableState(shopItem)
                true
            }
            linearlayout.addView(view)
        }
    }
}