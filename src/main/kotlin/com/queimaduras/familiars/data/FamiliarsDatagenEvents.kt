package com.queimaduras.familiars.data

import net.neoforged.bus.api.SubscribeEvent
import net.neoforged.fml.common.EventBusSubscriber
import net.neoforged.neoforge.data.event.GatherDataEvent

@EventBusSubscriber
object FamiliarsDatagenEvents {
    @SubscribeEvent
    fun gatherData(event: GatherDataEvent.Client) {
        val generator = event.generator
        val packOutput = generator.packOutput

        generator.addProvider(true, FamiliarsModelProvider(packOutput))
    }
}