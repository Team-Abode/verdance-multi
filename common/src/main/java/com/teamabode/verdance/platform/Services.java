package com.teamabode.verdance.platform;

import com.teamabode.verdance.platform.services.IPlatformHelper;
import com.teamabode.verdance.platform.services.IRegistryHelper;

import java.util.ServiceLoader;

// TODO: config service and general config implementation
public class Services {
    public static final IPlatformHelper PLATFORM = load(IPlatformHelper.class);
    public static final IRegistryHelper REGISTRY = load(IRegistryHelper.class);

    public static <T> T load(Class<T> clazz) {
        return ServiceLoader.load(clazz)
                .findFirst()
                .orElseThrow(() -> new NullPointerException("Failed to load service for " + clazz.getName()));
    }
}