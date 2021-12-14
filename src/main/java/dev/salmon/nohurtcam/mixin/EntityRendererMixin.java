package dev.salmon.nohurtcam.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.entity.EntityLivingBase;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import dev.salmon.nohurtcam.NoHurtCam;

@Mixin(EntityRenderer.class)
public abstract class EntityRendererMixin {

    @SuppressWarnings("FieldMayBeFinal")
    private Minecraft mc = Minecraft.getMinecraft();

    /**
     * @author github.com/Scherso with the help of github.com/nxtdaydelivery
     */
    @Overwrite()
    private void hurtCameraEffect(float partialTicks) {
        if (this.mc.getRenderViewEntity() instanceof EntityLivingBase && ((EntityLivingBase)
                this.mc.getRenderViewEntity()).hurtTime > 0) {
            NoHurtCam.doHurtCam(partialTicks);
        }
    }

}