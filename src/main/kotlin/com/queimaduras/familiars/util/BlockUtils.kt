package com.queimaduras.familiars.util

import net.minecraft.world.item.BlockItem
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.state.BlockBehaviour
import net.neoforged.neoforge.registries.DeferredBlock
import net.neoforged.neoforge.registries.DeferredItem
import net.neoforged.neoforge.registries.DeferredRegister

data class BlockTuple(
    val block: DeferredBlock<Block>,
    val item: DeferredItem<BlockItem>,
)

fun DeferredRegister.Blocks.blockAndItem(
    items: DeferredRegister.Items,
    name: String,
    properties: (BlockBehaviour.Properties) -> BlockBehaviour.Properties = { it },
): BlockTuple {
    val block = registerSimpleBlock(name) { props -> properties(props) }
    val item = items.registerSimpleBlockItem(block)
    return BlockTuple(block, item)
}
