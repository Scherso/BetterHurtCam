package dev.salmon.betterhurtcam.command;

import dev.salmon.betterhurtcam.BetterHurtCam;
import gg.essential.api.commands.*;
import gg.essential.api.utils.GuiUtil;
import gg.essential.universal.ChatColor;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ChatComponentText;

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

    @SubCommand(value = "set", description = "Set the hurt animation multiplier, Minecraft's default is 14.")
    public void set(@DisplayName("multiplier") int multiplier)
    {
        BetterHurtCam.INSTANCE.getConfig().setAnimationMultiplier(multiplier);
        BetterHurtCam.INSTANCE.getConfig().forceSaveConfig();
        Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(ChatColor.WHITE + "[" + ChatColor.BLUE + "BetterHurtCam" + ChatColor.WHITE + "] " + ChatColor.GREEN + "Multiplier has been set to " + multiplier + "."));
    }

}

