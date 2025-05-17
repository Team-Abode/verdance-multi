package com.teamabode.verdance.registry;

import com.teamabode.verdance.platform.Services;
import net.minecraft.core.Holder;
import net.minecraft.sounds.SoundEvent;

import java.util.function.Supplier;


public class VerdanceSoundEvents {
    public static final Supplier<SoundEvent> BLOCK_STUCCO_BREAK = register("block.stucco.break");
    public static final Supplier<SoundEvent> BLOCK_STUCCO_FALL = register("block.stucco.fall");
    public static final Supplier<SoundEvent> BLOCK_STUCCO_HIT = register("block.stucco.hit");
    public static final Supplier<SoundEvent> BLOCK_STUCCO_STEP = register("block.stucco.step");
    public static final Supplier<SoundEvent> BLOCK_STUCCO_PLACE = register("block.stucco.place");

    public static final Supplier<SoundEvent> ENTITY_SILK_MOTH_IDLE = register("entity.silk_moth.idle");
    public static final Supplier<SoundEvent> ENTITY_SILK_MOTH_HURT = register("entity.silk_moth.hurt");
    public static final Supplier<SoundEvent> ENTITY_SILK_MOTH_EAT = register("entity.silk_moth.eat");
    public static final Supplier<SoundEvent> ENTITY_SILK_MOTH_EMERGE = register("entity.silk_moth.emerge");
    public static final Supplier<SoundEvent> ENTITY_SILK_MOTH_DEATH = register("entity.silk_moth.death");

    public static final Supplier<SoundEvent> ENTITY_SILKWORM_HURT = register("entity.silkworm.hurt");
    public static final Supplier<SoundEvent> ENTITY_SILKWORM_DEATH = register("entity.silkworm.death");

    public static final Supplier<SoundEvent> BLOCK_SILK_COCOON_BREAK = register("block.silk_cocoon.break");
    public static final Supplier<SoundEvent> BLOCK_SILK_COCOON_FALL = register("block.silk_cocoon.fall");
    public static final Supplier<SoundEvent> BLOCK_SILK_COCOON_HIT = register("block.silk_cocoon.hit");
    public static final Supplier<SoundEvent> BLOCK_SILK_COCOON_PLACE = register("block.silk_cocoon.place");
    public static final Supplier<SoundEvent> BLOCK_SILK_COCOON_STEP = register("block.silk_cocoon.step");
    public static final Supplier<SoundEvent> BLOCK_SILK_COCOON_WOBBLE = register("block.silk_cocoon.wobble");

    public static final Holder<SoundEvent> MUSIC_DISC_RANGE = registerHolder("music_disc.range");

    public static void init() {}

    private static Supplier<SoundEvent> register(String name) {
        return Services.REGISTRY.registerSoundEvent(name);
    }

    private static Holder<SoundEvent> registerHolder(String name) {
        return Services.REGISTRY.registerSoundEventHolder(name);
    }
}
