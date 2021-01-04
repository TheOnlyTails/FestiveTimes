package com.theonlytails.festivetimes.items

import com.theonlytails.festivetimes.FestiveTimes
import com.theonlytails.festivetimes.util.enums.effect
import net.minecraft.item.Food
import net.minecraft.item.ItemTier
import net.minecraft.item.SwordItem
import net.minecraft.potion.EffectInstance
import net.minecraft.potion.Effects

class CandyCaneItem : SwordItem(
	ItemTier.IRON,
	3,
	-2.2f,
	FestiveTimes.DEFAULT_ITEM_PROPERTY.food(
		Food.Builder()
			.fastToEat()
			.effect(probability = 0.95f) {
				EffectInstance(Effects.REGENERATION, 10 * 20, 1, true, true)
			}
			.saturation(1.3f)
			.build()
	)
)