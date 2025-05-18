package com.teamabode.verdance.client.renderer;

import com.teamabode.verdance.Verdance;
import com.teamabode.verdance.client.model.SilkwormModel;
import com.teamabode.verdance.entity.silkworm.Silkworm;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class SilkwormEntityRenderer extends MobRenderer<Silkworm, SilkwormModel> {
    public static final ResourceLocation TEXTURE = Verdance.id("textures/entity/silkworm.png");

    public SilkwormEntityRenderer(EntityRendererProvider.Context context) {
        super(context, new SilkwormModel(context.bakeLayer(SilkwormModel.LAYER)), 0.25f);
    }

    @Override
    public ResourceLocation getTextureLocation(Silkworm entity) {
        return TEXTURE;
    }
}
