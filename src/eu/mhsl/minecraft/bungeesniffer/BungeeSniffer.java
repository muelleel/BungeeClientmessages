package eu.mhsl.minecraft.bungeesniffer;

import eu.mhsl.minecraft.bungeesniffer.commands.Handshake;
import eu.mhsl.minecraft.bungeesniffer.data.PlayerMessages;
import eu.mhsl.minecraft.bungeesniffer.listeners.OnPluginMessage;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Plugin;

public class BungeeSniffer extends Plugin {
    public static PlayerMessages playerMessages = new PlayerMessages();

    @Override
    public void onEnable() {
        ProxyServer.getInstance().getPluginManager().registerListener(this, new OnPluginMessage());
        ProxyServer.getInstance().getPluginManager().registerCommand(this, new Handshake());
    }

    @Override
    public void onDisable() {
        ProxyServer.getInstance().getPluginManager().unregisterListeners(this);
    }

    public static PlayerMessages getPlayerMessages() {
        return playerMessages;
    }
}
