package dev.salmon.betterhurtcam.mixin;

import dev.salmon.betterhurtcam.config.BetterHurtCamConfig;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.EntityRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(EntityRenderer.class)
public class EntityRendererMixin {

    @Shadow
    private Minecraft mc = Minecraft.getMinecraft();

    @ModifyConstant(method = "hurtCameraEffect", constant = @Constant(floatValue = 14f))
    private float multiplyShake(float original) {
        if (mc.thePlayer.isInLava())
            return (float) BetterHurtCamConfig.adjustHurtCamInLava;
        if (mc.thePlayer.isBurning())
            return (float)BetterHurtCamConfig.adjustHurtCamIfBurning;
        else
            return (float)BetterHurtCamConfig.adjustHurtCam;
    }

}
