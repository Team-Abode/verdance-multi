package com.teamabode.verdance.block;

import com.teamabode.verdance.registry.reference.VerdanceBlockReferences;
import com.teamabode.verdance.registry.reference.VerdanceItemReferences;
import net.minecraft.world.level.block.StemBlock;

public class CantaloupeStemBlock extends StemBlock {
    public CantaloupeStemBlock(Properties properties) {
        super(VerdanceBlockReferences.CANTALOUPE, VerdanceBlockReferences.ATTACHED_CANTALOUPE_STEM, VerdanceItemReferences.CANTALOUPE_SEEDS, properties);
    }
}
