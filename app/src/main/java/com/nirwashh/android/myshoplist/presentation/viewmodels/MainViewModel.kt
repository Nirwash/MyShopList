package com.nirwashh.android.myshoplist.presentation.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.nirwashh.android.myshoplist.data.ShopListRepositoryImpl
import com.nirwashh.android.myshoplist.domain.DeleteShopItemUseCase
import com.nirwashh.android.myshoplist.domain.EditShopItemUseCase
import com.nirwashh.android.myshoplist.domain.GetShopListUseCase
import com.nirwashh.android.myshoplist.domain.ShopItem
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = ShopListRepositoryImpl(application)
    private val getShopListUseCase = GetShopListUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(repository)
    val shopList = getShopListUseCase.getShopList()


    fun changeEnableState(shopItem: ShopItem) {
        viewModelScope.launch {
            val newItem = shopItem.copy(enabled = !shopItem.enabled)
            editShopItemUseCase.editShopItem(newItem)
        }

    }

    fun deleteShopItem(shopItem: ShopItem) {
        viewModelScope.launch {
            deleteShopItemUseCase.deleteShopItem(shopItem)
        }
    }

}