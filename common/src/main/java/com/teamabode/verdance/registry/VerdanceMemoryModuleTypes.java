package com.teamabode.verdance.registry;

import com.mojang.serialization.Codec;
import com.teamabode.verdance.Verdance;
import com.teamabode.verdance.platform.Services;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.util.Unit;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;

import java.util.Optional;
import java.util.function.Supplier;

public class VerdanceMemoryModuleTypes {
    public static final Supplier<MemoryModuleType<Unit>> IS_FLYING = register("is_flying");
    public static final Supplier<MemoryModuleType<Unit>> WANTS_TO_COCOON = register("wants_to_cocoon");
    public static final Supplier<MemoryModuleType<Unit>> WANTS_TO_LAND = register("wants_to_land", Codec.unit(Unit.INSTANCE));
    public static final Supplier<MemoryModuleType<Long>> LANDING_TIME = register("landing_time", Codec.LONG);

    public static <T> Supplier<MemoryModuleType<T>> register(String name) {
        return Services.REGISTRY.registerMemoryModuleType(name);
    }

    public static <T> Supplier<MemoryModuleType<T>> register(String name, Codec<T> codec) {
        return Services.REGISTRY.registerMemoryModuleType(name, codec);
    }

    public static void init() {

    }
}
