package com.teamabode.verdance.block.access;

import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

public class StairBlock extends net.minecraft.world.level.block.StairBlock {
    public StairBlock(Supplier<Block> block, Properties properties) {
        super(block.get().defaultBlockState(), properties);
    }
}
