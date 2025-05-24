package SocialMediaPlatform;

import java.util.Objects;
/**
 * 
 * @author shooq Mohammed Bawiyan
 */

public class Message {
    private String content;
    private User sender;
    private User recipient;

    public Message(String content, User sender, User recipient) {
        this.content = content;
        this.sender = sender;
        this.recipient = recipient;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getSender() {
        return sender;
    }

    public void setRecipient(User recipient) {
        this.recipient = recipient;
    }

    public User getRecipient() {
        return recipient;
    }

    public void send() {
        if (recipient != null && content != null && !content.isEmpty()) {
            recipient.receiveMessage(this);
        } else {
            System.out.println("Recipient is not assigned or content is empty.");
        }
    }

    public void receive() {
        if (sender != null && content != null) {
            System.out.println(sender.getUserName() + " sent: " + content);
        } else {
            System.out.println("No sender or content available.");
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || !(obj instanceof Message)) return false;
        Message other = (Message) obj;
        return Objects.equals(content, other.content) &&
               Objects.equals(sender, other.sender) &&
               Objects.equals(recipient, other.recipient);
    }

    @Override
    public String toString() {
        return "Message{" + "content='" + content + "', sender=" + sender + ", recipient=" + recipient + '}';
    }
}
