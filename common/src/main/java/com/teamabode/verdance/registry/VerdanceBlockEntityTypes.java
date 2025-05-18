package com.teamabode.verdance.registry;

import com.teamabode.verdance.block.entity.SilkCocoonBlockEntity;
import com.teamabode.verdance.platform.Services;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.function.Supplier;

public class VerdanceBlockEntityTypes {
    public static final Supplier<BlockEntityType<SilkCocoonBlockEntity>> SILK_COCOON = register(
            "silk_cocoon",
            () -> Services.PLATFORM.createBlockEntity(SilkCocoonBlockEntity::new, VerdanceBlocks.SILK_COCOON.get())
    );

    private static <E extends BlockEntity> Supplier<BlockEntityType<E>> register(String name, Supplier<BlockEntityType<E>> blockEntity) {
        return Services.REGISTRY.registerBlockEntity(name, blockEntity);
    }

    public static void init() {

    }
}
