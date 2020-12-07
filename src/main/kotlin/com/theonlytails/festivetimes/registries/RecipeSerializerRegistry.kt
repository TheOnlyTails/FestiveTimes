package com.theonlytails.festivetimes.registries

import com.theonlytails.festivetimes.FestiveTimes
import com.theonlytails.festivetimes.util.PresentRecipe
import com.theonlytails.festivetimes.util.WrappingPaperRecipe
import net.minecraft.item.crafting.IRecipeSerializer
import net.minecraft.item.crafting.SpecialRecipeSerializer
import net.minecraft.util.ResourceLocation
import net.minecraftforge.registries.ForgeRegistries
import thedarkcolour.kotlinforforge.forge.KDeferredRegister

object RecipeSerializerRegistry {
	val SERIALIZERS: KDeferredRegister<IRecipeSerializer<*>> =
		KDeferredRegister(ForgeRegistries.RECIPE_SERIALIZERS, FestiveTimes.MOD_ID)

	val PRESENT: SpecialRecipeSerializer<PresentRecipe> by SERIALIZERS.register("present_serializer") {
		SpecialRecipeSerializer { id: ResourceLocation -> PresentRecipe(id) }
	}

	val WRAPPING_PAPER: SpecialRecipeSerializer<WrappingPaperRecipe> by SERIALIZERS.register("wrapping_paper_serializer") {
		SpecialRecipeSerializer { id: ResourceLocation -> WrappingPaperRecipe(id) }
	}
}