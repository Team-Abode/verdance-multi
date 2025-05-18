package com.teamabode.verdance;

import com.teamabode.verdance.entity.silkmoth.SilkMoth;
import com.teamabode.verdance.entity.silkworm.Silkworm;
import com.teamabode.verdance.registry.VerdanceBlocks;
import com.teamabode.verdance.registry.VerdanceEntityTypes;
import com.teamabode.verdance.registry.VerdanceItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.world.entity.SpawnPlacementTypes;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.levelgen.Heightmap;

public class VerdanceFabric implements ModInitializer {
    
    @Override
    public void onInitialize() {
        Verdance.init();

        SpawnPlacements.register(VerdanceEntityTypes.SILK_MOTH.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING, SilkMoth::checkSilkMothSpawnRules);
        FabricDefaultAttributeRegistry.register(VerdanceEntityTypes.SILK_MOTH.get(), SilkMoth.createSilkMothAttributes());
        FabricDefaultAttributeRegistry.register(VerdanceEntityTypes.SILKWORM.get(), Silkworm.createSilkwormAttributes());

        CompostingChanceRegistry.INSTANCE.add(VerdanceBlocks.CANTALOUPE.get(), 0.65F);
        CompostingChanceRegistry.INSTANCE.add(VerdanceItems.CANTALOUPE_SEEDS.get(), 0.30F);
        CompostingChanceRegistry.INSTANCE.add(VerdanceItems.CANTALOUPE_SLICE.get(), 0.50F);
        CompostingChanceRegistry.INSTANCE.add(VerdanceBlocks.FLOWERING_MULBERRY_LEAVES.get(), 0.50F);
        CompostingChanceRegistry.INSTANCE.add(VerdanceItems.GRILLED_CANTALOUPE_SLICE.get(), 0.65F);
        CompostingChanceRegistry.INSTANCE.add(VerdanceItems.MULBERRY.get(), 0.30F);
        CompostingChanceRegistry.INSTANCE.add(VerdanceBlocks.MULBERRY_LEAVES.get(), 0.30F);
        CompostingChanceRegistry.INSTANCE.add(VerdanceBlocks.VIOLET.get(), 0.65f);
        CompostingChanceRegistry.INSTANCE.add(VerdanceBlocks.SHRUB.get(), 0.30f);
        CompostingChanceRegistry.INSTANCE.add(VerdanceBlocks.YELLOW_FLOWERING_SHRUB.get(), 0.30f);
        CompostingChanceRegistry.INSTANCE.add(VerdanceBlocks.PINK_FLOWERING_SHRUB.get(), 0.30f);

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
