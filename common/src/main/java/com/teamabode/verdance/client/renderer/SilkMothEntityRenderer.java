package com.teamabode.verdance.client.renderer;

import com.teamabode.verdance.Verdance;
import com.teamabode.verdance.client.model.SilkMothModel;
import com.teamabode.verdance.entity.silkmoth.SilkMoth;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class SilkMothEntityRenderer extends MobRenderer<SilkMoth, SilkMothModel> {
    private static final ResourceLocation TEXTURE = Verdance.id("textures/entity/silk_moth/silk_moth.png");

    public SilkMothEntityRenderer(EntityRendererProvider.Context context) {
        super(context, new SilkMothModel(context.bakeLayer(SilkMothModel.LAYER)), 0.5f);
        this.addLayer(new SilkMothEyesLayer(this));
    }

    @Override
    public ResourceLocation getTextureLocation(SilkMoth entity) {
        return TEXTURE;
    }
}
