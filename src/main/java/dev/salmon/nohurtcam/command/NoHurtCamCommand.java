package dev.salmon.nohurtcam.command;

import dev.salmon.nohurtcam.NoHurtCam;
import gg.essential.api.EssentialAPI;
import gg.essential.api.commands.Command;
import gg.essential.api.commands.DefaultHandler;

public class NoHurtCamCommand extends Command {
    public NoHurtCamCommand() {
        super("nohurtcam", true);
    }

    @DefaultHandler
    public void handle() {
        EssentialAPI.getGuiUtil().openScreen(NoHurtCam.config.gui());
    }
}
