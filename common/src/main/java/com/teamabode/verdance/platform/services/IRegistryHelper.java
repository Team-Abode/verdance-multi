package com.teamabode.verdance.platform.services;

import com.mojang.serialization.Codec;
import net.minecraft.advancements.CriterionTrigger;
import net.minecraft.core.Holder;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.ai.sensing.Sensor;
import net.minecraft.world.entity.ai.sensing.SensorType;
import net.minecraft.world.entity.schedule.Activity;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.DecoratedPotPattern;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;

import java.util.function.Supplier;

public interface IRegistryHelper {

    <T extends Item> Supplier<T> registerItem(String name, Supplier<T> item);

    <T extends Block> Supplier<T> registerBlock(String name, Supplier<T> block);

    <T extends BlockEntity> Supplier<BlockEntityType<T>> registerBlockEntity(String name, Supplier<BlockEntityType<T>> type);

    <T extends Entity> Supplier<EntityType<T>> registerEntity(String name, Supplier<EntityType<T>> type);

    Supplier<Activity> registerActivity(String name);

    <T> Supplier<MemoryModuleType<T>> registerMemoryModuleType(String name);

    <T> Supplier<MemoryModuleType<T>> registerMemoryModuleType(String name, Codec<T> codec);

    <T extends Sensor<?>> Supplier<SensorType<T>> registerSensorType(String name, Supplier<SensorType<T>> sensor);

    <T extends TrunkPlacer> Supplier<TrunkPlacerType<T>> registerTrunkPlacerType(String name, Supplier<TrunkPlacerType<T>> type);

    <T extends TreeDecorator> Supplier<TreeDecoratorType<T>> registerTreeDecoratorType(String name, Supplier<TreeDecoratorType<T>> type);

    <T extends CriterionTrigger<?>> Supplier<T> registerTriggerType(String name, Supplier<T> trigger);

    Supplier<DecoratedPotPattern> registerDecoratedPotPattern(String name, Supplier<DecoratedPotPattern> pattern);

    Supplier<SoundEvent> registerSoundEvent(String name);

    Holder<SoundEvent> registerSoundEventHolder(String name);
}
