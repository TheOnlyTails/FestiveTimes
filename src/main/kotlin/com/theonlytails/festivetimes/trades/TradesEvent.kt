package com.theonlytails.festivetimes.trades

import com.theonlytails.festivetimes.registries.BlockRegistry
import com.theonlytails.festivetimes.registries.ItemRegistry
import net.minecraft.entity.merchant.villager.VillagerProfession
import net.minecraft.entity.merchant.villager.VillagerTrades
import net.minecraftforge.event.village.VillagerTradesEvent

object TradesEvent {
	fun addPresentTrade(event: VillagerTradesEvent) {
		if (event.type == VillagerProfession.NITWIT) {
			// Level 1
			event.trades[1].add(VillagerTrades.ItemsForEmeraldsAndItemsTrade(
				ItemRegistry.WRAPPING_PAPER,
				18,
				15,
				BlockRegistry.PRESENT.asItem(),
				1,
				2,
				13
			))
		}
	}
}