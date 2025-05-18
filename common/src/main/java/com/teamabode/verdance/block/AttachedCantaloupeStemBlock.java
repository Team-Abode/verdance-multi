package com.teamabode.verdance.block;

import com.teamabode.verdance.registry.reference.VerdanceBlockReferences;
import com.teamabode.verdance.registry.reference.VerdanceItemReferences;
import net.minecraft.world.level.block.AttachedStemBlock;

public class AttachedCantaloupeStemBlock extends AttachedStemBlock {
    public AttachedCantaloupeStemBlock(Properties properties) {
        super(VerdanceBlockReferences.CANTALOUPE_STEM, VerdanceBlockReferences.CANTALOUPE, VerdanceItemReferences.CANTALOUPE_SEEDS, properties);
    }
}
