package com.queimaduras.familiars.materials

import com.queimaduras.familiars.Familiars
import com.queimaduras.familiars.core.FamiliarsTab
import com.queimaduras.familiars.summoning.Summoning
import net.neoforged.bus.api.IEventBus
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent
import net.neoforged.neoforge.registries.DeferredRegister

object Materials {
    private val ITEMS = DeferredRegister.createItems(Familiars.MODID)

    val SALT = ITEMS.registerSimpleItem("salt")

    fun register(bus: IEventBus) {
        ITEMS.register(bus)
        bus.addListener(::addToTab)
    }

    private fun addToTab(event: BuildCreativeModeTabContentsEvent) {
        if (event.tabKey == FamiliarsTab.MAIN.key) {
            event.accept(SALT)
        }
    }
}