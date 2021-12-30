package dev.salmon.betterhurtcam.config;

import dev.salmon.betterhurtcam.BetterHurtCam;
import dev.salmon.betterhurtcam.gui.DownloadGui;
import dev.salmon.betterhurtcam.utils.Updater;
import gg.essential.api.EssentialAPI;
import gg.essential.vigilance.Vigilant;
import gg.essential.vigilance.data.Property;
import gg.essential.vigilance.data.PropertyType;

import java.io.File;

public class BetterHurtCamConfig extends Vigilant {

    public BetterHurtCamConfig() {
        super(new File(BetterHurtCam.modDir, "betterhurtcam.toml"), BetterHurtCam.NAME);
        initialize();
    }

    // Main

    @Property(
            type = PropertyType.SLIDER, name = "Adjust Hurt Camera Effect",
            description = "Adjust Minecraft's hurt animation.\nThis will automatically be limited to 6 on non-Skyblock Hypixel gamemodes. The default is 14.",
            category = "General",
            min = 0,
            max = 100
    )
    private int adjustHurtCam = 14;

    @Property(
            type = PropertyType.SLIDER,
            name = "Adjust Hurt Camera Effect in Lava",
            description = "Adjust Minecraft's hurt animation while in lava.\nThis will automatically be limited to 6 on non-Skyblock Hypixel gamemodes. The default is 14.",
            category = "General",
            subcategory = "Damage Types",
            min = 0,
            max = 100
    )
    private int adjustHurtCamInLava = 14;

    @Property(
            type = PropertyType.SLIDER,
            name = "Adjust Hurt Camera Effect WWhile Burning",
            description = "Adjust Minecraft's hurt animation while on fire.\nThis will automatically be limited to 6 on non-Skyblock Hypixel gamemodes. The default is 14.",
            category = "General",
            subcategory = "Damage Types",
            min = 0,
            max = 100
    )
    private int adjustHurtCamIfBurning = 14;

    // Updater

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

    // Getters

    public int getAdjustHurtCam() {
        return adjustHurtCam;
    }

    public int getAdjustHurtCamInLava() {
        return adjustHurtCamInLava;
    }

    public int getAdjustHurtCamIfBurning() {
        return adjustHurtCamIfBurning;
    }
}
