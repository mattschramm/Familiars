package com.queimaduras.familiars.data

import com.queimaduras.familiars.materials.Materials
import net.minecraft.core.HolderLookup
import net.minecraft.data.PackOutput
import net.minecraft.data.recipes.RecipeCategory
import net.minecraft.data.recipes.RecipeOutput
import net.minecraft.data.recipes.RecipeProvider
import java.util.concurrent.CompletableFuture

class FamiliarsRecipeProvider(registries: HolderLookup.Provider, output: RecipeOutput) : RecipeProvider(registries, output) {
    class Runner(packOutput: PackOutput, registries: CompletableFuture<HolderLookup.Provider>) :
        RecipeProvider.Runner(packOutput, registries) {

        override fun createRecipeProvider(provider: HolderLookup.Provider, output: RecipeOutput) =
            FamiliarsRecipeProvider(provider, output)

        override fun getName() = "Familiars Recipes"

    }

    override fun buildRecipes() {
        shaped(RecipeCategory.MISC, Materials.SALT_BLOCK.block)
            .pattern("AAA")
            .pattern("AAA")
            .pattern("AAA")
            .define('A', Materials.SALT)
            .unlockedBy(getHasName(Materials.SALT), has(Materials.SALT))
            .group("ritual_materials")
            .save(output)

        shapeless(RecipeCategory.MISC, Materials.SALT, 9)
            .requires(Materials.SALT_BLOCK.block)
            .unlockedBy(getHasName(Materials.SALT_BLOCK.block), has(Materials.SALT_BLOCK.block))
            .group("ritual_materials")
            .save(output)
    }
}