package com.queimaduras.familiars.data

import net.minecraft.data.loot.LootTableProvider
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets
import net.neoforged.bus.api.SubscribeEvent
import net.neoforged.fml.common.EventBusSubscriber
import net.neoforged.neoforge.data.event.GatherDataEvent

@EventBusSubscriber
object FamiliarsDatagenEvents {
    @SubscribeEvent
    fun gatherData(event: GatherDataEvent.Client) {
        event.run {
            createProvider(::FamiliarsModelProvider)

            createProvider(::FamiliarsItemTagProvider)

            createProvider(::FamiliarsBlockTagProvider)

            createProvider { output, lookupProvider ->
                LootTableProvider(
                    output,
                    setOf(),
                    listOf(
                        LootTableProvider.SubProviderEntry(::FamiliarsBlockLootTableProvider, LootContextParamSets.BLOCK)
                    ),
                    lookupProvider
                )
            }

            createProvider { output, lookupProvider -> FamiliarsRecipeProvider.Runner(output, lookupProvider) }
        }
    }
}
