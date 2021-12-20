package dev.salmon.betterhurtcam.config;

import dev.salmon.betterhurtcam.BetterHurtCam;
import dev.salmon.betterhurtcam.gui.DownloadGui;
import dev.salmon.betterhurtcam.utils.Updater;
import gg.essential.api.EssentialAPI;
import gg.essential.vigilance.Vigilant;
import gg.essential.vigilance.data.Property;
import gg.essential.vigilance.data.PropertyType;

import java.io.File;

public class Config extends Vigilant {

    @Property(
            type = PropertyType.NUMBER, name = "Adjust Hurt Camera Effect",
            description = "Adjust Minecraft's hurt animation.\nThis will automatically be limited to 6 on non-Skyblock Hypixel gamemodes. The default is 14.",
            category = "General",
            max = 100
    )
    public static int adjustHurtCam = 14;

    @Property(
            type = PropertyType.NUMBER, name = "Adjust Hurt Camera Effect in Lava",
            description = "Adjust Minecraft's hurt animation while in lava.\nThis will automatically be limited to 6 on non-Skyblock Hypixel gamemodes. The default is 14.",
            category = "General",
            subcategory = "Other",
            max = 100
    )
    public static int adjustHurtCamInLava = 14;

    @Property(
            type = PropertyType.SWITCH,
            name = "Show Update Notification",
            description = "Show a notification when you start Minecraft informing you of new updates.",
            category = "Updater"
    )
    public static boolean showUpdate = true;

    @Property(
            type = PropertyType.BUTTON,
            name = "Update Now",
            description = "Update by clicking the button.",
            category = "Updater"
    )
    public void update() {
        if (Updater.shouldUpdate) EssentialAPI.getGuiUtil()
                .openScreen(new DownloadGui());
        else EssentialAPI.getNotifications()
                .push(BetterHurtCam.NAME, "No update had been detected at startup, and thus the update GUI has not been shown.");
    }

    public Config() {
        super(new File(BetterHurtCam.modDir, "betterhurtcam.toml"), BetterHurtCam.NAME);
        initialize();
    }
}
