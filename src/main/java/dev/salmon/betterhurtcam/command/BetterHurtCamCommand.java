package dev.salmon.betterhurtcam.command;

import dev.salmon.betterhurtcam.BetterHurtCam;
import gg.essential.api.EssentialAPI;
import gg.essential.api.commands.Command;
import gg.essential.api.commands.DefaultHandler;

public class BetterHurtCamCommand extends Command {
    public BetterHurtCamCommand() {
        super("betterhurtcam", true);
    }

    @DefaultHandler
    public void handle() {
        EssentialAPI.getGuiUtil().openScreen(BetterHurtCam.Instance.getConfig().gui());
    }
}
