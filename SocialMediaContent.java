package SocialMediaPlatform;

import java.util.Objects;
/**
 * 
 * @author Layan
 */

abstract class SocialMediaContent {
    private String contentId;
    private String content;

    public SocialMediaContent() {
        contentId = " ";
        content = " ";
    }

    public SocialMediaContent(String contentId, String content) {
        this.contentId = contentId;
        this.content = content;
    }

    public void setContentId(String contentId) {
        this.contentId = contentId;
    }

    public String getContentId() {
        return contentId;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public abstract void displayContent();

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || !(obj instanceof SocialMediaContent)) return false;
        SocialMediaContent other = (SocialMediaContent) obj;
        return Objects.equals(contentId, other.contentId) &&
               Objects.equals(content, other.content);
    }

    @Override
    public String toString() {
        return "Content ID: " + contentId + ", Content: " + content;
    }
}
