package com.theonlytails.festivetimes

import com.theonlytails.festivetimes.FestiveTimes.MOD_ID
import com.theonlytails.festivetimes.items.PresentBlockItem
import com.theonlytails.festivetimes.items.WrappingPaperItem
import com.theonlytails.festivetimes.registries.BlockRegistry
import com.theonlytails.festivetimes.registries.ItemRegistry
import com.theonlytails.festivetimes.registries.RecipeSerializerRegistry
import com.theonlytails.festivetimes.util.enums.PresentColors
import net.minecraft.item.*
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent
import thedarkcolour.kotlinforforge.forge.FORGE_BUS
import thedarkcolour.kotlinforforge.forge.MOD_BUS
import net.minecraft.util.ResourceLocation as RL

// The value here should match an entry in the META-INF/mods.toml file
@Mod(MOD_ID)
object FestiveTimes {
	const val MOD_ID = "festive_times"

	private val FESTIVE_TIMES_TAB: ItemGroup = object : ItemGroup("festive_times_tab") {
		override fun createIcon(): ItemStack = ItemStack(BlockRegistry.PRESENT)
	}

	val DEFAULT_ITEM_PROPERTY: Item.Properties = Item.Properties().group(FESTIVE_TIMES_TAB)

	init {
		FORGE_BUS.register(this)
		FORGE_BUS.addListener(::clientSetup)

		BlockRegistry.BLOCKS.register(MOD_BUS)
		ItemRegistry.ITEMS.register(MOD_BUS)
		RecipeSerializerRegistry.SERIALIZERS.register(MOD_BUS)
	}

	private fun clientSetup(event: FMLClientSetupEvent) {
		event.enqueueWork {
			ItemModelsProperties.registerProperty(ItemRegistry.WRAPPING_PAPER, RL(MOD_ID, "color")) { stack, _, _ ->
				val wrappingPaper = stack.item as WrappingPaperItem

				when (wrappingPaper.getColorFromStack(stack)) {
					PresentColors.WHITE -> 1f
					PresentColors.ORANGE -> 2f
					PresentColors.MAGENTA -> 3f
					PresentColors.LIGHT_BLUE -> 4f
					PresentColors.YELLOW -> 5f
					PresentColors.LIME -> 6f
					PresentColors.PINK -> 7f
					PresentColors.GRAY -> 8f
					PresentColors.LIGHT_GRAY -> 9f
					PresentColors.CYAN -> 10f
					PresentColors.PURPLE -> 11f
					PresentColors.BLUE -> 12f
					PresentColors.BROWN -> 13f
					PresentColors.GREEN -> 14f
					PresentColors.RED -> 15f
					PresentColors.BLACK -> 16f
				}
			}
		}

		ItemModelsProperties.registerProperty(ItemRegistry.PRESENT_BLOCK, RL(MOD_ID, "color")) { stack, _, _ ->
			val presentBlockItem = stack.item as PresentBlockItem

			when (presentBlockItem.getColorFromStack(stack)) {
				PresentColors.WHITE -> 1f
				PresentColors.ORANGE -> 2f
				PresentColors.MAGENTA -> 3f
				PresentColors.LIGHT_BLUE -> 4f
				PresentColors.YELLOW -> 5f
				PresentColors.LIME -> 6f
				PresentColors.PINK -> 7f
				PresentColors.GRAY -> 8f
				PresentColors.LIGHT_GRAY -> 9f
				PresentColors.CYAN -> 10f
				PresentColors.PURPLE -> 11f
				PresentColors.BLUE -> 12f
				PresentColors.BROWN -> 13f
				PresentColors.GREEN -> 14f
				PresentColors.RED -> 15f
				PresentColors.BLACK -> 16f
			}
		}
	}
}