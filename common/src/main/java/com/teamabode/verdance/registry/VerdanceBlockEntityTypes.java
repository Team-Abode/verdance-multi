package com.teamabode.verdance.registry;

import com.teamabode.verdance.block.entity.SilkCocoonBlockEntity;
import com.teamabode.verdance.platform.Services;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.function.Supplier;

public class VerdanceBlockEntityTypes {
    public static final Supplier<BlockEntityType<SilkCocoonBlockEntity>> SILK_COCOON = register("silk_cocoon", BlockEntityType.Builder.of(SilkCocoonBlockEntity::new, VerdanceBlocks.SILK_COCOON));

    private static <E extends BlockEntity> BlockEntityType<E> register(String name, BlockEntityType.Builder<E> blockEntity) {
        return Services.REGISTRY.registerBlockEntity(name, () -> blockEntity.build(null));
    }

    public static void init() {

    }
}
