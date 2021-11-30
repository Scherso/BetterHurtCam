package dev.salmon.nohurtcam.mixin;

import net.minecraft.client.renderer.EntityRenderer;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import dev.salmon.nohurtcam.config.Config;

@Mixin(EntityRenderer.class)
public abstract class EntityRendererMixin {
    @Inject(method = "hurtCameraEffect", at = @At("HEAD"), cancellable = true)

    private void onHurtCam(float partialTicks, CallbackInfo ci) {
        if (Config.noHurtCam)
        ci.cancel();
    }

}