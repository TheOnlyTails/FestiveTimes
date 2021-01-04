package com.theonlytails.festivetimes.blocks

import com.theonlytails.festivetimes.util.enums.PresentColors
import net.minecraft.block.*
import net.minecraft.block.material.Material
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.inventory.InventoryHelper
import net.minecraft.item.BlockItemUseContext
import net.minecraft.item.DyeItem
import net.minecraft.item.Items
import net.minecraft.particles.ParticleTypes
import net.minecraft.state.EnumProperty
import net.minecraft.state.StateContainer
import net.minecraft.util.ActionResultType
import net.minecraft.util.Hand
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.BlockRayTraceResult
import net.minecraft.world.World
import java.util.Random
import net.minecraft.item.ItemStack as IS

class PresentBlock : Block(Properties.create(Material.WOOL)
	.hardnessAndResistance(1f)
	.sound(SoundType.CLOTH)
) {
	private val possiblePresents = hashMapOf(
		Items.COAL to 1..15,
		Items.DIAMOND to 1..2,
		Items.DIAMOND_ORE to 1..1,
		Items.EMERALD_ORE to 1..5,
		Items.STICK to 1..20,
		Items.IRON_INGOT to 1..6,
		Items.EMERALD to 1..10,
		Items.LAPIS_LAZULI to 1..12,
		Items.GOLD_INGOT to 1..9,
		Items.GOLD_NUGGET to 1..13,
		Items.GOLDEN_APPLE to 1..2,
	)

	init {
		this.defaultState = this.stateContainer.baseState
			.with(COLOR, PresentColors.RED)
	}

	override fun onBlockActivated(
		state: BlockState,
		worldIn: World,
		pos: BlockPos,
		player: PlayerEntity,
		handIn: Hand,
		hit: BlockRayTraceResult,
	): ActionResultType {
		val activeItem = player.getHeldItem(handIn).item
		if (activeItem is DyeItem) {
			worldIn.setBlockState(pos, state.with(COLOR, PresentColors.getColorFromDye(activeItem.dyeColor)))
		} else {
			val item = possiblePresents.keys.random()
			val presentStack = IS(item, possiblePresents[item]?.random() ?: 1)

			InventoryHelper.spawnItemStack(worldIn, pos.x.toDouble(), pos.y.toDouble(), pos.z.toDouble(), presentStack)

			worldIn.setBlockState(pos, Blocks.AIR.defaultState)
		}

		return ActionResultType.SUCCESS
	}

	/**
	 * Called periodically clientside on blocks near the player to show effects (like furnace fire particles). Note that
	 * this method is unrelated to [randomTick] and [.needsRandomTick], and will always be called regardless
	 * of whether the block can receive random update ticks
	 */
	override fun animateTick(stateIn: BlockState, worldIn: World, pos: BlockPos, rand: Random) {
		worldIn.addParticle(
			ParticleTypes.TOTEM_OF_UNDYING,
			pos.x.toDouble(),
			pos.up(2).y.toDouble(),
			pos.z.toDouble(),
			0.1,
			0.1,
			0.1
		)
	}

	override fun getStateForPlacement(context: BlockItemUseContext): BlockState = this.defaultState.with(COLOR,
		PresentColors.RED)

	override fun getComparatorInputOverride(blockState: BlockState, worldIn: World, pos: BlockPos) = 15

	override fun hasComparatorInputOverride(state: BlockState) = true

	override fun fillStateContainer(builder: StateContainer.Builder<Block, BlockState>) {
		builder.add(COLOR)
	}

	companion object {
		val COLOR: EnumProperty<PresentColors> = EnumProperty.create("color", PresentColors::class.java)
	}
}