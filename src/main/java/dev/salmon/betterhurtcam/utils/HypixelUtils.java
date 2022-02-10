package dev.salmon.betterhurtcam.utils;

import gg.essential.api.EssentialAPI;
import net.minecraft.client.Minecraft;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.util.StringUtils;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class HypixelUtils {
    public static boolean inSkyblock = false;
    public static boolean inHypixel = false;
    public static int ticks = 0;

    /**
     * Taken from Danker's Skyblock Mod under GPL 3.0 license
     * https://github.com/bowser0000/SkyblockMod/blob/master/LICENSE
     *
     * @author bowser0000
     */
    public static void checkForSkyblock() {
        if (EssentialAPI.getMinecraftUtil().isHypixel()) {
            ScoreObjective scoreboardObj = Minecraft.getMinecraft().theWorld.getScoreboard().getObjectiveInDisplaySlot(1);
            if (scoreboardObj != null) {
                String scObjName = cleanSB(scoreboardObj.getDisplayName());
                if (scObjName.contains("SKYBLOCK")) {
                    inSkyblock = true;
                    return;
                }
            }
        }
        inSkyblock = false;
    }

    /**
     * Taken from Danker's Skyblock Mod under GPL 3.0 license
     * https://github.com/bowser0000/SkyblockMod/blob/master/LICENSE
     *
     * @author bowser0000
     */
    public static String cleanSB(String scoreboard) {
        char[] nvString = StringUtils.stripControlCodes(scoreboard).toCharArray();
        StringBuilder cleaned = new StringBuilder();

        for (char c : nvString) {
            if ((int) c > 20 && (int) c < 127) {
                cleaned.append(c);
            }
        }

        return cleaned.toString();
    }

    @SubscribeEvent
    protected void onTick(TickEvent.ClientTickEvent event) {
        if (event.phase != TickEvent.Phase.START) return;
        if (ticks % 20 == 0) {
            if (Minecraft.getMinecraft().thePlayer != null) {
                checkForSkyblock();
                inHypixel = EssentialAPI.getMinecraftUtil().isHypixel();
            }
            ticks = 0;
        }

        ticks++;
    }
}
