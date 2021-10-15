package eu.mhsl.minecraft.bungeesniffer.data;

public class Message {
    private String namespace;
    private String message;

    public Message(String namespace, String message) {
        this.namespace = namespace;
        this.message = message;
    }

    public String getNamespace() {
        return namespace;
    }

    public String getMessage() {
        return message;
    }

    public int getNamespaceLengh() {
        return this.getNamespace().length();
    }
}
