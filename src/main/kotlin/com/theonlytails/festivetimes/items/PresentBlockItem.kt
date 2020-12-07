package com.theonlytails.festivetimes.items

import com.theonlytails.festivetimes.FestiveTimes
import com.theonlytails.festivetimes.registries.BlockRegistry
import com.theonlytails.festivetimes.util.enums.PresentColors
import net.minecraft.item.BlockItem
import net.minecraft.item.ItemStack

class PresentBlockItem : BlockItem(BlockRegistry.PRESENT, FestiveTimes.DEFAULT_ITEM_PROPERTY) {
	fun getColorFromStack(itemStack: ItemStack): PresentColors {
		val colorValue = itemStack.orCreateTag.getInt("Color")

		var result = PresentColors.RED

		for (color in PresentColors.values()) {
			if (PresentColors.getColorValue(color) == colorValue) {
				result = color
			}
		}

		return result
	}

	companion object {
		fun addColor(itemStack: ItemStack, color: PresentColors?) {
			itemStack.orCreateTag.putInt("Color", (color ?: PresentColors.RED).dye.colorValue)
		}
	}
}
