package com.teamabode.verdance.platform;

import com.mojang.serialization.Codec;
import com.teamabode.verdance.Verdance;
import com.teamabode.verdance.platform.services.IRegistryHelper;
import net.minecraft.advancements.CriterionTrigger;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
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

import java.util.Optional;
import java.util.function.Supplier;

public class FabricRegistryHelper implements IRegistryHelper {

    @Override
    public <T extends Item> Supplier<T> registerItem(String name, Supplier<T> item) {
        T entry = Registry.register(BuiltInRegistries.ITEM, Verdance.id(name), item.get());
        return () -> entry;
    }

    @Override
    public <T extends Block> Supplier<T> registerBlock(String name, Supplier<T> block) {
        T entry = Registry.register(BuiltInRegistries.BLOCK, Verdance.id(name), block.get());
        return () -> entry;
    }

    @Override
    public <T extends BlockEntity> Supplier<BlockEntityType<T>> registerBlockEntity(String name, Supplier<BlockEntityType<T>> type) {
        BlockEntityType<T> entry = Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, Verdance.id(name), type.get());
        return () -> entry;
    }

    @Override
    public <T extends Entity> Supplier<EntityType<T>> registerEntity(String name, Supplier<EntityType<T>> type) {
        EntityType<T> entry = Registry.register(BuiltInRegistries.ENTITY_TYPE, Verdance.id(name), type.get());
        return () -> entry;
    }

    @Override
    public Supplier<Activity> registerActivity(String name) {
        Activity entry = Registry.register(BuiltInRegistries.ACTIVITY, Verdance.id(name), new Activity(name));
        return () -> entry;
    }

    @Override
    public <T> Supplier<MemoryModuleType<T>> registerMemoryModuleType(String name) {
        MemoryModuleType<T> entry = Registry.register(BuiltInRegistries.MEMORY_MODULE_TYPE, Verdance.id(name), new MemoryModuleType<>(Optional.empty()));
        return () -> entry;
    }

    @Override
    public <T> Supplier<MemoryModuleType<T>> registerMemoryModuleType(String name, Codec<T> codec) {
        MemoryModuleType<T> entry = Registry.register(BuiltInRegistries.MEMORY_MODULE_TYPE, Verdance.id(name), new MemoryModuleType<>(Optional.of(codec)));
        return () -> entry;
    }

    @Override
    public <T extends Sensor<?>> Supplier<SensorType<T>> registerSensorType(String name, Supplier<SensorType<T>> sensor) {
        SensorType<T> entry = Registry.register(BuiltInRegistries.SENSOR_TYPE, Verdance.id(name), sensor.get());
        return () -> entry;
    }

    @Override
    public <T extends TrunkPlacer> Supplier<TrunkPlacerType<T>> registerTrunkPlacerType(String name, Supplier<TrunkPlacerType<T>> type) {
        var entry = Registry.register(BuiltInRegistries.TRUNK_PLACER_TYPE, Verdance.id(name), type.get());
        return () -> entry;
    }

    @Override
    public <T extends TreeDecorator> Supplier<TreeDecoratorType<T>> registerTreeDecoratorType(String name, Supplier<TreeDecoratorType<T>> type) {
        var entry = Registry.register(BuiltInRegistries.TREE_DECORATOR_TYPE, Verdance.id(name), type.get());
        return () -> entry;
    }

    @Override
    public <T extends CriterionTrigger<?>> Supplier<T> registerTriggerTypes(String name, Supplier<T> trigger) {
        var entry = Registry.register(BuiltInRegistries.TRIGGER_TYPES, Verdance.id(name), trigger.get());
        return () -> entry;
    }

    @Override
    public Supplier<DecoratedPotPattern> registerDecoratedPotPattern(String name, Supplier<DecoratedPotPattern> pattern) {
        var entry = Registry.register(BuiltInRegistries.DECORATED_POT_PATTERN, Verdance.id(name), pattern.get());
        return () -> entry;
    }

    @Override
    public Supplier<SoundEvent> registerSoundEvent(String name) {
        ResourceLocation location = Verdance.id(name);
        var entry = Registry.register(BuiltInRegistries.SOUND_EVENT, location, SoundEvent.createVariableRangeEvent(location));
        return () -> entry;
    }

    @Override
    public Holder<SoundEvent> registerSoundEventHolder(String name) {
        ResourceLocation location = Verdance.id(name);
        return Registry.registerForHolder(BuiltInRegistries.SOUND_EVENT, location, SoundEvent.createVariableRangeEvent(location));
    }
}