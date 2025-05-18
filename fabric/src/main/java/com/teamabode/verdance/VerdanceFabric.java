package com.teamabode.verdance;

import com.teamabode.verdance.registry.VerdanceBlocks;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;

public class VerdanceFabric implements ModInitializer {
    
    @Override
    public void onInitialize() {
        Verdance.init();

        FlammableBlockRegistry.getDefaultInstance().add(VerdanceBlocks.MULBERRY_LOG.get(), 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(VerdanceBlocks.MULBERRY_WOOD.get(), 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(VerdanceBlocks.STRIPPED_MULBERRY_LOG.get(), 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(VerdanceBlocks.STRIPPED_MULBERRY_WOOD.get(), 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(VerdanceBlocks.MULBERRY_PLANKS.get(), 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(VerdanceBlocks.MULBERRY_STAIRS.get(), 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(VerdanceBlocks.MULBERRY_SLAB.get(), 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(VerdanceBlocks.MULBERRY_FENCE.get(), 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(VerdanceBlocks.MULBERRY_FENCE_GATE.get(), 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(VerdanceBlocks.MULBERRY_LEAVES.get(), 30, 60);
        StrippableBlockRegistry.register(VerdanceBlocks.MULBERRY_LOG.get(), VerdanceBlocks.STRIPPED_MULBERRY_LOG.get());
        StrippableBlockRegistry.register(VerdanceBlocks.MULBERRY_WOOD.get(), VerdanceBlocks.STRIPPED_MULBERRY_WOOD.get());
    }
}
