package com.teamabode.verdance.entity.silkworm.sensor;

import com.teamabode.verdance.entity.silkworm.Silkworm;
import com.teamabode.verdance.registry.VerdanceMemoryModuleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Unit;
import net.minecraft.world.entity.ai.Brain;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.ai.sensing.Sensor;

import java.util.Optional;
import java.util.Set;

public class SilkwormSpecificSensor extends Sensor<Silkworm> {

    @Override
    protected void doTick(ServerLevel world, Silkworm entity) {
        Brain<Silkworm> brain = entity.getBrain();
        Optional<Unit> wantsToCocoon = Optional.empty();

        if (entity.getAge() > 24000) {
            wantsToCocoon = Optional.of(Unit.INSTANCE);
        }
        brain.setMemory(VerdanceMemoryModuleTypes.WANTS_TO_COCOON.get(), wantsToCocoon);
    }

    @Override
    public Set<MemoryModuleType<?>> requires() {
        return Set.of(VerdanceMemoryModuleTypes.WANTS_TO_COCOON.get());
    }
}
