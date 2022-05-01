package com.cubidev.ritnn.registry

import com.cubidev.ritnn.Ritnn
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider
import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.fabricmc.fabric.impl.tag.convention.TagRegistration
import net.minecraft.block.Block
import net.minecraft.block.Material
import net.minecraft.sound.BlockSoundGroup
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry

object ModBlocks {
    val RUBY_BLOCK = Block(FabricBlockSettings
        .of(Material.METAL)
        .strength(5.0f, 6.0f)
        .requiresTool()
        .sounds(BlockSoundGroup.METAL)
    )

    val RUBY_ORE = Block(FabricBlockSettings
        .of(Material.STONE)
        .strength(3.0f, 4.0f)
        .requiresTool()
        .sounds(BlockSoundGroup.STONE)
    )

    val DEEPSLATE_RUBY_ORE = Block(FabricBlockSettings
        .of(Material.STONE)
        .strength(4.0f, 5.0f)
        .requiresTool()
        .sounds(BlockSoundGroup.DEEPSLATE)
    )

    fun registerBlocks() {
        Registry.register(Registry.BLOCK, Identifier(Ritnn.MOD_ID, "ruby_block"), RUBY_BLOCK)
        Registry.register(Registry.BLOCK, Identifier(Ritnn.MOD_ID, "ruby_ore"), RUBY_ORE)
        Registry.register(Registry.BLOCK, Identifier(Ritnn.MOD_ID, "deepslate_ruby_ore"), DEEPSLATE_RUBY_ORE)
    }
}