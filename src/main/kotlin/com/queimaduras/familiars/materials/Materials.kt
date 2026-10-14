package com.queimaduras.familiars.materials

import com.queimaduras.familiars.Familiars
import com.queimaduras.familiars.core.FamiliarsTab
import com.queimaduras.familiars.util.blockAndItem
import net.minecraft.world.level.block.SoundType
import net.minecraft.world.level.material.MapColor
import net.neoforged.bus.api.IEventBus
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent
import net.neoforged.neoforge.registries.DeferredRegister

object Materials {
    private val ITEMS = DeferredRegister.createItems(Familiars.MODID)
    private val BLOCKS = DeferredRegister.createBlocks(Familiars.MODID)

    val SALT = ITEMS.registerSimpleItem("salt")
    val MERCURY_BOTTLE = ITEMS.registerSimpleItem("mercury_bottle")
    val CRUSHED_SULFUR = ITEMS.registerSimpleItem("crushed_sulfur")
    val CRUSHED_CINNABAR = ITEMS.registerSimpleItem("crushed_cinnabar")

    val SALT_BLOCK = BLOCKS.blockAndItem(ITEMS, "salt_block") { it
        .destroyTime(1.5f)
        .sound(SoundType.SAND)
        .mapColor(MapColor.QUARTZ) }

    fun register(bus: IEventBus) {
        ITEMS.register(bus)
        BLOCKS.register(bus)
        bus.addListener(::addToTab)
    }

    private fun addToTab(event: BuildCreativeModeTabContentsEvent) {
        if (event.tabKey == FamiliarsTab.MAIN.key) {
            event.accept(SALT)
            event.accept(MERCURY_BOTTLE)
            event.accept(CRUSHED_SULFUR)
            event.accept(CRUSHED_CINNABAR)
            event.accept(SALT_BLOCK.item)
        }
    }
}