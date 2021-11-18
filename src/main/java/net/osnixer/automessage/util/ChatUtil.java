package net.osnixer.automessage.util;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public final class ChatUtil {

    public static String colour(final String toColour){
        return ChatColor.translateAlternateColorCodes('&', toColour);
    }

    public static void sendMessage(final Player player, String message){
        player.sendMessage(colour(message));
    }

    private ChatUtil(){
    }
}
