package com.teamabode.verdance.platform;

import com.teamabode.verdance.Verdance;
import com.teamabode.verdance.platform.services.IRegistryHelper;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class NeoForgeRegistryHelper implements IRegistryHelper {
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.createItems(Verdance.MOD_ID);
    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.createBlocks(Verdance.MOD_ID);

    public static void init(IEventBus bus) {
        ITEMS.register(bus);
        BLOCKS.register(bus);
    }

    @Override
    public <T extends Item> Supplier<T> registerItem(String name, Supplier<T> item) {
        return ITEMS.register(name, item);
    }

    @Override
    public <T extends Block> Supplier<T> registerBlock(String name, Supplier<T> block) {
        return BLOCKS.register(name, block);
    }
}
