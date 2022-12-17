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

	@Property(
			type = PropertyType.DECIMAL_SLIDER,
			name = "Adjust Hurt Camera Effect",
			description = "Adjust Minecraft's hurt animation.",
			category = "General",
			maxF = 100.0F
	)
	private float animationMultiplier = 14.0F;

	@Property(
			type = PropertyType.DECIMAL_SLIDER,
			name = "Adjust Hurt Camera Effect in Lava",
			description = "Adjust Minecraft's hurt animation while in lava.",
			category = "General",
			subcategory = "Damage Types",
			maxF = 100.0F
	)
	private float multiplierInLava = 14.0F;

	@Property(
			type = PropertyType.DECIMAL_SLIDER,
			name = "Adjust Hurt Camera Effect While Burning",
			description = "Adjust Minecraft's hurt animation while on fire.",
			category = "General",
			subcategory = "Damage Types",
			maxF = 100.0F
	)
	private float multiplierIfBurning = 14.0F;

	public Config()
	{
		super(new File("./config", BetterHurtCam.ID + ".toml"), BetterHurtCam.NAME);
		initialize();
	}

	/**
	 * Used in {@link dev.salmon.betterhurtcam.asm.ClassTransformer} to set the effect multiplier, original being 14.0
	 * float.
	 *
	 * @return Multiplier values based on the damage type.
	 * @see dev.salmon.betterhurtcam.asm.ClassTransformer
	 */
	@SuppressWarnings("unused")
	public float getAnimationMultiplier()
	{
		if (Minecraft.getMinecraft().thePlayer.isInLava()) return (multiplierInLava);
		if (Minecraft.getMinecraft().thePlayer.isBurning()) return (multiplierIfBurning);
		return (animationMultiplier);
	}

	/**
	 * Used in {@link dev.salmon.betterhurtcam.command.BetterHurtCommand} to set the effect multiplier in a command.
	 *
	 * @param multiplier user set multiplier value.
	 * @see dev.salmon.betterhurtcam.command.BetterHurtCommand
	 */
	public void setAnimationMultiplier(float multiplier)
	{
		this.multiplierIfBurning = multiplier;
		this.multiplierInLava = multiplier;
		this.animationMultiplier = multiplier;
	}

	public void forceSaveConfig()
	{
		this.markDirty();
		this.writeData();
	}

}
