package dev.salmon.betterhurtcam.asm;

import dev.salmon.betterhurtcam.config.Config;
import net.minecraft.launchwrapper.IClassTransformer;
import net.minecraftforge.fml.common.asm.transformers.deobf.FMLDeobfuscatingRemapper;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.tree.*;

import static org.objectweb.asm.Opcodes.INVOKESTATIC;
import static org.objectweb.asm.Opcodes.LDC;

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
     *     {@link net.minecraft.client.renderer.EntityRenderer} Class being transformed.
     * </pre>
     *
     * @param name            name of the class being transformed.
     * @param transformedName name of the class being transformed.
     * @param bytes           bytes to return to writer.
     * @return writer to bytes.
     * @see IClassTransformer
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
                        method.instructions.set(INSN, new MethodInsnNode(
                                INVOKESTATIC,
                                "dev/salmon/betterhurtcam/config/Config",   /* Owner class being dev.salmon.betterhurtcam.config.Config. */
                                "getAnimationMultiplier",                   /* Grabbing the return value of Config#getAnimationMultiplier. */
                                "()F",                                      /* Confirming the class with the descriptor, being ()F, meaning no params and a float return type. */
                                false                                       /* False argument signifying that this method isn't an interface. */
                        ));
                    }
                }
            }
        }

        final ClassWriter WRITER = new ClassWriter(READER, 0);
        NODE.accept(WRITER);
        return (WRITER.toByteArray());
    }

}
