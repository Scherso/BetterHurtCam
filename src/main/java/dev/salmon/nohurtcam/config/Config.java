package dev.salmon.nohurtcam.config;

import dev.salmon.nohurtcam.NoHurtCam;
import gg.essential.vigilance.Vigilant;
import gg.essential.vigilance.data.Property;
import gg.essential.vigilance.data.PropertyType;

import java.io.File;

public class Config extends Vigilant {

    @Property(
            type = PropertyType.SLIDER, name = "Adjust Hurt Camera Effect",
            description = "Adjust Minecraft's hurt animation.",
            category = "General",
            min = 0,
            max = 100
    )
    public static int adjustHurtCam = 14;

    @Property(
            type = PropertyType.SLIDER, name = "Adjust Hurt Camera Effect in Lava",
            description = "Adjust Minecraft's hurt animation while in lava.",
            category = "General",
            subcategory = "Other",
            min = 0,
            max = 100
    )
    public static int adjustHurtCamInLava = 14;

    public Config() {
        super(new File(NoHurtCam.modDir, "nohurtcam.toml"), "NoHurtCam");
        initialize();
    }
}
