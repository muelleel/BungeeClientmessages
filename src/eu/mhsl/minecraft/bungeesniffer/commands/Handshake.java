package eu.mhsl.minecraft.bungeesniffer.commands;

import eu.mhsl.minecraft.bungeesniffer.BungeeSniffer;
import eu.mhsl.minecraft.bungeesniffer.chat.ChatMessage;
import eu.mhsl.minecraft.bungeesniffer.data.Message;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class Handshake extends Command {

    public Handshake() {
        super("Handshake");
    }

    @Override
    public void execute(CommandSender commandSender, String[] args) {

        if(!(commandSender instanceof ProxiedPlayer)) return;
        ProxiedPlayer sender = (ProxiedPlayer) commandSender;

        if(args.length != 1) {
            this.sendError(sender, "Please provide an Player name as the first argument!");
            return;
        }

        try {
            ProxiedPlayer target = ProxyServer.getInstance().getPlayer(args[0]);
            ChatMessage chat = new ChatMessage(BungeeSniffer.getPlayerMessages().getMessages(target), (ProxiedPlayer) commandSender);
            chat.send();
        } catch(NullPointerException e) {
            this.sendError(sender, "Player could not be loaded or found!");
        }
    }

    private void sendError(ProxiedPlayer p, String m){
        ComponentBuilder b = new ComponentBuilder("[ERROR] ").color(ChatColor.RED).append(m).color(ChatColor.GRAY);
        p.sendMessage(b.create());
    }
}
