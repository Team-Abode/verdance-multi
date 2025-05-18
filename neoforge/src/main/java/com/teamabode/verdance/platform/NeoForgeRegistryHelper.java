package com.teamabode.verdance.platform;

import com.mojang.serialization.Codec;
import com.teamabode.verdance.Verdance;
import com.teamabode.verdance.platform.services.IRegistryHelper;
import net.minecraft.advancements.CriterionTrigger;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
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
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.Optional;
import java.util.function.Supplier;

public class NeoForgeRegistryHelper implements IRegistryHelper {
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.createItems(Verdance.MOD_ID);
    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.createBlocks(Verdance.MOD_ID);
    private static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, Verdance.MOD_ID);
    private static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, Verdance.MOD_ID);
    private static final DeferredRegister<Activity> ACTIVITIES = DeferredRegister.create(BuiltInRegistries.ACTIVITY, Verdance.MOD_ID);
    private static final DeferredRegister<MemoryModuleType<?>> MEMORY_MODULE_TYPES = DeferredRegister.create(BuiltInRegistries.MEMORY_MODULE_TYPE, Verdance.MOD_ID);
    private static final DeferredRegister<SensorType<?>> SENSOR_TYPES = DeferredRegister.create(BuiltInRegistries.SENSOR_TYPE, Verdance.MOD_ID);
    private static final DeferredRegister<TrunkPlacerType<?>> TRUNK_PLACER_TYPES = DeferredRegister.create(BuiltInRegistries.TRUNK_PLACER_TYPE, Verdance.MOD_ID);
    private static final DeferredRegister<TreeDecoratorType<?>> TREE_DECORATOR_TYPES = DeferredRegister.create(BuiltInRegistries.TREE_DECORATOR_TYPE, Verdance.MOD_ID);
    private static final DeferredRegister<CriterionTrigger<?>> TRIGGER_TYPES = DeferredRegister.create(BuiltInRegistries.TRIGGER_TYPES, Verdance.MOD_ID);
    private static final DeferredRegister<DecoratedPotPattern> DECORATED_POT_PATTERNS = DeferredRegister.create(BuiltInRegistries.DECORATED_POT_PATTERN, Verdance.MOD_ID);
    private static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, Verdance.MOD_ID);

    public static void init(IEventBus bus) {
        ITEMS.register(bus);
        BLOCKS.register(bus);
        BLOCK_ENTITY_TYPES.register(bus);
        ENTITY_TYPES.register(bus);
        ACTIVITIES.register(bus);
        MEMORY_MODULE_TYPES.register(bus);
        SENSOR_TYPES.register(bus);
        TRUNK_PLACER_TYPES.register(bus);
        TREE_DECORATOR_TYPES.register(bus);
        TRIGGER_TYPES.register(bus);
        DECORATED_POT_PATTERNS.register(bus);
        SOUND_EVENTS.register(bus);
    }

    @Override
    public <T extends Item> Supplier<T> registerItem(String name, Supplier<T> item) {
        return ITEMS.register(name, item);
    }

    @Override
    public <T extends Block> Supplier<T> registerBlock(String name, Supplier<T> block) {
        return BLOCKS.register(name, block);
    }

    @Override
    public <T extends BlockEntity> Supplier<BlockEntityType<T>> registerBlockEntity(String name, Supplier<BlockEntityType<T>> type) {
        return BLOCK_ENTITY_TYPES.register(name, type);
    }

    @Override
    public <T extends Entity> Supplier<EntityType<T>> registerEntity(String name, Supplier<EntityType<T>> type) {
        return ENTITY_TYPES.register(name, type);
    }

    @Override
    public Supplier<Activity> registerActivity(String name) {
        return ACTIVITIES.register(name, () -> new Activity(name));
    }

    @Override
    public <T> Supplier<MemoryModuleType<T>> registerMemoryModuleType(String name) {
        return MEMORY_MODULE_TYPES.register(name, () -> new MemoryModuleType<>(Optional.empty()));
    }

    @Override
    public <T> Supplier<MemoryModuleType<T>> registerMemoryModuleType(String name, Codec<T> codec) {
        return MEMORY_MODULE_TYPES.register(name, () -> new MemoryModuleType<>(Optional.of(codec)));
    }

    @Override
    public <T extends Sensor<?>> Supplier<SensorType<T>> registerSensorType(String name, Supplier<SensorType<T>> sensor) {
        return SENSOR_TYPES.register(name, sensor);
    }

    @Override
    public <T extends TrunkPlacer> Supplier<TrunkPlacerType<T>> registerTrunkPlacerType(String name, Supplier<TrunkPlacerType<T>> type) {
        return TRUNK_PLACER_TYPES.register(name, type);
    }

    @Override
    public <T extends TreeDecorator> Supplier<TreeDecoratorType<T>> registerTreeDecoratorType(String name, Supplier<TreeDecoratorType<T>> type) {
        return TREE_DECORATOR_TYPES.register(name, type);
    }

    @Override
    public <T extends CriterionTrigger<?>> Supplier<T> registerTriggerTypes(String name, Supplier<T> trigger) {
        return TRIGGER_TYPES.register(name, trigger);
    }

    @Override
    public Supplier<DecoratedPotPattern> registerDecoratedPotPattern(String name, Supplier<DecoratedPotPattern> pattern) {
        return DECORATED_POT_PATTERNS.register(name, pattern);
    }

    @Override
    public Supplier<SoundEvent> registerSoundEvent(String name) {
        return SOUND_EVENTS.register(name, SoundEvent::createVariableRangeEvent);
    }

    @Override
    public Holder<SoundEvent> registerSoundEventHolder(String name) {
        return SOUND_EVENTS.register(name, SoundEvent::createVariableRangeEvent);
    }
}
