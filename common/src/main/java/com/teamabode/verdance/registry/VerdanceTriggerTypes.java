package com.teamabode.verdance.registry;

import com.teamabode.verdance.platform.Services;
import com.teamabode.verdance.trigger.SilkwormEggsDestroyedCriterion;
import net.minecraft.advancements.CriterionTrigger;
import net.minecraft.advancements.critereon.PlayerTrigger;

import java.util.function.Supplier;

public class VerdanceTriggerTypes {
    public static final Supplier<SilkwormEggsDestroyedCriterion> SILKWORM_EGGS_DESTROYED = register("silkworm_eggs_destroyed", SilkwormEggsDestroyedCriterion::new);
    public static final Supplier<PlayerTrigger> EXTINGUISHED_WITH_CANTALOUPE_JUICE = register("extinguished_with_cantaloupe_juice", PlayerTrigger::new);

    public static void init() {}

    private static <T extends CriterionTrigger<?>> Supplier<T> register(String name, Supplier<T> trigger) {
        return Services.REGISTRY.registerTriggerType(name, trigger);
    }
}
