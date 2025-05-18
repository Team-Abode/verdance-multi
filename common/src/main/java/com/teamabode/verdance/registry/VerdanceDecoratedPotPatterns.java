package com.teamabode.verdance.registry;

import com.teamabode.verdance.Verdance;
import com.teamabode.verdance.platform.Services;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.entity.DecoratedPotPattern;

import java.util.Map;

public class VerdanceDecoratedPotPatterns {
    public static final ResourceKey<DecoratedPotPattern> ABODE = createKey("abode");
    public static final ResourceKey<DecoratedPotPattern> FRILLS = createKey("frills");
    public static final ResourceKey<DecoratedPotPattern> PITCH = createKey("pitch");
    public static final ResourceKey<DecoratedPotPattern> PRICKLE = createKey("prickle");
    public static final ResourceKey<DecoratedPotPattern> SPIRIT = createKey("spirit");
    public static final ResourceKey<DecoratedPotPattern> TRAP = createKey("trap");

    // TODO: add sherd patterns to mixin
    public static final Map<Item, ResourceKey<DecoratedPotPattern>> SHERD_TO_PATTERN = Map.of(
            VerdanceItems.ABODE_POTTERY_SHERD.get(), ABODE,
            VerdanceItems.FRILLS_POTTERY_SHERD.get(), FRILLS,
            VerdanceItems.PITCH_POTTERY_SHERD.get(), PITCH,
            VerdanceItems.PRICKLE_POTTERY_SHERD.get(), PRICKLE,
            VerdanceItems.SPIRIT_POTTERY_SHERD.get(), SPIRIT,
            VerdanceItems.TRAP_POTTERY_SHERD.get(), TRAP
    );

    public static void init() {
        register(ABODE, "abode_pottery_pattern");
        register(FRILLS, "frills_pottery_pattern");
        register(PITCH, "pitch_pottery_pattern");
        register(PRICKLE, "prickle_pottery_pattern");
        register(SPIRIT, "spirit_pottery_pattern");
        register(TRAP, "trap_pottery_pattern");
    }

    private static ResourceKey<DecoratedPotPattern> createKey(String name) {
        return ResourceKey.create(Registries.DECORATED_POT_PATTERN, Verdance.id(name));
    }

    private static void register(ResourceKey<DecoratedPotPattern> key, String assetId) {
        Services.REGISTRY.registerDecoratedPotPattern(key.location().getNamespace(), () -> new DecoratedPotPattern(Verdance.id(assetId)));
    }
}
