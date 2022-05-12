package dev.salmon.betterhurtcam.command;

import dev.salmon.betterhurtcam.BetterHurtCam;
import gg.essential.universal.ChatColor;
import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class Command extends CommandBase {

    public String getCommandName() {
        return BetterHurtCam.ID;
    }

    public String getCommandUsage(ICommandSender sender) {
        return "/" + this.getCommandName() + "<subcommand>";
    }

    public boolean canCommandSenderUseCommand(ICommandSender sender) {
        return true;
    }

    public void processCommand(ICommandSender sender, String[] args) {
        if (args.length > 0) {
            switch (args[0].toLowerCase()) {
                case "value":
                case "set":
                    if (args.length < 2) {
                        sender.addChatMessage(new ChatComponentText(ChatColor.WHITE + "[" + ChatColor.BLUE + "BetterHurtCam" + ChatColor.WHITE + "] " + ChatColor.RED + "Please enter a valid integer."));
                    }
                    else {
                        BetterHurtCam.Instance.getConfig().setHurtCam(args[1]);
                        sender.addChatMessage(new ChatComponentText(ChatColor.WHITE + "[" + ChatColor.BLUE + "BetterHurtCam" + ChatColor.WHITE + "] " + ChatColor.GREEN + "Intensity has been set to " + args[1] + "."));
                    }
                    break;
                default:
                    sender.addChatMessage(new ChatComponentText(ChatColor.RED + "Usage: " + this.getCommandName() + "<subcommand>"));
            }
        } else {
            MinecraftForge.EVENT_BUS.register(this);
        }
    }

    @SubscribeEvent
    public void onTick(TickEvent.ClientTickEvent event) {
        MinecraftForge.EVENT_BUS.unregister(this);
        Minecraft.getMinecraft().displayGuiScreen(BetterHurtCam.Instance.getConfig().gui());
    }

}
