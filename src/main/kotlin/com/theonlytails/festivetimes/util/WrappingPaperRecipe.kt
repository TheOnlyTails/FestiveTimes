package com.theonlytails.festivetimes.util

import com.theonlytails.festivetimes.items.WrappingPaperItem
import com.theonlytails.festivetimes.registries.RecipeSerializerRegistry
import com.theonlytails.festivetimes.util.enums.PresentColors
import net.minecraft.inventory.CraftingInventory
import net.minecraft.item.DyeItem
import net.minecraft.item.Items
import net.minecraft.item.crafting.IRecipeSerializer
import net.minecraft.item.crafting.SpecialRecipe
import net.minecraft.util.ResourceLocation
import net.minecraft.world.World
import net.minecraft.item.ItemStack as IS

class WrappingPaperRecipe(id: ResourceLocation) : SpecialRecipe(id) {
	/**
	 * Used to check if a recipe matches current crafting inventory
	 */
	override fun matches(inv: CraftingInventory, worldIn: World) =
		if (this.canFit(inv.width, inv.height)) {
			inv.getStackInSlot(0).item == Items.PAPER &&
					inv.getStackInSlot(1).item == Items.PAPER &&
					inv.getStackInSlot(2).item == Items.PAPER &&
					inv.getStackInSlot(3).item == Items.PAPER &&
					inv.getStackInSlot(4).item is DyeItem &&
					inv.getStackInSlot(5).item == Items.PAPER &&
					inv.getStackInSlot(6).item == Items.PAPER &&
					inv.getStackInSlot(7).item == Items.PAPER &&
					inv.getStackInSlot(8).item == Items.PAPER
		} else {
			false
		}

	/**
	 * Returns an Item that is the result of this recipe
	 */
	override fun getCraftingResult(inv: CraftingInventory): IS {
		// Get item in middle slot
		val dye = (inv.getStackInSlot(4).item as DyeItem)
		val wrappingPaperItem = WrappingPaperItem()
		val result = IS(wrappingPaperItem)

		wrappingPaperItem.addColorToStack(result, PresentColors.getColorFromDye(dye.dyeColor))

		return result
	}

	/**
	 * Used to determine if this recipe can fit in a grid of the given width/height
	 */
	override fun canFit(width: Int, height: Int) = width >= 3 && height >= 3

	override fun getSerializer(): IRecipeSerializer<*> = RecipeSerializerRegistry.WRAPPING_PAPER
}
