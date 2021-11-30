package dev.salmon.nohurtcam;

import net.minecraft.client.Minecraft;
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

    @Mod.EventHandler
    protected void onFMLPreInitialization(FMLPreInitializationEvent event) {
        if (!modDir.exists()) modDir.mkdirs();
        jarFile = event.getSourceFile();
    }

// FMLPreInitialization event above is originally from the mod: Damage Tint 3.1.0 by Qalcyo org.

    @Mod.EventHandler
    protected void onInitialization(FMLInitializationEvent event) {
        command = new NoHurtCamCommand();
        command.register();
        config = new Config();
        config.preload();
    }

}
