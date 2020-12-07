package com.theonlytails.festivetimes.util

import com.theonlytails.festivetimes.items.PresentBlockItem
import com.theonlytails.festivetimes.items.WrappingPaperItem
import com.theonlytails.festivetimes.registries.ItemRegistry
import com.theonlytails.festivetimes.registries.RecipeSerializerRegistry
import net.minecraft.inventory.CraftingInventory
import net.minecraft.item.Items
import net.minecraft.item.crafting.IRecipeSerializer
import net.minecraft.item.crafting.SpecialRecipe
import net.minecraft.util.ResourceLocation
import net.minecraft.world.World
import net.minecraft.item.ItemStack as IS

class PresentRecipe(id: ResourceLocation) : SpecialRecipe(id) {
	/**
	 * Used to check if a recipe matches current crafting inventory
	 */
	override fun matches(inv: CraftingInventory, worldIn: World) =
		if (this.canFit(inv.width, inv.height)) {
			inv.getStackInSlot(0).item == ItemRegistry.WRAPPING_PAPER &&
					inv.getStackInSlot(1).item == ItemRegistry.WRAPPING_PAPER &&
					inv.getStackInSlot(2).item == ItemRegistry.WRAPPING_PAPER &&
					inv.getStackInSlot(3).item == ItemRegistry.WRAPPING_PAPER &&
					inv.getStackInSlot(4).item == Items.DIAMOND &&
					inv.getStackInSlot(5).item == ItemRegistry.WRAPPING_PAPER &&
					inv.getStackInSlot(6).item == ItemRegistry.WRAPPING_PAPER &&
					inv.getStackInSlot(7).item == ItemRegistry.WRAPPING_PAPER &&
					inv.getStackInSlot(8).item == ItemRegistry.WRAPPING_PAPER
		} else {
			false
		}

	/**
	 * Returns an Item that is the result of this recipe
	 */
	override fun getCraftingResult(inv: CraftingInventory): IS {
		val result = IS(PresentBlockItem())
		val item = inv.getStackInSlot(0).item ?: WrappingPaperItem()

		if (item is WrappingPaperItem)
			item.addColorToStack(result, item.getColorFromStack(IS(item)))

		return result
	}

	/**
	 * Used to determine if this recipe can fit in a grid of the given width/height
	 */
	override fun canFit(width: Int, height: Int) = width >= 3 && height >= 3

	override fun getSerializer(): IRecipeSerializer<*> = RecipeSerializerRegistry.PRESENT
}