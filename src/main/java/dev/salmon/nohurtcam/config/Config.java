package dev.salmon.nohurtcam.config;

import dev.salmon.nohurtcam.NoHurtCam;
import gg.essential.vigilance.Vigilant;
import gg.essential.vigilance.data.Property;
import gg.essential.vigilance.data.PropertyType;

import java.io.File;

public class Config extends Vigilant {
    @Property(
            type = PropertyType.SWITCH, name = "Hurt Animation Remover",
            description = "Removes the shake animation that happens upon being hurt or hit.",
            category = "General"
    )
    public static boolean noHurtCam = true;

    public Config() {
        super(new File(NoHurtCam.modDir, "nohurtcam.toml"), "NoHurtCam");
        initialize();
    }
}
