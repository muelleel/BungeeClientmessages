package eu.mhsl.minecraft.bungeesniffer.data;

import java.util.ArrayList;

public class MessageCollection {
    private ArrayList<Message> messages = new ArrayList<>();

    public void addMessage(Message m) {
        this.messages.add(m);
    }

    public ArrayList<Message> getMessages() {
        return messages;
    }
}
