package dev.salmon.betterhurtcam.asm;

import dev.salmon.betterhurtcam.config.Config;
import net.minecraft.launchwrapper.IClassTransformer;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.tree.*;

import static org.objectweb.asm.Opcodes.LDC;
import static org.objectweb.asm.Opcodes.INVOKESTATIC;

public class ClassTransformer implements IClassTransformer
{

    /**
     * Grabs value {@link Config#getAnimationMultiplier()} and replaces the original value of 14.0F with the user set value.
     *
     * @param name name of the class being transformed.
     * @param transformedName name of the class being transformed.
     * @param bytes bytes to return to writer.
     * @return writer to bytes.
     * @see IClassTransformer
     * @see Config
     */
    @Override
    public byte[] transform(String name, String transformedName, byte[] bytes)
    {
        if (!transformedName.equals("net.minecraft.client.renderer.EntityRenderer")) return bytes;

        final ClassReader READER = new ClassReader(bytes);
        final ClassNode   NODE   = new ClassNode();
        READER.accept(NODE, ClassReader.SKIP_FRAMES);

        for (MethodNode method : NODE.methods)
        {                        /* unmapped name */                      /* mapped name */
            if (method.name.equals("func_78482_e") || method.name.equals("hurtCameraEffect"))
            {
                for (final AbstractInsnNode INSN : method.instructions.toArray())
                {
                    if (INSN.getOpcode() == LDC && ((LdcInsnNode) INSN).cst.equals(14.0F))
                    {
                        method.instructions.insertBefore(INSN, new MethodInsnNode(
                                INVOKESTATIC,
                                "dev/salmon/betterhurtcam/config/Config", /* Owner class being dev.salmon.betterhurtcam.config.Config. */
                                "getAnimationMultiplier",                        /* Grabbing the return value of Config#getAnimationMultiplier. */
                                "()F",                                           /* Confirming the class with the descriptor, being ()F, meaning no params and a float return type. */
                                false                                            /* False argument signifying that this method isn't an interface. */
                        ));
                        method.instructions.remove(INSN);                        /* Removing previous instruction of 14.0F, being the multiplier. */
                    }
                }
            }
        }

        final ClassWriter WRITER = new ClassWriter(ClassWriter.COMPUTE_MAXS | ClassWriter.COMPUTE_FRAMES);
        NODE.accept(WRITER);
        return WRITER.toByteArray();
    }

}