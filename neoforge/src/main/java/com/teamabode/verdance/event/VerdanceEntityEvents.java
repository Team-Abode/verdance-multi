package com.teamabode.verdance.event;

import com.teamabode.verdance.Verdance;
import com.teamabode.verdance.entity.silkmoth.SilkMoth;
import com.teamabode.verdance.entity.silkworm.Silkworm;
import com.teamabode.verdance.registry.VerdanceEntityTypes;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;

@EventBusSubscriber(
        modid = Verdance.MOD_ID,
        bus = EventBusSubscriber.Bus.GAME
)
public class VerdanceEntityEvents {

    @SubscribeEvent
    public static void entityAttributeCreationEvent(EntityAttributeCreationEvent event) {
        event.put(VerdanceEntityTypes.SILK_MOTH.get(), SilkMoth.createSilkMothAttributes().build());
        event.put(VerdanceEntityTypes.SILKWORM.get(), Silkworm.createSilkwormAttributes().build());
    }

    @SubscribeEvent
    public static void registerSpawnPlacementsEvent(RegisterSpawnPlacementsEvent event) {
        event.register(VerdanceEntityTypes.SILK_MOTH.get(), SilkMoth::checkSilkMothSpawnRules);
    }
}
