package com.teamabode.verdance.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import com.teamabode.verdance.Verdance;
import com.teamabode.verdance.block.SilkCocoonBlock;
import com.teamabode.verdance.block.entity.SilkCocoonBlockEntity;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.resources.model.Material;
import net.minecraft.core.Direction;
import net.minecraft.util.Mth;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.level.block.state.BlockState;
import org.joml.Quaternionf;

public class SilkCocoonBlockEntityRenderer implements BlockEntityRenderer<SilkCocoonBlockEntity> {
    public static final ModelLayerLocation MODEL_LAYER = new ModelLayerLocation(Verdance.id("silk_cocoon"), "main");
    public static final Material TEXTURE_LOCATION = new Material(InventoryMenu.BLOCK_ATLAS, Verdance.id("entity/silk_cocoon"));

    private final ModelPart cocoon;

    public SilkCocoonBlockEntityRenderer(BlockEntityRendererProvider.Context context) {
        ModelPart root = context.bakeLayer(MODEL_LAYER);
        this.cocoon = root.getChild("cocoon");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();

        root.addOrReplaceChild(
                "cocoon",
                CubeListBuilder.create().texOffs(0, 0).addBox(3,0, 6, 10.0f, 12.0f, 10.0f),
                PartPose.ZERO
        );
        return LayerDefinition.create(mesh, 64, 32);
    }

    @Override
    public void render(SilkCocoonBlockEntity cocoon, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int i, int j) {
        poseStack.pushPose();
        VertexConsumer vertex = TEXTURE_LOCATION.buffer(bufferSource, RenderType::entitySolid);
        BlockState state = cocoon.getBlockState();
        Direction dir = state.getValue(SilkCocoonBlock.FACING);

        float deltaTicks = (cocoon.wobbleTicks + partialTick);
        float wobble = Mth.sin(deltaTicks * 3.0f / Mth.PI) * (5.0f * Mth.DEG_TO_RAD);

        Quaternionf rotation;

        if (dir == Direction.NORTH || dir == Direction.SOUTH) {
            rotation = Axis.ZP.rotation(wobble);
        }
        else {
            rotation = Axis.XP.rotation(wobble);
        }
        if (cocoon.wobbling) {
            poseStack.rotateAround(rotation, 0.5f, 0.5f, 0.5f);
        }
        // Rotates the cocoon based off the direction it's facing.
        // Translating 0.5f and back will shift the pivot point for this rotation.
        poseStack.translate(0.5f, 0.5f, 0.5f);
        poseStack.mulPose(Axis.YP.rotationDegrees(-dir.toYRot()));
        poseStack.translate(-0.5f, -0.5f, -0.5f);

        this.cocoon.render(poseStack, vertex, i, j);
        poseStack.popPose();
    }
}
