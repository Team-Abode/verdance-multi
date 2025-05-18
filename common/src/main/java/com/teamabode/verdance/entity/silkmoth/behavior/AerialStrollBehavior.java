package com.teamabode.verdance.entity.silkmoth.behavior;

import com.teamabode.verdance.entity.silkmoth.SilkMoth;
import com.teamabode.verdance.entity.behavior.ImprovedOneShot;
import com.teamabode.verdance.registry.VerdanceMemoryModuleTypes;
import com.teamabode.verdance.util.SilkMothUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.ai.behavior.BlockPosTracker;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.ai.memory.MemoryStatus;
import net.minecraft.world.entity.ai.memory.WalkTarget;

import java.util.Map;
import java.util.Optional;

public class AerialStrollBehavior extends ImprovedOneShot<SilkMoth> {

    public void requires(Map<MemoryModuleType<?>, MemoryStatus> requirements) {
        requirements.put(MemoryModuleType.WALK_TARGET, MemoryStatus.VALUE_ABSENT);
        requirements.put(MemoryModuleType.LOOK_TARGET, MemoryStatus.REGISTERED);
        requirements.put(VerdanceMemoryModuleTypes.IS_FLYING.get(), MemoryStatus.VALUE_PRESENT);
    }

    public void start(ServerLevel level, SilkMoth entity, long gameTime) {
        Optional<BlockPos> pos = SilkMothUtil.calculateStrollTarget(entity);
        pos.ifPresent(blockPos -> entity.getBrain().setMemory(MemoryModuleType.WALK_TARGET, new WalkTarget(new BlockPosTracker(blockPos), 1.0f, 0)));
    }
}
