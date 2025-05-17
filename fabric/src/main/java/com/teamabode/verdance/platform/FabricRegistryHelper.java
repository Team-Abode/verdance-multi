package com.teamabode.verdance.platform;

import com.teamabode.verdance.Verdance;
import com.teamabode.verdance.platform.services.IRegistryHelper;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

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
}
