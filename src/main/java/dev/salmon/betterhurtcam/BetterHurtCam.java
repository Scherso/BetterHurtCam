package dev.salmon.betterhurtcam;

import dev.salmon.betterhurtcam.command.Command;
import dev.salmon.betterhurtcam.config.Config;
import net.minecraft.command.ICommand;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import java.util.Arrays;

@Mod(name = BetterHurtCam.NAME, version = BetterHurtCam.VER, modid = BetterHurtCam.ID)
public class BetterHurtCam {
    public static final String NAME = "@NAME@", VER = "@VER@", ID = "@ID@";

    @Mod.Instance
    public static BetterHurtCam Instance;
    private Config config;

    public static void registerCommands(ICommand... command) {
        Arrays.stream(command).forEachOrdered(ClientCommandHandler.instance::registerCommand);
    }

    @Mod.EventHandler
    protected void onInitialization(FMLInitializationEvent event) {
        config = new Config();
        config.preload();

        registerCommands(
                new Command()
        );
    }

    public Config getConfig() {
        return config;
    }

}
