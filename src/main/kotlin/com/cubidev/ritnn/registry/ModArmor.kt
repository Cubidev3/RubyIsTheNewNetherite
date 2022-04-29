package com.cubidev.ritnn.registry

import com.cubidev.ritnn.Ritnn
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry
import net.minecraft.entity.EquipmentSlot
import net.minecraft.item.ArmorItem
import net.minecraft.item.ArmorMaterial
import net.minecraft.item.Item
import net.minecraft.item.ItemGroup
import net.minecraft.recipe.Ingredient
import net.minecraft.sound.SoundEvent
import net.minecraft.sound.SoundEvents

object ModArmor {
    val RubyArmorMaterial = RubyArmorMaterial()

    val RubyMaterialHelmet = ArmorItem(RubyArmorMaterial, EquipmentSlot.HEAD, Item.Settings().group(ItemGroup.COMBAT))
    val RubyMaterialChestplate = ArmorItem(RubyArmorMaterial, EquipmentSlot.CHEST, Item.Settings().group(ItemGroup.COMBAT))
    val RubyMaterialLeggings = ArmorItem(RubyArmorMaterial, EquipmentSlot.LEGS, Item.Settings().group(ItemGroup.COMBAT))
    val RubyMaterialBoots = ArmorItem(RubyArmorMaterial, EquipmentSlot.FEET, Item.Settings().group(ItemGroup.COMBAT))

    fun registerArmors() {
        Registry.register(Registry.ITEM, Identifier(Ritnn.MOD_ID, "ruby_helmet"), RubyMaterialHelmet)
        Registry.register(Registry.ITEM, Identifier(Ritnn.MOD_ID, "ruby_chestplate"), RubyMaterialChestplate)
        Registry.register(Registry.ITEM, Identifier(Ritnn.MOD_ID, "ruby_leggings"), RubyMaterialLeggings)
        Registry.register(Registry.ITEM, Identifier(Ritnn.MOD_ID, "ruby_boots"), RubyMaterialBoots)
    }
}

class RubyArmorMaterial : ArmorMaterial {
    private val KNOCKBACK_RESISTENCE_VALUE = 4f
    private val TOUGHNESS_VALUE = 6f
    private val ENCHANTABILITY_VALUE = 30
    private val DURABILITY_MULTIPLIER = 35
    private val BASE_DURABILITY = intArrayOf(13,15,16,11)
    private val PROTECTION_VALUES = intArrayOf(3,8,6,3)

    override fun getDurability(slot: EquipmentSlot?): Int {
        if (slot != null) {
            return BASE_DURABILITY[slot.entitySlotId] * DURABILITY_MULTIPLIER
        }
        return 0
    }

    override fun getProtectionAmount(slot: EquipmentSlot?): Int {
        if (slot != null) {
            return PROTECTION_VALUES[slot.entitySlotId]
        }
        return 0
    }

    override fun getEnchantability(): Int = ENCHANTABILITY_VALUE

    override fun getEquipSound(): SoundEvent = SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND

    override fun getRepairIngredient(): Ingredient = Ingredient.ofItems(ModItems.RUBY)

    override fun getName(): String = "ruby"

    override fun getToughness(): Float = TOUGHNESS_VALUE

    override fun getKnockbackResistance(): Float = KNOCKBACK_RESISTENCE_VALUE
}