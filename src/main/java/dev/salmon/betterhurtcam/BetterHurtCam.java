package dev.salmon.betterhurtcam;

import dev.salmon.betterhurtcam.command.BetterHurtCamCommand;
import dev.salmon.betterhurtcam.config.BetterHurtCamConfig;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(name = BetterHurtCam.NAME, version = BetterHurtCam.VER, modid = BetterHurtCam.ID)
public class BetterHurtCam {
    public static final String NAME = "@NAME@", VER = "@VER@", ID = "@ID@";

    @Mod.Instance
    public static BetterHurtCam Instance;
    private BetterHurtCamConfig config;

    @Mod.EventHandler
    protected void onInitialization(FMLInitializationEvent event) {
        new BetterHurtCamCommand().register();
        config = new BetterHurtCamConfig();
        config.preload();
    }

    public BetterHurtCamConfig getConfig() {
        return config;
    }

}
