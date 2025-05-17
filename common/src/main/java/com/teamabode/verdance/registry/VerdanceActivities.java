package com.teamabode.verdance.registry;

import com.teamabode.verdance.platform.Services;
import net.minecraft.world.entity.schedule.Activity;

import java.util.function.Supplier;

public class VerdanceActivities {
    public static final Supplier<Activity> COCOON = register("cocoon");
    public static final Supplier<Activity> LAY_EGGS = register("lay_eggs");
    public static final Supplier<Activity> SLEEP = register("sleep");

    public static Supplier<Activity> register(String name) {
        return Services.REGISTRY.registerActivity(name);
    }

    public static void init() {

    }
}
