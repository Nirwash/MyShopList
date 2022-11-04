package com.nirwashh.android.myshoplist.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nirwashh.android.myshoplist.R
import com.nirwashh.android.myshoplist.databinding.ActivityShopItemBinding

class ShopItemActivity : AppCompatActivity() {
    private lateinit var binding: ActivityShopItemBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShopItemBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}