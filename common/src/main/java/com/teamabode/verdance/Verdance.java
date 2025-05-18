package com.teamabode.verdance;

import com.teamabode.verdance.registry.VerdanceBlocks;
import com.teamabode.verdance.registry.VerdanceEntityTypes;
import com.teamabode.verdance.registry.VerdanceItems;
import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Verdance {
    public static final String MOD_ID = "verdance";
    public static final String MOD_NAME = "Verdance";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);

    public static void init() {
        VerdanceItems.init();
        VerdanceBlocks.init();
        VerdanceEntityTypes.init();
    }

    public static ResourceLocation id(String name) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, name);
    }
}