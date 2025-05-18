package com.teamabode.verdance.client;

import com.teamabode.verdance.client.model.SilkMothModel;
import com.teamabode.verdance.client.model.SilkwormModel;
import com.teamabode.verdance.client.renderer.SilkCocoonBlockEntityRenderer;
import com.teamabode.verdance.client.renderer.SilkMothEntityRenderer;
import com.teamabode.verdance.client.renderer.SilkwormEntityRenderer;
import com.teamabode.verdance.registry.VerdanceBlockEntityTypes;
import com.teamabode.verdance.registry.VerdanceBlocks;
import com.teamabode.verdance.registry.VerdanceEntityTypes;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.entity.NoopRenderer;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.block.state.BlockState;

public class VerdanceFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        registerModelLayers();
        registerRenderers();
        setRenderTypes();
        addColorProviders();
    }

    private static void registerModelLayers() {
        EntityModelLayerRegistry.registerModelLayer(SilkMothModel.LAYER, SilkMothModel::createBodyLayer);
        EntityModelLayerRegistry.registerModelLayer(SilkwormModel.LAYER, SilkwormModel::createBodyLayer);
        EntityModelLayerRegistry.registerModelLayer(SilkCocoonBlockEntityRenderer.MODEL_LAYER, SilkCocoonBlockEntityRenderer::createBodyLayer);
    }

    private static void registerRenderers() {
        EntityRendererRegistry.register(VerdanceEntityTypes.SILK_MOTH.get(), SilkMothEntityRenderer::new);
        EntityRendererRegistry.register(VerdanceEntityTypes.SILKWORM.get(), SilkwormEntityRenderer::new);
        EntityRendererRegistry.register(VerdanceEntityTypes.CUSHION.get(), NoopRenderer::new);
        BlockEntityRenderers.register(VerdanceBlockEntityTypes.SILK_COCOON.get(), SilkCocoonBlockEntityRenderer::new);
    }

    private static void setRenderTypes() {
        BlockRenderLayerMap.INSTANCE.putBlock(VerdanceBlocks.MULBERRY_LEAVES.get(), RenderType.cutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(VerdanceBlocks.MULBERRY_SAPLING.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(VerdanceBlocks.POTTED_MULBERRY_SAPLING.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(VerdanceBlocks.ATTACHED_CANTALOUPE_STEM.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(VerdanceBlocks.CANTALOUPE_STEM.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(VerdanceBlocks.MULBERRY_DOOR.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(VerdanceBlocks.MULBERRY_TRAPDOOR.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(VerdanceBlocks.SILKWORM_EGGS.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(VerdanceBlocks.SILK_COCOON.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(VerdanceBlocks.VIOLET.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(VerdanceBlocks.POTTED_VIOLET.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(VerdanceBlocks.SHRUB.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(VerdanceBlocks.POTTED_SHRUB.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(VerdanceBlocks.YELLOW_FLOWERING_SHRUB.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(VerdanceBlocks.POTTED_YELLOW_FLOWERING_SHRUB.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(VerdanceBlocks.PINK_FLOWERING_SHRUB.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(VerdanceBlocks.POTTED_PINK_FLOWERING_SHRUB.get(), RenderType.cutout());
    }

    private static void addColorProviders() {
        ColorProviderRegistry.BLOCK.register(
                (state, tintGetter, pos, i) ->
                        tintGetter != null && pos != null ? BiomeColors.getAverageFoliageColor(tintGetter, pos) : FoliageColor.getDefaultColor(),
                VerdanceBlocks.MULBERRY_LEAVES.get(),
                VerdanceBlocks.FLOWERING_MULBERRY_LEAVES.get()
        );
        ColorProviderRegistry.ITEM.register((stack, i) -> {
            BlockState state = ((BlockItem) stack.getItem()).getBlock().defaultBlockState();

            return Minecraft.getInstance().getBlockColors().getColor(state, null, null, i);
        }, VerdanceBlocks.MULBERRY_LEAVES.get(), VerdanceBlocks.FLOWERING_MULBERRY_LEAVES.get());
    }
}
