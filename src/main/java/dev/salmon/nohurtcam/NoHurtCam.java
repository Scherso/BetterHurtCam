package dev.salmon.nohurtcam;

import dev.salmon.nohurtcam.command.NoHurtCamCommand;
import dev.salmon.nohurtcam.config.Config;
import dev.salmon.nohurtcam.utils.SkyblockUtils;
import dev.salmon.nohurtcam.utils.Updater;
import gg.essential.api.EssentialAPI;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.io.File;

@Mod(name = NoHurtCam.NAME, version = NoHurtCam.VER, modid = NoHurtCam.ID)

public class NoHurtCam {
    public static final String NAME = "@NAME@", VER = "@VER@", ID = "@ID@";
    public static File jarFile;
    public static File modDir = new File(new File(Minecraft.getMinecraft().mcDataDir, "W-OVERFLOW"), NAME);
    public static Config config;

    public static void doHurtCam(float partialTicks) {
        int hurtCam = Config.adjustHurtCam;
        int lavaHurtCam = Config.adjustHurtCamInLava;
        if (EssentialAPI.getMinecraftUtil().isHypixel() && !SkyblockUtils.inSkyblock) {
            if (hurtCam < 6) {
                hurtCam = 6;
            }
            if (lavaHurtCam < 6) {
                lavaHurtCam = 6;
            }
        }
        EntityLivingBase entityLivingBase = (EntityLivingBase) Minecraft.getMinecraft().getRenderViewEntity();
        float f = (float)
                entityLivingBase.hurtTime - partialTicks;

        if (entityLivingBase.getHealth() <= 0.0f) {
            float f1 = (float)
                    entityLivingBase.deathTime + partialTicks;

            GlStateManager.rotate(40.0f - 8000.0f / (f1 + 200.0f), 0.0f, 0.0f, 1.0f);
        }

        if (f < 0.0f) {
            return;
        }

        f = f / (float)
                entityLivingBase.maxHurtTime;

        f = MathHelper.sin(f * f * f * f * (float) Math.PI);
        float f2 = entityLivingBase.attackedAtYaw;
        GlStateManager.rotate(-f2, 0.0f, 1.0f, 0.0f);

        if (Minecraft.getMinecraft().thePlayer.isInLava()) {
            GlStateManager.rotate(-f * (float) lavaHurtCam, 0.0f, 0.0f, 1.0f);
        } else {
            GlStateManager.rotate(-f * (float) hurtCam, 0.0f, 0.0f, 1.0f);
        }

        GlStateManager.rotate(f2, 0.0f, 1.0f, 0.0f);

    }

    @Mod.EventHandler
    protected void onFMLPreInitialization(FMLPreInitializationEvent event) {
        if (!modDir.exists()) modDir.mkdirs();
        jarFile = event.getSourceFile();
    }

    @Mod.EventHandler
    protected void onInitialization(FMLInitializationEvent event) {
        new NoHurtCamCommand().register();
        config = new Config();
        config.preload();
        MinecraftForge.EVENT_BUS.register(new SkyblockUtils());
        Updater.update();
    }

}
