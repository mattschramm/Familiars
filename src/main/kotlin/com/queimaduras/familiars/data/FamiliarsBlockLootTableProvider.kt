package com.queimaduras.familiars.data

import com.queimaduras.familiars.materials.Materials
import com.queimaduras.familiars.shared.FamiliarsRegisters
import net.minecraft.core.HolderLookup
import net.minecraft.data.loot.BlockLootSubProvider
import net.minecraft.world.flag.FeatureFlags
import net.minecraft.world.level.block.Block

class FamiliarsBlockLootTableProvider(registries: HolderLookup.Provider)
    : BlockLootSubProvider(
    setOf(),
    FeatureFlags.REGISTRY.allFlags(),
        registries
    ) {

    override fun generate() {
        dropSelf(Materials.SALT_BLOCK.block.get())
    }

    override fun getKnownBlocks(): Iterable<Block> = FamiliarsRegisters.BLOCKS.entries.map { it.value() }
}