package eu.mhsl.minecraft.bungeesniffer.data;

import net.md_5.bungee.api.connection.ProxiedPlayer;
import org.apache.http.MessageConstraintException;

import java.util.HashMap;

public class PlayerMessages {
    private HashMap<ProxiedPlayer, MessageCollection> messages = new HashMap<>();

    public void addMessage(ProxiedPlayer p, Message m) {
        if(this.messages.get(p) != null) {
            this.messages.get(p).addMessage(m);
        } else {
            MessageCollection collection = new MessageCollection();
            collection.addMessage(m);
            this.messages.put(p, collection);
        }
    }

    public MessageCollection getMessages(ProxiedPlayer p) {
        return this.messages.get(p);
    }
}
