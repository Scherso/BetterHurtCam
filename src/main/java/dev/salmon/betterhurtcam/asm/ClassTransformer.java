package dev.salmon.betterhurtcam.asm;

import dev.salmon.betterhurtcam.config.Config;
import net.minecraft.launchwrapper.IClassTransformer;
import net.minecraftforge.fml.common.asm.transformers.deobf.FMLDeobfuscatingRemapper;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.tree.*;

import static org.objectweb.asm.Opcodes.*;

public class ClassTransformer implements IClassTransformer
{

	/**
	 * <pre>
	 *     Grabs value {@link Config#getAnimationMultiplier()} and replaces the original
	 *     value of 14.0F with the user set value.
	 *
	 *     FOR REFERENCE:
	 *     {@link InsnList#set(AbstractInsnNode, AbstractInsnNode)} Replaces an instruction
	 *     of this list with another instruction.
	 *     {@link org.objectweb.asm.Opcodes#LDC} Pushes a constant from the pool onto the
	 *     stack.
	 * </pre>
	 *
	 * @param name            name of the class being transformed.
	 * @param transformedName name of the class being transformed.
	 * @param bytes           bytes to return to writer.
	 * @return writer to bytes.
	 * @see net.minecraft.client.renderer.EntityRenderer
	 * @see Config
	 */
	@Override
	public byte[] transform(String name, String transformedName, byte[] bytes)
	{
		if (!transformedName.equals("net.minecraft.client.renderer.EntityRenderer")) return (bytes);

		final ClassReader READER = new ClassReader(bytes);
		final ClassNode   NODE   = new ClassNode();
		READER.accept(NODE, 0);

		for (MethodNode method : NODE.methods)
		{
			String methodName = FMLDeobfuscatingRemapper.INSTANCE.mapMethodName(NODE.name, method.name, method.desc);
			if (methodName.equals("hurtCameraEffect") || methodName.equals("func_78482_e"))
			{
				for (final AbstractInsnNode INSN : method.instructions.toArray())
				{
					if (INSN.getOpcode() == LDC && ((LdcInsnNode) INSN).cst.equals(14.0F))
					{
						method.instructions.insertBefore(INSN.getNext(), this.invokeConfigValue());
						method.instructions.remove(INSN);
					}
				}
			}
		}

		final ClassWriter WRITER = new ClassWriter(READER, 0);
		NODE.accept(WRITER);
		return (WRITER.toByteArray());
	}

	/**
	 * <pre>
	 *     BYTECODE INSTRUCTIONS ARE EQUIVALENT TO:
	 *     {@code BetterHurtCam.INSTANCE.getConfig().getAnimationMultiplier();}
	 *
	 *     FOR REFERENCE:
	 *     {@link org.objectweb.asm.Opcodes#GETSTATIC} Gets a static field value from a class.
	 *     {@link org.objectweb.asm.Opcodes#INVOKEVIRTUAL} Invokes a virtual method defined by
	 *     the owner class and the method’s name and desc on object, objects are
	 *     then put on the stack, where they may or may not be void.
	 * </pre>
	 *
	 * @return a list of instructions to invoke {@link Config#getAnimationMultiplier()}.
	 */
	private InsnList invokeConfigValue()
	{
		final InsnList INSN_LIST = new InsnList();
		INSN_LIST.add(new MethodInsnNode(GETSTATIC, "dev/salmon/betterhurtcam/BetterHurtCam", "INSTANCE", "Ldev/salmon/betterhurtcam/BetterHurtCam;", false));
		INSN_LIST.add(new MethodInsnNode(INVOKEVIRTUAL, "dev/salmon/betterhurtcam/BetterHurtCam", "getConfig", "()Ldev/salmon/betterhurtcam/config/Config;", false));
		INSN_LIST.add(new MethodInsnNode(INVOKEVIRTUAL, "dev/salmon/betterhurtcam/config/Config", "getAnimationMultiplier", "()F", false));
		return (INSN_LIST);
	}

}
