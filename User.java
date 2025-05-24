package SocialMediaPlatform;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
/**
 * 
 * @author shooq Mohammed Bawiyan
 */

public class User {
    private String userName;
    private String userID;
    private String email;
    private List<Message> messages;
    private List<Post> posts;

    public User() {
        this.userName = " ";
        this.userID = " ";
        this.email = " ";
        this.messages = new ArrayList<>();
        this.posts = new ArrayList<>();
    }

    public User(String userName, String userID, String email) {
        this.userName = userName;
        this.userID = userID;
        this.email = email;
        this.messages = new ArrayList<>();
        this.posts = new ArrayList<>();
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserID() {
        return userID;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void sendMessage(User recipient, String content) {
        Message newMessage = new Message(content, this, recipient);
        newMessage.send();
        addMessage(newMessage);
    }

    public void receiveMessage(Message message) {
        this.messages.add(message);
        message.receive();
    }

    public void addMessage(Message message) {
        this.messages.add(message);
    }

    public void addPost(Post post) {
        this.posts.add(post);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof User)) {
            return false;
        }
        User other = (User) obj;
        return Objects.equals(userID, other.userID);
    }

    @Override
    public String toString() {
        return "User" + "userName=" + userName + ", userID=" + userID + ", messages=" + messages;
    }
}
