package com.teamabode.verdance.registry;

import com.teamabode.verdance.entity.silkmoth.SilkMothAi;
import com.teamabode.verdance.entity.silkmoth.sensor.SilkMothSpecificSensor;
import com.teamabode.verdance.entity.silkworm.SilkwormAi;
import com.teamabode.verdance.entity.silkworm.sensor.SilkwormSpecificSensor;
import com.teamabode.verdance.platform.Services;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.sensing.Sensor;
import net.minecraft.world.entity.ai.sensing.SensorType;
import net.minecraft.world.entity.ai.sensing.TemptingSensor;

import java.util.function.Supplier;

public class VerdanceSensorTypes {

    public static final Supplier<SensorType<SilkMothSpecificSensor>> SILK_MOTH_SPECIFIC_SENSOR = register("silk_moth_specific_sensor", SilkMothSpecificSensor::new);
    public static final Supplier<SensorType<SilkwormSpecificSensor>> SILKWORM_SPECIFIC_SENSOR = register("silkworm_specific_sensor", SilkwormSpecificSensor::new);
    public static final Supplier<SensorType<TemptingSensor>> SILK_MOTH_TEMPTATIONS = register("silk_moth_temptations", () -> new TemptingSensor(SilkMothAi.getTemptations()));
    public static final Supplier<SensorType<TemptingSensor>> SILKWORM_TEMPTATIONS = register("silkworm_temptations", () -> new TemptingSensor(SilkwormAi.getTemptations()));

    public static <U extends LivingEntity, T extends Sensor<U>> Supplier<SensorType<T>> register(String name, Supplier<T> sensorType) {
        return Services.REGISTRY.registerSensorType(name, () -> null);
    }

    public static void register() {

    }
}
