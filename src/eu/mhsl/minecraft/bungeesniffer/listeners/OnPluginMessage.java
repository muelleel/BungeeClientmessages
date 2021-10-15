package eu.mhsl.minecraft.bungeesniffer.listeners;

import eu.mhsl.minecraft.bungeesniffer.BungeeSniffer;
import eu.mhsl.minecraft.bungeesniffer.data.Message;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.PluginMessageEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

import java.nio.charset.StandardCharsets;

public class OnPluginMessage implements Listener {
    @EventHandler
    public void onPluginMessage(PluginMessageEvent e) {
        if(e.getSender() instanceof ProxiedPlayer) {
            BungeeSniffer.getPlayerMessages().addMessage((ProxiedPlayer) e.getSender(), new Message(e.getTag(), new String(e.getData(), StandardCharsets.UTF_8)));
        }
    }
}
