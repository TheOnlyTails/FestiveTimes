package com.theonlytails.festivetimes.registries

import com.theonlytails.festivetimes.FestiveTimes
import com.theonlytails.festivetimes.FestiveTimes.DEFAULT_ITEM_PROPERTY
import com.theonlytails.festivetimes.items.CandyCaneItem
import net.minecraft.item.BlockItem
import net.minecraft.item.Item
import net.minecraftforge.registries.ForgeRegistries
import thedarkcolour.kotlinforforge.forge.KDeferredRegister

@Suppress("unused")
object ItemRegistry {
	val ITEMS = KDeferredRegister(ForgeRegistries.ITEMS, FestiveTimes.MOD_ID)

	val PRESENT_BLOCK by ITEMS.register("present") { BlockItem(BlockRegistry.PRESENT, DEFAULT_ITEM_PROPERTY) }

	val WRAPPING_PAPER by ITEMS.register("wrapping_paper") { Item(DEFAULT_ITEM_PROPERTY) }

	val CANDY_CANE by ITEMS.register("candy_cane") { CandyCaneItem() }
}