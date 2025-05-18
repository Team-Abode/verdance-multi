package com.teamabode.verdance.registry;

import com.teamabode.verdance.Verdance;
import com.teamabode.verdance.entity.CushionEntity;
import com.teamabode.verdance.entity.silkmoth.SilkMoth;
import com.teamabode.verdance.entity.silkworm.Silkworm;
import com.teamabode.verdance.platform.Services;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.*;

import java.util.function.Supplier;

public class VerdanceEntityTypes {
    public static final Supplier<EntityType<SilkMoth>> SILK_MOTH = register(
            "silk_moth",
            EntityType.Builder.of(SilkMoth::new, MobCategory.CREATURE).sized(0.7f, 0.7f).eyeHeight(0.35f)
    );

    public static final Supplier<EntityType<Silkworm>> SILKWORM = register(
            "silkworm",
            EntityType.Builder.of(Silkworm::new, MobCategory.CREATURE).sized(0.6f, 0.25f)
    );

    public static final Supplier<EntityType<CushionEntity>> CUSHION = register(
            "cushion",
            EntityType.Builder.of(CushionEntity::new, MobCategory.MISC)
                    .noSummon()
                    .sized(0.6f, 0.25f)
    );

    private static <E extends Entity> Supplier<EntityType<E>> register(String name, EntityType.Builder<E> builder) {
        ResourceLocation id = Verdance.id(name);
        return Services.REGISTRY.registerEntity(name, () -> builder.build(id.toString()));
    }

    public static void init() {}
}
