package com.nirwashh.android.myshoplist.data

import com.nirwashh.android.myshoplist.domain.ShopItem

class ShopListMapper {

    fun mapEntityToDbModel(shopItem: ShopItem) = ShopItemDbModel(
        id = shopItem.id,
        name = shopItem.name,
        count = shopItem.count,
        enabled = shopItem.enabled
    )

    fun mapDbModelToEntity(shopItemDbModelItem: ShopItemDbModel) = ShopItem(
        name = shopItemDbModelItem.name,
        count = shopItemDbModelItem.count,
        enabled = shopItemDbModelItem.enabled,
        id = shopItemDbModelItem.id
    )

    fun mapListDbModelToListEntity(list: List<ShopItemDbModel>) = list.map {
        mapDbModelToEntity(it)
    }
}
