package com.teamabode.verdance;

import com.teamabode.verdance.platform.NeoForgeRegistryHelper;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod(Verdance.MOD_ID)
public class VerdanceNeoForge {

    public VerdanceNeoForge(IEventBus bus, ModContainer container) {
        Verdance.init();

        NeoForgeRegistryHelper.init(bus);

        bus.addListener(this::setup);

        // TODO: compostables, flammables, strippable blocks
    }

    private void setup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {

        });
    }
}