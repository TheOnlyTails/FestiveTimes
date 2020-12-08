package com.theonlytails.festivetimes.registries

import com.theonlytails.festivetimes.FestiveTimes
import com.theonlytails.festivetimes.FestiveTimes.DEFAULT_ITEM_PROPERTY
import net.minecraft.item.BlockItem
import net.minecraft.item.Item
import net.minecraftforge.registries.ForgeRegistries
import thedarkcolour.kotlinforforge.forge.KDeferredRegister

object ItemRegistry {
	val ITEMS = KDeferredRegister(ForgeRegistries.ITEMS, FestiveTimes.MOD_ID)

	val PRESENT_BLOCK by ITEMS.register("present") { BlockItem(BlockRegistry.PRESENT, DEFAULT_ITEM_PROPERTY) }

	val WRAPPING_PAPER by ITEMS.register("wrapping_paper") { Item(DEFAULT_ITEM_PROPERTY) }
}