package com.teamabode.verdance.entity.silkworm.task;

import com.teamabode.verdance.entity.behavior.ImprovedOneShot;
import com.teamabode.verdance.entity.silkworm.Silkworm;
import com.teamabode.verdance.util.SilkMothUtil;
import com.teamabode.verdance.registry.VerdanceMemoryModuleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.ai.memory.MemoryStatus;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Map;

public class TurnIntoCocoonTask extends ImprovedOneShot<Silkworm> {

    @Override
    public void requires(Map<MemoryModuleType<?>, MemoryStatus> requirements) {
        requirements.put(VerdanceMemoryModuleTypes.WANTS_TO_COCOON.get(), MemoryStatus.VALUE_PRESENT);
    }

    @Override
    public void start(ServerLevel level, Silkworm entity, long gameTime) {
        if (!entity.getInBlockState().is(BlockTags.REPLACEABLE)) return;

        for (Direction dir : Direction.Plane.HORIZONTAL) {
            BlockPos dirPos = entity.blockPosition().relative(dir);
            BlockState dirState = level.getBlockState(dirPos);
            if (!dirState.is(BlockTags.LOGS_THAT_BURN)) continue;

            SilkMothUtil.transformIntoCocoon(level, entity, entity.blockPosition(), dir);
        }
    }
}
