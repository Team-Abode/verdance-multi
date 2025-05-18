package com.teamabode.verdance.registry;

import com.teamabode.verdance.item.CantaloupeJuiceItem;
import com.teamabode.verdance.misc.VerdanceFoodComponents;
import com.teamabode.verdance.platform.Services;
import com.teamabode.verdance.registry.datapack.VerdanceJukeboxSongs;
import com.teamabode.verdance.registry.datapack.VerdanceTrimPatterns;
import net.minecraft.world.item.*;
import net.minecraft.world.item.Item.Properties;

import java.util.function.Supplier;

// TODO: boat items
public class VerdanceItems {
    public static final Supplier<Item> CANTALOUPE_SLICE = register(
            "cantaloupe_slice",
            new Properties()
                    .food(VerdanceFoodComponents.CANTALOUPE_SLICE)
    );
    public static final Supplier<Item> GRILLED_CANTALOUPE_SLICE = register(
            "grilled_cantaloupe_slice",
            new Properties()
                    .food(VerdanceFoodComponents.GRILLED_CANTALOUPE_SLICE)
    );
    public static final Supplier<Item> CANTALOUPE_JUICE = register(
            "cantaloupe_juice",
            () -> new CantaloupeJuiceItem(new Properties()
                    .food(VerdanceFoodComponents.CANTALOUPE_JUICE)
                    .stacksTo(16))
    );
    public static final Supplier<Item> CANTALOUPE_SEEDS = register(
            "cantaloupe_seeds",
            () -> new ItemNameBlockItem(VerdanceBlocks.CANTALOUPE_STEM.get(), new Properties())
    );
    public static final Supplier<Item> MULBERRY = register(
            "mulberry",
            () -> new ItemNameBlockItem(VerdanceBlocks.MULBERRY_SAPLING.get(), new Properties()
                    .food(VerdanceFoodComponents.MULBERRY))
    );
    public static final Supplier<Item> MULBERRY_SIGN = register(
            "mulberry_sign",
            () -> new SignItem(
                    new Properties().stacksTo(16),
                    VerdanceBlocks.MULBERRY_SIGN.get(),
                    VerdanceBlocks.MULBERRY_WALL_SIGN.get())
    );
    public static final Supplier<Item> MULBERRY_HANGING_SIGN = register(
            "mulberry_hanging_sign",
            () -> new HangingSignItem(VerdanceBlocks.MULBERRY_HANGING_SIGN.get(), VerdanceBlocks.MULBERRY_WALL_HANGING_SIGN.get(), new Properties()
                    .stacksTo(16))
    );
    /*
    public static final Item MULBERRY_BOAT = register(
            "mulberry_boat", new SketchBoatItem(
                    new Properties().stacksTo(1),
                    VerdanceBoatTypes.MULBERRY,
                    false)
    );
    public static final Item MULBERRY_CHEST_BOAT = register(
            "mulberry_chest_boat",
            new SketchBoatItem(
                    new Properties().stacksTo(1),
                    VerdanceBoatTypes.MULBERRY,
                    true)
    );
    */
    public static final Supplier<Item> MUSIC_DISC_RANGE = register(
            "music_disc_range",
            new Properties()
                    .stacksTo(1)
                    .rarity(Rarity.RARE)
                    .jukeboxPlayable(VerdanceJukeboxSongs.RANGE)
    );
    public static final Supplier<Item> DISC_FRAGMENT_RANGE = register(
            "disc_fragment_range",
            () -> new DiscFragmentItem(new Properties())
    );

    public static final Supplier<Item> ABODE_POTTERY_SHERD = register("abode_pottery_sherd");
    public static final Supplier<Item> FRILLS_POTTERY_SHERD = register("frills_pottery_sherd");
    public static final Supplier<Item> PITCH_POTTERY_SHERD = register("pitch_pottery_sherd");
    public static final Supplier<Item> PRICKLE_POTTERY_SHERD = register("prickle_pottery_sherd");
    public static final Supplier<Item> SPIRIT_POTTERY_SHERD = register("spirit_pottery_sherd");
    public static final Supplier<Item> TRAP_POTTERY_SHERD = register("trap_pottery_sherd");

    public static final Supplier<Item> COMMUNITY_ARMOR_TRIM_SMITHING_TEMPLATE = register(
            "community_armor_trim_smithing_template",
            () -> SmithingTemplateItem.createArmorTrimTemplate(VerdanceTrimPatterns.COMMUNITY)
    );

    public static final Supplier<Item> SILK_MOTH_SPAWN_EGG = register(
            "silk_moth_spawn_egg",
            () -> new SpawnEggItem(VerdanceEntityTypes.SILK_MOTH.get(), 13542773, 16383172, new Properties())
    );
    public static final Supplier<Item> SILKWORM_SPAWN_EGG = register(
            "silkworm_spawn_egg",
            () -> new SpawnEggItem(VerdanceEntityTypes.SILKWORM.get(), 0xEBEDE6, 0x75665D, new Properties())
    );

    public static void init() {}

    // Utils
    private static Supplier<Item> register(String name) {
        return register(name, new Properties());
    }

    private static Supplier<Item> register(String name, Properties properties) {
        return register(name, () -> new Item(properties));
    }

    private static <T extends Item> Supplier<T> register(String name, Supplier<T> item) {
        return Services.REGISTRY.registerItem(name, item);
    }
}
