package com.teamabode.verdance.platform.services;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

public interface IRegistryHelper {

    <T extends Item> Supplier<T> registerItem(String name, Supplier<T> item);

    <T extends Block> Supplier<T> registerBlock(String name, Supplier<T> block);
}
