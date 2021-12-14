package dev.salmon.nohurtcam;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import dev.salmon.nohurtcam.command.NoHurtCamCommand;
import dev.salmon.nohurtcam.config.Config;

import java.io.File;

@Mod(name = NoHurtCam.NAME, version = NoHurtCam.VER, modid = NoHurtCam.ID)

public class NoHurtCam {
    public static final String NAME = "@NAME@", VER = "@VER@", ID = "@ID@";
    public static File jarFile;
    public static File modDir = new File(new File(new File(Minecraft.getMinecraft().mcDataDir, "config"), "Salmon"), NAME);
    public static Config config;
    public static NoHurtCamCommand command;

    @SuppressWarnings("FieldMayBeFinal")
    private static Minecraft mc = Minecraft.getMinecraft();

    @Mod.EventHandler
    protected void onFMLPreInitialization(FMLPreInitializationEvent event) {
        if (!modDir.exists()) modDir.mkdirs();
        jarFile = event.getSourceFile();
    }

    @Mod.EventHandler
    protected void onInitialization(FMLInitializationEvent event) {
        command = new NoHurtCamCommand();
        command.register();
        config = new Config();
        config.preload();
    }

    public static void doHurtCam (float partialTicks) {
        EntityLivingBase entityLivingBase = (EntityLivingBase) mc.getRenderViewEntity();
        float f = (float)
                entityLivingBase.hurtTime - partialTicks;

        if (entityLivingBase.getHealth() <= 0.0f) {
            float f1 = (float)
                    entityLivingBase.deathTime + partialTicks;

            GlStateManager.rotate(40.0f - 8000.0f / (f1 + 200.0f), 0.0f,0.0f, 1.0f);
        }

        if (f < 0.0f) {
            return;
        }

        f = f / (float)
                entityLivingBase.maxHurtTime;

        f = MathHelper.sin(f * f * f * f * (float) Math.PI);
        float f2 = entityLivingBase.attackedAtYaw;
        GlStateManager.rotate(-f2, 0.0f, 1.0f, 0.0f);

        if (mc.thePlayer.isInLava()) {
            GlStateManager.rotate(-f * (float)Config.adjustHurtCamInLava, 0.0f, 0.0f, 1.0f);
        }
        else {
            GlStateManager.rotate(-f * (float)Config.adjustHurtCam, 0.0f, 0.0f, 1.0f);
        }

        GlStateManager.rotate(f2, 0.0f, 1.0f, 0.0f);

    }

}
