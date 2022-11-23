package dev.salmon.betterhurtcam.asm;

import net.minecraft.launchwrapper.IClassTransformer;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.tree.*;

import static org.objectweb.asm.Opcodes.LDC;
import static org.objectweb.asm.Opcodes.INVOKESTATIC;

public class ClassTransformer implements IClassTransformer
{

    @Override
    public byte[] transform(String name, String transformedName, byte[] bytes)
    {
        if (!transformedName.equals("net.minecraft.client.renderer.EntityRenderer")) return bytes;

        final ClassReader READER = new ClassReader(bytes);
        final ClassNode   NODE   = new ClassNode();
        READER.accept(NODE, ClassReader.SKIP_FRAMES);

        for (MethodNode method : NODE.methods)
        {
            if (method.name.equals("func_78482_e") || method.name.equals("hurtCameraEffect"))
            {
                for (final AbstractInsnNode INSN : method.instructions.toArray())
                {
                    if (INSN.getOpcode() == LDC && ((LdcInsnNode) INSN).cst.equals(14.0F))
                    {
                        method.instructions.insertBefore(INSN, new MethodInsnNode(
                                INVOKESTATIC,
                                "dev/salmon/betterhurtcam/config/Config",
                                "getAnimationMultiplier",
                                "()F",
                                false
                        ));
                        method.instructions.remove(INSN);
                    }
                }
            }
        }

        final ClassWriter WRITER = new ClassWriter(ClassWriter.COMPUTE_MAXS | ClassWriter.COMPUTE_FRAMES);
        NODE.accept(WRITER);
        return WRITER.toByteArray();
    }

}
