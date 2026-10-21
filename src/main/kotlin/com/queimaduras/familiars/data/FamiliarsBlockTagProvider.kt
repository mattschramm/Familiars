package com.queimaduras.familiars.data

import com.queimaduras.familiars.Familiars
import com.queimaduras.familiars.materials.Materials
import net.minecraft.core.HolderLookup
import net.minecraft.data.PackOutput
import net.neoforged.neoforge.common.Tags
import net.neoforged.neoforge.common.data.BlockTagsProvider
import java.util.concurrent.CompletableFuture

class FamiliarsBlockTagProvider(
    output: PackOutput,
    lookupProvider: CompletableFuture<HolderLookup.Provider>
) : BlockTagsProvider(output, lookupProvider, Familiars.MODID) {

    override fun addTags(provider: HolderLookup.Provider) {
        tag(ModTags.BLOCKS.STORAGE_BLOCKS_SALT).add(Materials.SALT_BLOCK.block.key)
        tag(Tags.Blocks.STORAGE_BLOCKS).addTag(ModTags.BLOCKS.STORAGE_BLOCKS_SALT)
    }
}