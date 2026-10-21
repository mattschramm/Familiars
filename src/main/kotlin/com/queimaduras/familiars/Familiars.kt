package com.queimaduras.familiars

import com.queimaduras.familiars.core.FamiliarsTab
import com.queimaduras.familiars.materials.Materials
import com.queimaduras.familiars.summoning.Summoning
import com.queimaduras.familiars.shared.FamiliarsRegisters
import net.neoforged.fml.common.Mod
import thedarkcolour.kotlinforforge.neoforge.forge.MOD_BUS
import java.util.logging.Level
import java.util.logging.Logger

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(Familiars.MODID)
object Familiars {
    // Define mod id in a common place for everything to reference
    const val MODID = "familiars"
    // Directly reference a slf4j logger
    val LOGGER: Logger = Logger.getLogger(MODID)

    // The init block of the mod object is the first code that is run when your mod is loaded.
    // Use thedarkcolour.kotlinforforge.neoforge.forge.MOD_BUS to reach the mod event bus from here.
    init {
        LOGGER.log(Level.FINE, "Initializing Familiars")

        FamiliarsTab.register(MOD_BUS)
        Materials.register(MOD_BUS)
        Summoning.register(MOD_BUS)
        FamiliarsRegisters.register(MOD_BUS)
    }
}
