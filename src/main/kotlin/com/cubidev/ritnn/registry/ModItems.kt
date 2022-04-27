package com.cubidev.ritnn.registry

import com.cubidev.ritnn.Ritnn
import net.minecraft.item.Item
import net.minecraft.item.ItemGroup
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry

object ModItems {
    val RUBY = Item(
        Item.Settings().group(ItemGroup.MATERIALS)
    )

    fun registerItems() {
        Registry.register(Registry.ITEM, Identifier(Ritnn.MOD_ID, "ruby"), RUBY)
    }
}