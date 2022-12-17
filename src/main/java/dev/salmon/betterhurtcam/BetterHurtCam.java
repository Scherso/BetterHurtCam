package dev.salmon.betterhurtcam;

import dev.salmon.betterhurtcam.command.BetterHurtCommand;
import dev.salmon.betterhurtcam.config.Config;
import gg.essential.universal.ChatColor;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.ModMetadata;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(
		name = BetterHurtCam.NAME,
		version = BetterHurtCam.VER,
		modid = BetterHurtCam.ID
)
public class BetterHurtCam
{

	public static final String NAME = "@NAME@", VER = "@VERSION@", ID = "@ID@";

	@Mod.Instance(ID)
	public static BetterHurtCam INSTANCE;

	private final Config CONFIG = new Config();

	@Mod.EventHandler
	protected void onInitialization(FMLInitializationEvent event)
	{
		CONFIG.preload();
		new BetterHurtCommand().register();
		MinecraftForge.EVENT_BUS.register(this);
	}

	@Mod.EventHandler
	public void preInitialization(FMLPreInitializationEvent event)
	{
		ModMetadata data = event.getModMetadata();
		data.name = "Better" + ChatColor.RED + "Hurt" + ChatColor.WHITE + "Cam" + ChatColor.RESET;
		data.description = "A mod that allows the player to adjust the " + ChatColor.RED + "hurt" + ChatColor.RESET + " animation upon being damaged in " + ChatColor.GREEN + "Minecraft" + ChatColor.RESET + ".";
	}

	public Config getConfig()
	{
		return (this.CONFIG);
	}

}
