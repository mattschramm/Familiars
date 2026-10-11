package com.queimaduras.familiars.data

import com.queimaduras.familiars.Familiars
import com.queimaduras.familiars.materials.Materials
import com.queimaduras.familiars.summoning.Summoning
import net.minecraft.client.data.models.BlockModelGenerators
import net.minecraft.client.data.models.ItemModelGenerators
import net.minecraft.client.data.models.ModelProvider
import net.minecraft.client.data.models.model.ModelTemplates
import net.minecraft.data.PackOutput

class FamiliarsModelProvider(output: PackOutput) : ModelProvider(output, Familiars.MODID) {
    override fun registerModels(blockModels: BlockModelGenerators, itemModels: ItemModelGenerators) {
        itemModels.generateFlatItem(Materials.SALT.get(), ModelTemplates.FLAT_ITEM)
    }
}