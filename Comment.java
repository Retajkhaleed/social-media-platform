package SocialMediaPlatform;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @author Nahla
 */

class Comment extends SocialMediaContent {
    private User author;
    private String postId; 
    private String content;
    private List<Like> likes; 
    private String commentId;

    
    public Comment(User author, String postId, String content, String commentId) {
        this.author = author;
        this.postId = postId;
        this.content = content;
        this.commentId = commentId;
        this.likes = new ArrayList<>(); 
    }

    public User getAuthor() {
        return author;
    }

    public String getPostId() {
        return postId;
    }

    @Override
    public String getContent() {
        return content;
    }

    @Override
    public void setContent(String content) {
        this.content = content;
    }

    public List<Like> getLikes() {
        return likes;
    }

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    public void addLike(User user) {
        for (Like like : likes) {
            if (like.getUser().equals(user)) {
                System.out.println("User " + user.getUserName() + " has already liked this comment.");
                return;
            }
        }
        likes.add(new Like(user, this.commentId)); 
        System.out.println(user.getUserName() + " liked the comment: " + this.toString());
    }

    public int getLikeCount() {
        return likes.size();
    }

    public void displayContent() {
        System.out.println("Comment ID: " + commentId); 
        System.out.println("Comment by " + author.getUserName() + ": " + content);
        System.out.println("Likes: " + getLikeCount());
    }

    @Override
    public String toString() {
        return "Comment{" +
                "author=" + author.getUserName() +
                ", content='" + content + '\'' +
                ", commentId='" + commentId;
    }
}
