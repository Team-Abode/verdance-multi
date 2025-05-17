package com.teamabode.verdance;

import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Verdance {
    public static final String MOD_ID = "verdance";
    public static final String MOD_NAME = "Verdance";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);

    public static void init() {

    }

    public static ResourceLocation id(String name) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, name);
    }
}