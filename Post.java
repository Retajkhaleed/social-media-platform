package SocialMediaPlatform;

/**
 * @author تالا فهد سعد الردادي
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Post extends SocialMediaContent implements Postable {
    private String postId;  
    private User author;
    private String title;
    private String content;
    private List<Like> likes;
    private List<Comment> comments;
    private int shares;

    public Post(String postId, User author, String title, String content) {
        if (postId == null||author==null||title == null || content == null) {
            throw new IllegalArgumentException("Post ID, author, title, and content cannot be null.");
        }
        this.postId = postId;
        this.author = author;
        this.title = title;
        this.content = content;
        this.likes = new ArrayList<>();
        this.comments = new ArrayList<>();
        this.shares = 0;
    }

    public static Post createPost(String postId, User author, String title, String content) {
        return new Post(postId, author, title, content);
    }

    public String getPostId() {
        return postId;
    }

    public User getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public List<Like> getLikes() {
        return likes;
    }

    public List<Comment> getComments() {
        return comments;
    }

    @Override
    public void like(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null.");
        }
        for (Like like : likes) {
            if (like.getUser().equals(user)) {
                throw new IllegalStateException("User " + user.getUserName() + " has already liked this post.");
            }
        }
        likes.add(new Like(user, this.postId));
        System.out.println(user.getUserName() + " liked the post: " + this.toString());
    }

    public void addComment(Comment comment) {
        if (comment == null) {
            throw new IllegalArgumentException("Comment cannot be null.");
        }
        comments.add(comment);
    }

    public void displayComments() {
        System.out.println("Comments:");
        if (comments.isEmpty()) {
            System.out.println("No comments yet.");
            return;
        }
        for (Comment comment : comments) {
            comment.displayContent();
        }
    }

    @Override
    public void displayContent() {
        System.out.println("Post ID: " + postId);
        System.out.println("Post Title: " + title);
        System.out.println("Author: " + author.getUserName());
        System.out.println("Content: " + content);
        System.out.println("Likes: " + likes.size());
        System.out.println("Shares: " + shares);
        displayComments();
    }

    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Post)) return false;
        Post post = (Post) o;
        return shares == post.shares &&
                Objects.equals(postId, post.postId) &&
                Objects.equals(author, post.author) &&
                Objects.equals(title, post.title) &&
                Objects.equals(content, post.content);
    }

    @Override
    public String toString() {
        return "Post{" +
                "postId='" + postId + '\'' +
                ", title='" + title + '\'' +
                ", author=" + (author != null ? author.getUserName() : "Unknown") +
                ", content='" + content + '\'' +
                ", likes=" + likes.size() + '}';
    }
}
