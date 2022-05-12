package dev.salmon.betterhurtcam.config;

import dev.salmon.betterhurtcam.BetterHurtCam;
import gg.essential.vigilance.Vigilant;
import gg.essential.vigilance.data.Property;
import gg.essential.vigilance.data.PropertyType;

import java.io.File;

public class BetterHurtCamConfig extends Vigilant {

    public BetterHurtCamConfig() {
        super(new File("./config", BetterHurtCam.ID + ".toml"), BetterHurtCam.NAME);
    }
    @Property(
            type = PropertyType.NUMBER,
            name = "Adjust Hurt Camera Effect",
            description = "Adjust Minecraft's hurt animation.",
            category = "General",
            max = 100
    )
    private int adjustHurtCam = 14;

    @Property(
            type = PropertyType.NUMBER,
            name = "Adjust Hurt Camera Effect in Lava",
            description = "Adjust Minecraft's hurt animation while in lava.",
            category = "General",
            subcategory = "Damage Types",
            max = 100
    )
    private int adjustHurtCamInLava = 14;

    @Property(
            type = PropertyType.NUMBER,
            name = "Adjust Hurt Camera Effect WWhile Burning",
            description = "Adjust Minecraft's hurt animation while on fire.",
            category = "General",
            subcategory = "Damage Types",
            max = 100
    )
    private int adjustHurtCamIfBurning = 14;

    public int getAdjustHurtCam() {
        return this.adjustHurtCam;
    }

    public int getAdjustHurtCamInLava() {
        return this.adjustHurtCamInLava;
    }

    public int getAdjustHurtCamIfBurning() {
        return this.adjustHurtCamIfBurning;
    }

    public void setHurtCam(String hurtCam) {
        this.adjustHurtCam = Integer.parseInt(hurtCam);
        this.adjustHurtCamInLava = Integer.parseInt(hurtCam);
        this.adjustHurtCamIfBurning = Integer.parseInt(hurtCam);
    }

}
