package at.dalex.fancytab.util;

import net.minecraft.server.v1_12_R1.ChatMessage;
import net.minecraft.server.v1_12_R1.IChatBaseComponent;
import net.minecraft.server.v1_12_R1.PacketPlayOutPlayerListHeaderFooter;
import org.bukkit.craftbukkit.v1_12_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

import java.lang.reflect.Field;

public class TablistUtil {

    public static void sendTabList(Player player, String head, String foot){
        IChatBaseComponent header = new ChatMessage(head);
        IChatBaseComponent footer = new ChatMessage(foot);
        PacketPlayOutPlayerListHeaderFooter tabList = new PacketPlayOutPlayerListHeaderFooter();

        try {
            Field headerField = tabList.getClass().getDeclaredField("a");
            headerField.setAccessible(true);
            headerField.set(tabList, header);
            headerField.setAccessible(!headerField.isAccessible());
            Field footerField = tabList.getClass().getDeclaredField("b");
            footerField.setAccessible(true);
            footerField.set(tabList, footer);
            footerField.setAccessible(!footerField.isAccessible());
        } catch (Exception e) {
            e.printStackTrace();
        }

        CraftPlayer cp = (CraftPlayer) player;
        cp.getHandle().playerConnection.sendPacket(tabList);
    }
}
