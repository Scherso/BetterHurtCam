package dev.salmon.betterhurtcam.config;

import dev.salmon.betterhurtcam.BetterHurtCam;
import gg.essential.vigilance.Vigilant;
import gg.essential.vigilance.data.Property;
import gg.essential.vigilance.data.PropertyType;

import java.io.File;

public class BetterHurtCamConfig extends Vigilant {

    // Main

    @Property(
            type = PropertyType.SLIDER, name = "Adjust Hurt Camera Effect",
            description = "Adjust Minecraft's hurt animation.\nThis will automatically be limited to 6 on non-Skyblock Hypixel gamemodes. The default is 14.",
            category = "General",
            max = 100
    )
    public static int adjustHurtCam = 14;

    @Property(
            type = PropertyType.SLIDER,
            name = "Adjust Hurt Camera Effect in Lava",
            description = "Adjust Minecraft's hurt animation while in lava.\nThis will automatically be limited to 6 on non-Skyblock Hypixel gamemodes. The default is 14.",
            category = "General",
            subcategory = "Damage Types",
            max = 100
    )
    public static int adjustHurtCamInLava = 14;

    @Property(
            type = PropertyType.SLIDER,
            name = "Adjust Hurt Camera Effect WWhile Burning",
            description = "Adjust Minecraft's hurt animation while on fire.\nThis will automatically be limited to 6 on non-Skyblock Hypixel gamemodes. The default is 14.",
            category = "General",
            subcategory = "Damage Types",
            max = 100
    )
    public static int adjustHurtCamIfBurning = 14;

    public BetterHurtCamConfig() {
        super(new File(BetterHurtCam.modDir, "betterhurtcam.toml"), BetterHurtCam.NAME);
        initialize();
    }
}
