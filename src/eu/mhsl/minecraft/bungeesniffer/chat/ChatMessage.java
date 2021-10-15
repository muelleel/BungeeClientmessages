package eu.mhsl.minecraft.bungeesniffer.chat;

import eu.mhsl.minecraft.bungeesniffer.data.Message;
import eu.mhsl.minecraft.bungeesniffer.data.MessageCollection;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.hover.content.Text;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import org.apache.commons.lang3.StringUtils;

import java.util.Comparator;

public class ChatMessage {
    private MessageCollection data;
    private ProxiedPlayer reciver;

    public ChatMessage(MessageCollection data, ProxiedPlayer reciver) {
        this.data = data;
        this.reciver = reciver;
    }

    public void send() {
        ComponentBuilder builder = new ComponentBuilder("\nClient-Messages").color(ChatColor.DARK_AQUA).bold(true).append("\n").bold(false);
        for(Message m : this.data.getMessages()) {
            TextComponent packet = new TextComponent("[Packet-Data: " + m.getMessage().length() + "]");
            packet.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text(m.getMessage())));

            int max = data.getMessages().stream().max(Comparator.comparingInt(Message::getNamespaceLengh)).get().getNamespaceLengh()+2;

            builder.append(m.getNamespace()).color(ChatColor.GOLD)
                    .append(StringUtils.repeat(" ", max - m.getNamespaceLengh()))
                    .append(" -> ").color(ChatColor.GRAY)
                    .append(packet).color(ChatColor.AQUA)
                    .append("\n")
                    .reset().resetCursor();
        }

        reciver.sendMessage(builder.create());
    }
}
