package com.greenone.weaponsplus.client.render;

import com.greenone.weaponsplus.WeaponsPlus;
import com.greenone.weaponsplus.common.item.tools.ShieldPlus;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.ShieldModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class ShieldRenderer extends BlockEntityWithoutLevelRenderer {
    private final ShieldModel normalModel;

    public ShieldRenderer(BlockEntityRenderDispatcher p_172550_, EntityModelSet p_172551_) {
        super(p_172550_, p_172551_);
        normalModel = new ShieldModel(p_172551_.bakeLayer(ModelLayers.SHIELD));
    }

    @Override
    public void renderByItem(ItemStack stack, ItemTransforms.@NotNull TransformType transformType, @NotNull PoseStack poseStack, @NotNull MultiBufferSource bufferSource, int p_108834_, int p_108835_) {
        poseStack.pushPose();
        poseStack.scale(1.0F, -1.0F, -1.0F);
        VertexConsumer ivertexbuilder = ItemRenderer.getFoilBufferDirect(bufferSource, this.normalModel.renderType(this.getTexture(stack)), true, stack.hasFoil());
        this.normalModel.handle().render(poseStack, ivertexbuilder, p_108834_, p_108835_, 1.0F, 1.0F, 1.0F, 1.0F);
        this.normalModel.plate().render(poseStack, ivertexbuilder, p_108834_, p_108835_, 1.0F, 1.0F, 1.0F, 1.0F);
        poseStack.popPose();
    }

    private ResourceLocation getTexture(ItemStack stack) {
        if(stack.getItem() instanceof ShieldPlus){
            return new ResourceLocation(WeaponsPlus.MOD_ID, "textures/entity/shield/" + ((ShieldPlus)stack.getItem()).getMetal().tagName() + "_shield.png");
        }else
            return new ResourceLocation("minecraft", "textures/entity/shield/shield.png");
    }
}
