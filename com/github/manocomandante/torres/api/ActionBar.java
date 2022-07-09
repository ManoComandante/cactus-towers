package com.github.manocomandante.torres.api;

import org.bukkit.entity.*;
import java.util.*;
import org.bukkit.craftbukkit.v1_8_R3.entity.*;
import net.minecraft.server.v1_8_R3.*;
import org.bukkit.plugin.*;
import org.bukkit.scheduler.*;

public class ActionBar
{
    private static final Map<Player, BukkitTask> PENDING_MESSAGES;
    
    static {
        PENDING_MESSAGES = new HashMap<Player, BukkitTask>();
    }
    
    public static void sendActionBarMessage(final Player bukkitPlayer, final String message) {
        sendRawActionBarMessage(bukkitPlayer, "{\"text\": \"" + message + "\"}");
    }
    
    @SuppressWarnings("rawtypes")
	public static void sendRawActionBarMessage(final Player bukkitPlayer, final String rawMessage) {
        final CraftPlayer player = (CraftPlayer)bukkitPlayer;
        final IChatBaseComponent chatBaseComponent = IChatBaseComponent.ChatSerializer.a(rawMessage);
        final PacketPlayOutChat packetPlayOutChat = new PacketPlayOutChat(chatBaseComponent, (byte)2);
        player.getHandle().playerConnection.sendPacket((Packet)packetPlayOutChat);
    }
    
    public static void sendActionBarMessage(final Player bukkitPlayer, final String message, final int duration, final Plugin plugin) {
        cancelPendingMessages(bukkitPlayer);
        final BukkitTask messageTask = new BukkitRunnable() {
            private int count = 0;
            
            public void run() {
                if (this.count >= duration - 3) {
                    this.cancel();
                }
                ActionBar.sendActionBarMessage(bukkitPlayer, message);
                ++this.count;
            }
        }.runTaskTimer(plugin, 0L, 20L);
        ActionBar.PENDING_MESSAGES.put(bukkitPlayer, messageTask);
    }
    
    private static void cancelPendingMessages(final Player bukkitPlayer) {
        if (ActionBar.PENDING_MESSAGES.containsKey(bukkitPlayer)) {
            ActionBar.PENDING_MESSAGES.get(bukkitPlayer).cancel();
        }
    }
}
