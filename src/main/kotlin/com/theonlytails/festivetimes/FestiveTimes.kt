package com.theonlytails.festivetimes;

import net.minecraftforge.fml.common.Mod
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import thedarkcolour.kotlinforforge.forge.FORGE_BUS

// The value here should match an entry in the META-INF/mods.toml file
@Mod("festivetimes")
object FestiveTimes {

    // Directly reference a log4j logger.
    val LOGGER: Logger = LogManager.getLogger();

    init {
        FORGE_BUS.register(this);
    }
}