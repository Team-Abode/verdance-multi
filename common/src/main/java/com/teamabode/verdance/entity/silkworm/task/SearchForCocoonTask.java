package com.teamabode.verdance.entity.silkworm.task;

import com.teamabode.verdance.entity.behavior.ImprovedOneShot;
import com.teamabode.verdance.entity.silkworm.Silkworm;
import com.teamabode.verdance.util.SilkMothUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.ai.behavior.BehaviorUtils;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.ai.memory.MemoryStatus;

import java.util.Map;
import java.util.Optional;

public class SearchForCocoonTask extends ImprovedOneShot<Silkworm> {
    private long lastExecution = 0L; // It should only try to attempt this task around every four seconds.

    @Override
    public void requires(Map<MemoryModuleType<?>, MemoryStatus> requirements) {
        requirements.put(MemoryModuleType.WALK_TARGET, MemoryStatus.VALUE_ABSENT);
        requirements.put(MemoryModuleType.LOOK_TARGET, MemoryStatus.REGISTERED);
    }

    @Override
    public void start(ServerLevel level, Silkworm entity, long gameTime) {
        if (gameTime > this.lastExecution) {
            this.lastExecution = gameTime + 80L;
            return;
        }
        Optional<BlockPos> targetPos = SilkMothUtil.getTargetPos(level, entity.blockPosition());

        if (targetPos.isPresent()) {
            BehaviorUtils.setWalkAndLookTargetMemories(entity, targetPos.get(), 2.0f, 0);
            return;
        }
        this.lastExecution = gameTime + 80L;
    }
}
