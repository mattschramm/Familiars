package com.queimaduras.familiars.materials

import com.queimaduras.familiars.core.FamiliarsTab
import com.queimaduras.familiars.shared.FamiliarsRegisters.BLOCKS
import com.queimaduras.familiars.shared.FamiliarsRegisters.ITEMS
import com.queimaduras.familiars.shared.blockAndItem
import net.minecraft.world.level.block.SoundType
import net.minecraft.world.level.material.MapColor
import net.neoforged.bus.api.IEventBus
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent

object Materials {
    val SALT = ITEMS.registerSimpleItem("salt")
    val MERCURY_BOTTLE = ITEMS.registerSimpleItem("mercury_bottle")
    val CRUSHED_SULFUR = ITEMS.registerSimpleItem("crushed_sulfur")
    val CRUSHED_CINNABAR = ITEMS.registerSimpleItem("crushed_cinnabar")

    val SALT_BLOCK = BLOCKS.blockAndItem(ITEMS, "salt_block") { it
        .destroyTime(0.5f)
        .sound(SoundType.SAND)
        .mapColor(MapColor.QUARTZ) }

    fun register(bus: IEventBus) {
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