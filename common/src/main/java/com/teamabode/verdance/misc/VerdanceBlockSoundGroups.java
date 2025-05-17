package com.teamabode.verdance.misc;

import com.teamabode.verdance.registry.VerdanceSoundEvents;
import net.minecraft.world.level.block.SoundType;

public class VerdanceBlockSoundGroups {
    public static final SoundType SILK_COCOON = new SoundType(
            1.0f, 1.0f,
            VerdanceSoundEvents.BLOCK_SILK_COCOON_BREAK.get(),
            VerdanceSoundEvents.BLOCK_SILK_COCOON_STEP.get(),
            VerdanceSoundEvents.BLOCK_SILK_COCOON_PLACE.get(),
            VerdanceSoundEvents.BLOCK_SILK_COCOON_HIT.get(),
            VerdanceSoundEvents.BLOCK_SILK_COCOON_FALL.get()
    );
    public static final SoundType STUCCO = new SoundType(
            0.4f, 1.1f,
            VerdanceSoundEvents.BLOCK_STUCCO_BREAK.get(),
            VerdanceSoundEvents.BLOCK_STUCCO_STEP.get(),
            VerdanceSoundEvents.BLOCK_STUCCO_PLACE.get(),
            VerdanceSoundEvents.BLOCK_STUCCO_HIT.get(),
            VerdanceSoundEvents.BLOCK_STUCCO_FALL.get()
    );
}
