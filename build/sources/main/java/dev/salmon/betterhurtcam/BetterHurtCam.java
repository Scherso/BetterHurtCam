package dev.salmon.betterhurtcam;

import dev.salmon.betterhurtcam.command.BetterHurtCamCommand;
import dev.salmon.betterhurtcam.config.BetterHurtCamConfig;
import dev.salmon.betterhurtcam.utils.HypixelUtils;
import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.io.File;

@Mod(name = BetterHurtCam.NAME, version = BetterHurtCam.VER, modid = BetterHurtCam.ID)
public class BetterHurtCam {
    public static final String NAME = "BetterHurtCam", VER = "2.1.3", ID = "betterhurtcam";
    public static File modDir = new File(new File(Minecraft.getMinecraft().mcDataDir, "W-OVERFLOW"), NAME);
    public static BetterHurtCamConfig config;

    @Mod.EventHandler
    protected void onFMLPreInitialization(FMLPreInitializationEvent event) {
        if (!modDir.exists()) modDir.mkdirs();
    }

    @Mod.EventHandler
    protected void onInitialization(FMLInitializationEvent event) {
        new BetterHurtCamCommand().register();
        config = new BetterHurtCamConfig();
        config.preload();
        MinecraftForge.EVENT_BUS.register(new HypixelUtils());
    }

}
