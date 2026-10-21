package com.queimaduras.familiars.data

import com.queimaduras.familiars.Familiars
import com.queimaduras.familiars.materials.Materials
import net.minecraft.core.HolderLookup
import net.minecraft.data.PackOutput
import net.neoforged.neoforge.common.Tags
import net.neoforged.neoforge.common.data.ItemTagsProvider
import java.util.concurrent.CompletableFuture

class FamiliarsItemTagProvider(
    output: PackOutput,
    lookupProvider: CompletableFuture<HolderLookup.Provider>
) : ItemTagsProvider(output, lookupProvider, Familiars.MODID) {
    override fun addTags(provider: HolderLookup.Provider) {
        tag(ModTags.ITEMS.DUSTS_SALT).add(Materials.SALT.key)
        tag(Tags.Items.DUSTS).addTag(ModTags.ITEMS.DUSTS_SALT)

        tag(ModTags.ITEMS.STORAGE_BLOCKS_SALT).add(Materials.SALT_BLOCK.item.key)
        tag(Tags.Items.STORAGE_BLOCKS).addTag(ModTags.ITEMS.STORAGE_BLOCKS_SALT)

        tag(ModTags.ITEMS.RITUAL_MATERIALS)
            .addTag(ModTags.ITEMS.DUSTS_SALT)
            .add(Materials.MERCURY_BOTTLE.key)
            .add(Materials.CRUSHED_SULFUR.key)
            .add(Materials.CRUSHED_CINNABAR.key)
    }
}
