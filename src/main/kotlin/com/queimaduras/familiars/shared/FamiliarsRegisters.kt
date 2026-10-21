package com.queimaduras.familiars.shared

import com.queimaduras.familiars.Familiars
import net.neoforged.bus.api.IEventBus
import net.neoforged.neoforge.registries.DeferredRegister

object FamiliarsRegisters {
    val ITEMS: DeferredRegister.Items = DeferredRegister.createItems(Familiars.MODID)
    val BLOCKS: DeferredRegister.Blocks = DeferredRegister.createBlocks(Familiars.MODID)

    fun register(bus: IEventBus) {
        ITEMS.register(bus)
        BLOCKS.register(bus)
    }
}
