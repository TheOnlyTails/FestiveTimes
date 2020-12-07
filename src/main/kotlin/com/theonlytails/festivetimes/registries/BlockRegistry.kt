package com.theonlytails.festivetimes.registries

import com.theonlytails.festivetimes.FestiveTimes
import com.theonlytails.festivetimes.blocks.PresentBlock
import net.minecraftforge.registries.ForgeRegistries
import thedarkcolour.kotlinforforge.forge.KDeferredRegister

object BlockRegistry {
	val BLOCKS = KDeferredRegister(ForgeRegistries.BLOCKS, FestiveTimes.MOD_ID)

	val PRESENT by BLOCKS.register("present") { PresentBlock() }
}