package com.teamabode.verdance.entity.silkmoth.task;

import com.teamabode.verdance.entity.behavior.ImprovedSingleTickTask;
import com.teamabode.verdance.entity.silkmoth.SilkMoth;
import com.teamabode.verdance.registry.VerdanceMemoryModuleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.ai.memory.MemoryStatus;

import java.util.Map;

public class LandTask extends ImprovedSingleTickTask<SilkMoth> {

    @Override
    public void requires(Map<MemoryModuleType<?>, MemoryStatus> requirements) {
        requirements.put(VerdanceMemoryModuleTypes.WANTS_TO_LAND.get(), MemoryStatus.VALUE_PRESENT);
        requirements.put(VerdanceMemoryModuleTypes.IS_FLYING.get(), MemoryStatus.VALUE_PRESENT);
    }

    @Override
    public void start(ServerLevel level, SilkMoth entity, long gameTime) {
        if (entity.onGround()) {
            entity.land();
        }
    }
}
