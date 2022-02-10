package dev.salmon.betterhurtcam.mixin;

import dev.salmon.betterhurtcam.config.BetterHurtCamConfig;
import dev.salmon.betterhurtcam.utils.HypixelUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.EntityRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

import java.lang.Math;

@Mixin(EntityRenderer.class)
public class EntityRendererMixin {

    @Shadow
    private Minecraft mc = Minecraft.getMinecraft();
    private boolean alternationHelperBool = false;

    @ModifyConstant(method = "hurtCameraEffect", constant = @Constant(floatValue = 14f))
    private float multiplyShake(float original) {
        float shake = getShake();
        int rotationMode = getRotationMode();
        if (shake < 0 && rotationMode == 0) { //absolue value to force camera to rotate right (Classic mode)
            shake = Math.abs(shake);
        } else if (rotationMode == 2) {
            if (alternationHelperBool) shake *= -1;
            alternationHelperBool = !alternationHelperBool;
        } else if (rotationMode == 3) {
            int randomNum = ((int)(Math.random() * 2)) + 1; //random value between 1 or 2
            if (randomNum == 1) shake *= -1;
        }
        if (HypixelUtils.inHypixel && !HypixelUtils.inSkyblock) {
            if (shake < 6) {
                shake = 6;
            }
            if (shake > -6) {
                shake = -6;
            }
        }
        return shake;
    }

    private int getRotationMode() {
        return (int) BetterHurtCamConfig.cameraRotationMode;
    }

    private float getShake() {
        if (mc.thePlayer.isInLava())
            return (float) BetterHurtCamConfig.adjustHurtCamInLava;
        if (mc.thePlayer.isInWater())
            return (float) BetterHurtCamConfig.adjustHurtCamInWater;
        if (mc.thePlayer.isBurning())
            return (float)BetterHurtCamConfig.adjustHurtCamIfBurning;
        else
            return (float)BetterHurtCamConfig.adjustHurtCam;
    }

}
