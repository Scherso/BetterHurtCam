package dev.salmon.betterhurtcam.mixin;

import dev.salmon.betterhurtcam.BetterHurtCam;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.EntityRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(EntityRenderer.class)
public class EntityRendererMixin {

    @ModifyConstant(method = "hurtCameraEffect", constant = @Constant(floatValue = 14f))
    private float multiplyShake(float original) {
        if (Minecraft.getMinecraft().thePlayer.isInLava())
            return (float) BetterHurtCam.Instance.getConfig().getAdjustHurtCamInLava();
        if (Minecraft.getMinecraft().thePlayer.isBurning())
            return (float) BetterHurtCam.Instance.getConfig().getAdjustHurtCamIfBurning();
        else
            return (float) BetterHurtCam.Instance.getConfig().getAdjustHurtCam();
    }

}
