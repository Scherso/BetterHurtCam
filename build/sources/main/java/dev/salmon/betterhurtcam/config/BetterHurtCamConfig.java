package dev.salmon.betterhurtcam.config;

import dev.salmon.betterhurtcam.BetterHurtCam;
import gg.essential.vigilance.Vigilant;
import gg.essential.vigilance.data.Property;
import gg.essential.vigilance.data.PropertyType;

import java.io.File;

public class BetterHurtCamConfig extends Vigilant {

    // Main

    @Property(
        type = PropertyType.SELECTOR,
        name = "Camera Rotation Mode",
        description =   "Select your desired camera rotation mode for all damage sources.\n\n" +
                        "Classic: Standard Minecraft camera rotation (to the right). [If you have negative config values on this mode, they will be treated as positive values.]\n\n" +
                        "Classic+: Standard Minecraft camera rotation, but in both left or right (depending on your config values).\n\n" +
                        "Alternating: Camera rotations alternate between left and right (ie: left, right, left, right, etc...)\n\n" +
                        "Random: Fully randomizes camera rotation directions.",
        category = "General",
        options = {"Classic", "Classic+", "Alternating", "Random"}
    )
    public static int cameraRotationMode = 0;

    @Property(
            type = PropertyType.SLIDER, name = "Adjust Hurt Camera Effect",
            description = "Adjust Minecraft's hurt animation.\n\nThis will automatically be limited to 6 on non-Skyblock Hypixel gamemodes. The default is 14.",
            category = "General",
            min = -100, max = 100
    )
    public static int adjustHurtCam = 14;

    @Property(
            type = PropertyType.SLIDER,
            name = "Adjust Hurt Camera Effect in Lava",
            description = "Adjust Minecraft's hurt animation while in lava.\n\nThis will automatically be limited to 6 on non-Skyblock Hypixel gamemodes. The default is 14.",
            category = "General", subcategory = "Damage Types",
            min = -100, max = 100
    )
    public static int adjustHurtCamInLava = 14;

    @Property(
            type = PropertyType.SLIDER,
            name = "Adjust Hurt Camera Effect While Drowning",
            description = "Adjust Minecraft's hurt animation while drowning in water.\n\nThis will automatically be limited to 6 on non-Skyblock Hypixel gamemodes. The default is 14.",
            category = "General", subcategory = "Damage Types",
            min = -100, max = 100
    )
    public static int adjustHurtCamInWater = 14;

    @Property(
            type = PropertyType.SLIDER,
            name = "Adjust Hurt Camera Effect While Burning",
            description = "Adjust Minecraft's hurt animation while on fire.\n\nThis will automatically be limited to 6 on non-Skyblock Hypixel gamemodes. The default is 14.",
            category = "General", subcategory = "Damage Types",
            min = -100, max = 100
    )
    public static int adjustHurtCamIfBurning = 14;

    public BetterHurtCamConfig() {
        super(new File(BetterHurtCam.modDir, "betterhurtcam.toml"), BetterHurtCam.NAME);
        initialize();
    }
}
