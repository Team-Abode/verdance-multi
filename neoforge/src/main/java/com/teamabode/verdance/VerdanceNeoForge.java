package com.teamabode.verdance;

import com.teamabode.verdance.platform.NeoForgeRegistryHelper;
import com.teamabode.verdance.registry.VerdanceBlocks;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FireBlock;
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

        // TODO: compostables, strippable blocks
    }

    private void setup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            FireBlock fire = (FireBlock) Blocks.FIRE;

            fire.setFlammable(VerdanceBlocks.MULBERRY_LOG.get(), 5, 5);
            fire.setFlammable(VerdanceBlocks.MULBERRY_WOOD.get(), 5, 5);
            fire.setFlammable(VerdanceBlocks.STRIPPED_MULBERRY_LOG.get(), 5, 5);
            fire.setFlammable(VerdanceBlocks.STRIPPED_MULBERRY_WOOD.get(), 5, 5);
            fire.setFlammable(VerdanceBlocks.MULBERRY_PLANKS.get(), 5, 20);
            fire.setFlammable(VerdanceBlocks.MULBERRY_STAIRS.get(), 5, 20);
            fire.setFlammable(VerdanceBlocks.MULBERRY_SLAB.get(), 5, 20);
            fire.setFlammable(VerdanceBlocks.MULBERRY_FENCE.get(), 5, 20);
            fire.setFlammable(VerdanceBlocks.MULBERRY_FENCE_GATE.get(), 5, 20);
            fire.setFlammable(VerdanceBlocks.MULBERRY_LEAVES.get(), 30, 60);
        });
    }
}