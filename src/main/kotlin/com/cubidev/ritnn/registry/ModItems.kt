package com.cubidev.ritnn.registry

import com.cubidev.ritnn.Ritnn
import net.minecraft.item.BlockItem
import net.minecraft.item.Item
import net.minecraft.item.ItemGroup
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry

object ModItems {
    val RUBY = Item(
        Item.Settings().group(ItemGroup.MATERIALS)
    )

    //Block Items
    val RUBY_BLOCK_ITEM = BlockItem(
        ModBlocks.RUBY_BLOCK,
        Item.Settings().group(ItemGroup.BUILDING_BLOCKS)
    )

    val RUBY_ORE_ITEM = BlockItem (
        ModBlocks.RUBY_ORE,
        Item.Settings().group(ItemGroup.BUILDING_BLOCKS)
    )

    fun registerItems() {
        Registry.register(Registry.ITEM, Identifier(Ritnn.MOD_ID, "ruby"), RUBY)
        Registry.register(Registry.ITEM, Identifier(Ritnn.MOD_ID, "ruby_block"), RUBY_BLOCK_ITEM)
        Registry.register(Registry.ITEM, Identifier(Ritnn.MOD_ID, "ruby_ore"), RUBY_ORE_ITEM)
    }
}