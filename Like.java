package SocialMediaPlatform;

import java.util.Objects;
/**
 * 
 * @author Nahla
 */

public class Like {
    private User user;
    private String contentId; 

    
    public Like(User user, String contentId) {
        this.user = user;
        this.contentId = contentId; 
    }

    public User getUser() {
        return user;
    }

    public String getContentId() {
        return contentId;
    }

    public void displayLike() {
        System.out.println(user.getUserName() + " liked content with ID: " + contentId);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || !(obj instanceof Like)) return false;
        Like other = (Like) obj;
        return Objects.equals(user, other.user) &&
               Objects.equals(contentId, other.contentId); 
    }

    @Override
    public String toString() {
        return "Like{" + "user=" + user.getUserName() + ", contentId='" + contentId + '\'' + '}';
    }
}
