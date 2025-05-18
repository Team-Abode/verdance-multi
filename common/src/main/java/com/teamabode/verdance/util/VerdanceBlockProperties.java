package com.teamabode.verdance.util;

import com.teamabode.verdance.misc.VerdanceBlockSoundGroups;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.PushReaction;

public class VerdanceBlockProperties {
    public static final BlockBehaviour.StateArgumentPredicate<EntityType<?>> NEVER = (state, level, pos, value) -> false;

    public static BlockBehaviour.Properties stucco(DyeColor color) {
        return BlockBehaviour.Properties.of()
                .mapColor(color)
                .sound(VerdanceBlockSoundGroups.STUCCO)
                .requiresCorrectToolForDrops()
                .instrument(NoteBlockInstrument.BASEDRUM)
                .strength(1.5F, 5.5F);
    }

    public static BlockBehaviour.Properties cushion(DyeColor color) {
        return BlockBehaviour.Properties.of()
                .mapColor(color)
                .sound(SoundType.WOOD)
                .strength(0.2f)
                .noCollission()
                .ignitedByLava()
                .pushReaction(PushReaction.DESTROY);
    }
}