package com.cubidev.ritnn.registry

import com.cubidev.ritnn.Ritnn
import net.minecraft.item.AxeItem
import net.minecraft.item.HoeItem
import net.minecraft.item.Item
import net.minecraft.item.ItemGroup
import net.minecraft.item.PickaxeItem
import net.minecraft.item.ShovelItem
import net.minecraft.item.SwordItem
import net.minecraft.item.ToolMaterial
import net.minecraft.recipe.Ingredient
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry

object ModTools {
    val rubyToolMaterial = RubyToolMaterial()

    val rubyPickaxeItem = RubyPickaxe(rubyToolMaterial, -4, -2.6f, Item.Settings().group(ItemGroup.TOOLS))
    val rubyAxeItem = RubyAxe(rubyToolMaterial, 2f, -2.8f, Item.Settings().group(ItemGroup.TOOLS))
    val rubyHoe = RubyHoe(rubyToolMaterial, -11, 1f, Item.Settings().group(ItemGroup.TOOLS))
    val rubyShovel = ShovelItem(rubyToolMaterial, -3.5f, -2.5f, Item.Settings().group(ItemGroup.TOOLS))
    val rubySword = SwordItem(rubyToolMaterial, 0, -2.2f, Item.Settings().group(ItemGroup.COMBAT))

    fun registerTools() {
        Registry.register(Registry.ITEM, Identifier(Ritnn.MOD_ID, "ruby_pickaxe"), rubyPickaxeItem)
        Registry.register(Registry.ITEM, Identifier(Ritnn.MOD_ID, "ruby_axe"), rubyAxeItem)
        Registry.register(Registry.ITEM, Identifier(Ritnn.MOD_ID, "ruby_hoe"), rubyHoe)
        Registry.register(Registry.ITEM, Identifier(Ritnn.MOD_ID, "ruby_shovel"), rubyShovel)
        Registry.register(Registry.ITEM, Identifier(Ritnn.MOD_ID, "ruby_sword"), rubySword)
    }
}

class RubyPickaxe : PickaxeItem {
    constructor(toolMaterial: ToolMaterial, attackDamage: Int, attackSpeed: Float, settings: Settings) : super(toolMaterial, attackDamage, attackSpeed, settings)
}

class RubyAxe: AxeItem {
    constructor(toolMaterial: ToolMaterial, attackDamage: Float, attackSpeed: Float, settings: Settings) : super(toolMaterial, attackDamage, attackSpeed, settings)
}

class RubyHoe : HoeItem {
    constructor(toolMaterial: ToolMaterial, attackDamage: Int, attackSpeed: Float, settings: Settings) : super(toolMaterial, attackDamage, attackSpeed, settings)
}

class RubyToolMaterial : ToolMaterial {
    val durabilityValue = 3750
    val enchantabilityValue = 32
    val miningSpeedValue = 18f
    val miningLevelValue = 4
    val attackDamageValue = 11f


    override fun getDurability(): Int = durabilityValue

    override fun getMiningSpeedMultiplier(): Float = miningSpeedValue

    override fun getAttackDamage(): Float = attackDamageValue

    override fun getMiningLevel(): Int = miningLevelValue

    override fun getEnchantability(): Int = enchantabilityValue

    override fun getRepairIngredient(): Ingredient = Ingredient.ofItems(ModItems.RUBY)

}