package com.queimaduras.familiars.core

import com.queimaduras.familiars.Familiars
import net.minecraft.core.registries.Registries
import net.minecraft.network.chat.Component
import net.minecraft.world.item.CreativeModeTab
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.Items
import net.neoforged.bus.api.IEventBus
import net.neoforged.neoforge.registries.DeferredHolder
import net.neoforged.neoforge.registries.DeferredRegister
import java.util.function.Supplier

object FamiliarsTab {
    private val TABS: DeferredRegister<CreativeModeTab> =
        DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Familiars.MODID)

    val MAIN: DeferredHolder<CreativeModeTab, CreativeModeTab> = TABS.register("main", Supplier {
        CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.${Familiars.MODID}"))
            .icon { ItemStack(Items.BONE) }
            .build()
    })

    fun register(bus: IEventBus) {
        TABS.register(bus)
    }
}
