package com.theonlytails.festivetimes.items

import com.theonlytails.festivetimes.FestiveTimes
import com.theonlytails.festivetimes.util.enums.PresentColors
import net.minecraft.item.Item
import net.minecraft.item.ItemStack

class WrappingPaperItem : Item(FestiveTimes.DEFAULT_ITEM_PROPERTY) {
	fun addColorToStack(itemStack: ItemStack, color: PresentColors) {
		itemStack.orCreateTag.putInt("Color", color.dye.colorValue)
	}

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
}