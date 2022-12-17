package dev.salmon.betterhurtcam.command;

import dev.salmon.betterhurtcam.BetterHurtCam;
import gg.essential.api.commands.Command;
import gg.essential.api.commands.DefaultHandler;
import gg.essential.api.commands.DisplayName;
import gg.essential.api.commands.SubCommand;
import gg.essential.api.utils.GuiUtil;
import gg.essential.universal.ChatColor;
import gg.essential.universal.UChat;
import net.minecraft.client.gui.GuiScreen;

import java.util.Objects;

@SuppressWarnings("unused")
public class BetterHurtCommand extends Command
{

	public BetterHurtCommand()
	{
		super(BetterHurtCam.NAME);
	}

	@DefaultHandler
	public void handle()
	{
		GuiUtil.open(Objects.requireNonNull((GuiScreen) BetterHurtCam.INSTANCE.getConfig().gui()));
	}

	/**
	 * Setting the multiplier for the hurt effect with
	 * {@link dev.salmon.betterhurtcam.config.Config#setAnimationMultiplier(float)}.
	 *
	 * @param multiplier the multiplier value to set.
	 */
	@SubCommand(value = "set", description = "Set the hurt animation multiplier, Minecraft's default is 14.")
	public void set(@DisplayName("multiplier") int multiplier)
	{
		BetterHurtCam.INSTANCE.getConfig().setAnimationMultiplier(multiplier);
		BetterHurtCam.INSTANCE.getConfig().forceSaveConfig();
		UChat.chat(ChatColor.WHITE + "[" + ChatColor.BLUE + "BetterHurtCam" + ChatColor.WHITE + "] " + ChatColor.GREEN + "Multiplier has been set to " + multiplier + ".");
	}

}

