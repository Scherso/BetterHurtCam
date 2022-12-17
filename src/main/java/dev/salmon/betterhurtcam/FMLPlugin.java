package dev.salmon.betterhurtcam;

import dev.salmon.betterhurtcam.asm.ClassTransformer;
import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

@IFMLLoadingPlugin.Name("FMLPlugin")
@IFMLLoadingPlugin.TransformerExclusions({"dev.salmon.betterhurtcam.asm"})
public class FMLPlugin implements IFMLLoadingPlugin
{

	/**
	 * To return a list of classes that implement ITransformer.
	 *
	 * @return list of classes that implement a transformer interface
	 */
	@NotNull
	@Override
	public final String[] getASMTransformerClass()
	{
		return (new String[] {ClassTransformer.class.getName()});
	}

	/**
	 * Return a class name that implements "ModContainer" for injection into the mod list.
	 *
	 * @return null
	 */
	@Nullable
	@Override
	public final String getModContainerClass()
	{
		return (null);
	}

	/**
	 * Return the class name of an implementor of "IFMLCallHook", that will be run, in the main thread.
	 *
	 * @return null
	 */
	@Nullable
	@Override
	public final String getSetupClass()
	{
		return (null);
	}


	/**
	 * @param map list of string and object
	 */
	@Override
	public void injectData(Map<String, Object> map)
	{
		/* Hello! */
	}

	/**
	 * Return an optional access transformer class for this coremod.
	 *
	 * @return null
	 */
	@Nullable
	@Override
	public final String getAccessTransformerClass()
	{
		return (null);
	}

}
