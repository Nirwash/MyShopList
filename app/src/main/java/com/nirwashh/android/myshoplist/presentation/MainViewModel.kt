package com.nirwashh.android.myshoplist.presentation

import androidx.lifecycle.ViewModel
import com.nirwashh.android.myshoplist.data.ShopListRepositoryImpl
import com.nirwashh.android.myshoplist.domain.DeleteShopItemUseCase
import com.nirwashh.android.myshoplist.domain.EditShopItemUseCase
import com.nirwashh.android.myshoplist.domain.GetShopListUseCase
import com.nirwashh.android.myshoplist.domain.ShopItem

class MainViewModel : ViewModel() {

    private val repository = ShopListRepositoryImpl
    private val getShopListUseCase = GetShopListUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(repository)
    val shopList = getShopListUseCase.getShopList()


    fun changeEnableState(shopItem: ShopItem) {
        val newItem = shopItem.copy(enabled = !shopItem.enabled)
        editShopItemUseCase.editShopItem(newItem)
    }

    fun deleteShopItem(shopItem: ShopItem) {
        deleteShopItemUseCase.deleteShopItem(shopItem)
    }
}