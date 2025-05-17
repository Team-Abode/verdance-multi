package com.teamabode.verdance.entity.silkmoth.task;

import com.teamabode.verdance.entity.behavior.ImprovedSingleTickTask;
import com.teamabode.verdance.entity.silkmoth.SilkMoth;
import com.teamabode.verdance.registry.VerdanceMemoryModuleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.ai.memory.MemoryStatus;

import java.util.Map;

public class TakeOffTask extends ImprovedSingleTickTask<SilkMoth> {

    @Override
    public void requires(Map<MemoryModuleType<?>, MemoryStatus> requirements) {
        requirements.put(MemoryModuleType.CANT_REACH_WALK_TARGET_SINCE, MemoryStatus.VALUE_PRESENT);
        requirements.put(VerdanceMemoryModuleTypes.IS_FLYING.get(), MemoryStatus.VALUE_ABSENT);
    }

    @Override
    public boolean canStart(ServerLevel level, SilkMoth entity, long gameTime) {
        return entity.onGround();
    }

    @Override
    public void start(ServerLevel level, SilkMoth entity, long gameTime) {
        entity.takeOff();
    }
}
