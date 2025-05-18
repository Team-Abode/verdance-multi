package com.teamabode.verdance.worldgen;

import com.teamabode.verdance.registry.datapack.VerdanceConfiguredFeatures;
import net.minecraft.world.level.block.grower.TreeGrower;

import java.util.Optional;

public class VerdanceSaplingGenerators {
    public static final TreeGrower MULBERRY = new TreeGrower("mulberry", Optional.empty(), Optional.of(VerdanceConfiguredFeatures.MULBERRY), Optional.of(VerdanceConfiguredFeatures.MULBERRY_WITH_SILK_COCOON));
}
