package com.teamabode.verdance.registry;

import com.mojang.serialization.MapCodec;
import com.teamabode.verdance.platform.Services;
import com.teamabode.verdance.worldgen.SilkCocoonTreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;

import java.util.function.Supplier;

public class VerdanceTreeDecoratorTypes {
    public static final Supplier<TreeDecoratorType<SilkCocoonTreeDecorator>> SILK_COCOON = register("silk_cocoon", SilkCocoonTreeDecorator.CODEC);

    public static void init() {
    }

    private static <P extends TreeDecorator> Supplier<TreeDecoratorType<P>> register(String name, MapCodec<P> decorator) {
        return Services.REGISTRY.registerTreeDecoratorType(name, () -> new TreeDecoratorType<>(decorator));
    }

}
