package com.teamabode.verdance.item;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

@MethodsReturnNonnullByDefault
public class CantaloupeSliceItem extends Item {

    public CantaloupeSliceItem(Properties properties) {
        super(properties);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level world, LivingEntity user) {
        if (user instanceof ServerPlayer serverPlayer) {
            CriteriaTriggers.CONSUME_ITEM.trigger(serverPlayer, stack);
            serverPlayer.awardStat(Stats.ITEM_USED.get(this));
        }
        if (!world.isClientSide()) {
            int fireTicks = user.getRemainingFireTicks();

            if (fireTicks > 0) {
                world.playSound(null, user.blockPosition(), SoundEvents.FIRE_EXTINGUISH, SoundSource.PLAYERS, 0.25f, 1.0f);
                addCoolingParticles((ServerLevel) world, user);
                user.setRemainingFireTicks(Math.max(0, fireTicks - 60));
            }
        }
        return user.eat(world, stack);
    }

    public static void addCoolingParticles(ServerLevel level, LivingEntity user) {
        AABB box = user.getBoundingBox();
        Vec3 center = box.getCenter();

        level.sendParticles(ParticleTypes.SNOWFLAKE, center.x, center.y, center.z, 15, 0.5f, box.getYsize() / 2, 0.5f, 0.0d);
    }
}
