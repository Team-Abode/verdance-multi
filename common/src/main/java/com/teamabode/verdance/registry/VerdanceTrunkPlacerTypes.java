package com.teamabode.verdance.registry;

import com.mojang.serialization.MapCodec;
import com.teamabode.verdance.platform.Services;
import com.teamabode.verdance.worldgen.MulberryTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;

import java.util.function.Supplier;

public class VerdanceTrunkPlacerTypes {
    public static final Supplier<TrunkPlacerType<MulberryTrunkPlacer>> MULBERRY_TRUNK_PLACER = register("mulberry_trunk_placer",MulberryTrunkPlacer.CODEC);

    private static <P extends TrunkPlacer> Supplier<TrunkPlacerType<P>> register(String name, MapCodec<P> codec) {
        return Services.REGISTRY.registerTrunkPlacerType(name, () -> new TrunkPlacerType<>(codec));
    }

    public static void init() {}
}
