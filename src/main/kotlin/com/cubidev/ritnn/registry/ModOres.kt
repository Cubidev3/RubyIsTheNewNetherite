package com.cubidev.ritnn.registry

import com.cubidev.ritnn.Ritnn
import net.fabricmc.fabric.api.biome.v1.BiomeModification
import net.fabricmc.fabric.api.biome.v1.BiomeModifications
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors
import net.minecraft.block.Block
import net.minecraft.util.Identifier
import net.minecraft.util.registry.BuiltinRegistries
import net.minecraft.util.registry.Registry
import net.minecraft.util.registry.RegistryEntry
import net.minecraft.util.registry.RegistryKey
import net.minecraft.world.gen.GenerationStep
import net.minecraft.world.gen.YOffset
import net.minecraft.world.gen.feature.ConfiguredFeature
import net.minecraft.world.gen.feature.Feature
import net.minecraft.world.gen.feature.FeatureConfig
import net.minecraft.world.gen.feature.OreConfiguredFeatures
import net.minecraft.world.gen.feature.OreFeatureConfig
import net.minecraft.world.gen.feature.PlacedFeature
import net.minecraft.world.gen.placementmodifier.CountPlacementModifier
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier

object ModOres {
    val OVERWORLD_RUBY_ORE_CONFIGURED_ORE = ConfiguredFeature(
        Feature.ORE,
        OreFeatureConfig(
            OreConfiguredFeatures.STONE_ORE_REPLACEABLES,
            ModBlocks.RUBY_ORE.defaultState,
            3
        )
    )

    val OVERWORLD_RUBY_ORE_PLACED_FEATURE = PlacedFeature(
        RegistryEntry.of(OVERWORLD_RUBY_ORE_CONFIGURED_ORE),
        arrayListOf(
            CountPlacementModifier.of(3),
            SquarePlacementModifier(),
            HeightRangePlacementModifier.uniform(YOffset.BOTTOM, YOffset.fixed(15))
        )
    )

    fun registerOres() {
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, Identifier(Ritnn.MOD_ID, "overworld_ruby_ore"), OVERWORLD_RUBY_ORE_CONFIGURED_ORE)
        Registry.register(BuiltinRegistries.PLACED_FEATURE, Identifier(Ritnn.MOD_ID, "overworld_ruby_ore"), OVERWORLD_RUBY_ORE_PLACED_FEATURE)
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, RegistryKey.of(
            Registry.PLACED_FEATURE_KEY,
            Identifier(Ritnn.MOD_ID, "overworld_ruby_ore")
        ))
    }
}