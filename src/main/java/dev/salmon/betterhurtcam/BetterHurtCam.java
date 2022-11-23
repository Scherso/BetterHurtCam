package dev.salmon.betterhurtcam;

import dev.salmon.betterhurtcam.command.BetterHurtCommand;
import dev.salmon.betterhurtcam.config.Config;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(name = BetterHurtCam.NAME, version = BetterHurtCam.VER, modid = BetterHurtCam.ID)
public class BetterHurtCam
{

    public static final String NAME = "@NAME@", VER = "@VERSION@", ID = "@ID@";

    @Mod.Instance
    public static BetterHurtCam INSTANCE;

    private final Config CONFIG = new Config();

    @Mod.EventHandler
    protected void onInitialization(FMLInitializationEvent event)
    {
        CONFIG.preload();
        new BetterHurtCommand().register();
        MinecraftForge.EVENT_BUS.register(this);
    }

    public Config getConfig()
    {
        return (this.CONFIG);
    }

}
