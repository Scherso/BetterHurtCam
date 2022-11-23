package dev.salmon.betterhurtcam.config;

import dev.salmon.betterhurtcam.BetterHurtCam;
import gg.essential.vigilance.Vigilant;
import gg.essential.vigilance.data.Property;
import gg.essential.vigilance.data.PropertyType;
import net.minecraft.client.Minecraft;

import java.io.File;

@SuppressWarnings("FieldMayBeFinal")
public class Config extends Vigilant
{

    public Config()
    {
        super(new File("./config", BetterHurtCam.ID + ".toml"), BetterHurtCam.NAME);
        initialize();
    }

    @Property(
            type = PropertyType.DECIMAL_SLIDER,
            name = "Adjust Hurt Camera Effect",
            description = "Adjust Minecraft's hurt animation.",
            category = "General",
            maxF = 100.0F
    )
    private static float animationMultiplier = 14.0F;


    @Property(
            type = PropertyType.DECIMAL_SLIDER,
            name = "Adjust Hurt Camera Effect in Lava",
            description = "Adjust Minecraft's hurt animation while in lava.",
            category = "General",
            subcategory = "Damage Types",
            maxF = 100.0F
    )
    private static float multiplierInLava = 14.0F;

    @Property(
            type = PropertyType.DECIMAL_SLIDER,
            name = "Adjust Hurt Camera Effect While Burning",
            description = "Adjust Minecraft's hurt animation while on fire.",
            category = "General",
            subcategory = "Damage Types",
            maxF = 100.0F
    )
    private static float multiplierIfBurning = 14.0F;

    @SuppressWarnings("unused")
    public static float getAnimationMultiplier()
    {
        if (Minecraft.getMinecraft().thePlayer.isInLava())  return (multiplierInLava);
        if (Minecraft.getMinecraft().thePlayer.isBurning()) return (multiplierIfBurning);
        return (animationMultiplier);
    }

    public void setAnimationMultiplier(float multiplier)
    {
        multiplierIfBurning = multiplier;
        multiplierInLava    = multiplier;
        animationMultiplier = multiplier;
    }

    public void forceSaveConfig()
    {
        this.markDirty();
        this.writeData();
    }

}
