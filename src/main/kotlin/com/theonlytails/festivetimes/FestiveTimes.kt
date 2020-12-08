package com.theonlytails.festivetimes

import com.theonlytails.festivetimes.FestiveTimes.MOD_ID
import com.theonlytails.festivetimes.registries.BlockRegistry
import com.theonlytails.festivetimes.registries.ItemRegistry
import net.minecraft.item.Item
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import net.minecraftforge.fml.common.Mod
import thedarkcolour.kotlinforforge.forge.FORGE_BUS
import thedarkcolour.kotlinforforge.forge.MOD_BUS

@Mod(MOD_ID)
object FestiveTimes {
	const val MOD_ID = "festive_times"

	private val FESTIVE_TIMES_TAB: ItemGroup = object : ItemGroup("festive_times_tab") {
		override fun createIcon(): ItemStack = ItemStack(BlockRegistry.PRESENT)
	}

	val DEFAULT_ITEM_PROPERTY: Item.Properties = Item.Properties().group(FESTIVE_TIMES_TAB)

	init {
		FORGE_BUS.register(this)

		BlockRegistry.BLOCKS.register(MOD_BUS)
		ItemRegistry.ITEMS.register(MOD_BUS)
	}
}