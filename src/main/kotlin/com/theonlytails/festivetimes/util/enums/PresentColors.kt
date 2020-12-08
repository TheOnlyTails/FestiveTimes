package com.theonlytails.festivetimes.util.enums

import net.minecraft.item.DyeColor
import net.minecraft.util.IStringSerializable

enum class PresentColors(private val dye: DyeColor) : IStringSerializable {
	WHITE(DyeColor.WHITE),
	ORANGE(DyeColor.ORANGE),
	MAGENTA(DyeColor.MAGENTA),
	LIGHT_BLUE(DyeColor.LIGHT_BLUE),
	YELLOW(DyeColor.YELLOW),
	LIME(DyeColor.LIME),
	PINK(DyeColor.PINK),
	GRAY(DyeColor.GRAY),
	LIGHT_GRAY(DyeColor.LIGHT_GRAY),
	CYAN(DyeColor.CYAN),
	PURPLE(DyeColor.PURPLE),
	BLUE(DyeColor.BLUE),
	BROWN(DyeColor.BROWN),
	GREEN(DyeColor.GREEN),
	RED(DyeColor.RED),
	BLACK(DyeColor.BLACK),
	;

	override fun getString(): String = this.dye.translationKey

	companion object {
		fun getColorFromDye(dye: DyeColor) = when (dye) {
			DyeColor.WHITE -> WHITE
			DyeColor.ORANGE -> ORANGE
			DyeColor.MAGENTA -> MAGENTA
			DyeColor.LIGHT_BLUE -> LIGHT_BLUE
			DyeColor.YELLOW -> YELLOW
			DyeColor.LIME -> LIME
			DyeColor.PINK -> PINK
			DyeColor.GRAY -> GRAY
			DyeColor.LIGHT_GRAY -> LIGHT_GRAY
			DyeColor.CYAN -> CYAN
			DyeColor.PURPLE -> PURPLE
			DyeColor.BLUE -> BLUE
			DyeColor.BROWN -> BROWN
			DyeColor.GREEN -> GREEN
			DyeColor.RED -> RED
			DyeColor.BLACK -> BLACK
		}
	}
}