package SocialMediaPlatform;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * 
 * @author Retaj 
 * @author wala
 */

public class SocialMediaMain {
    private static List<User> users = new ArrayList<>();
    private static List<Post> posts = new ArrayList<>();
    private static List<Message> messages = new ArrayList<>();
    private static List<Comment> comments = new ArrayList<>();

    public static void main(String[] args) {
        try (Scanner scnr = new Scanner(System.in)) {
            int choice;

            do {
                System.out.println("1. Create user");
                System.out.println("2. Create Post");
                System.out.println("3. Add Comment to post");
                System.out.println("4. Like a Post");
                System.out.println("5. Like a Comment");
                System.out.println("6. Send Message");
                System.out.println("7. Receive Message");
                System.out.println("8. Display Posts");
                System.out.println("9. Delete a Post");
                System.out.println("0. Exit");
                System.out.println("Choose an option");

                while (!scnr.hasNextInt()) {
                    System.out.println("Invalid input, please enter a number");
                    System.out.println("Choose an option");
                    scnr.next();
                }
                choice = scnr.nextInt();
                scnr.nextLine();

                switch (choice) {
                    case 1:
                        createUser(scnr);
                        break;
                    case 2:
                        createPost(scnr);
                        break;
                    case 3:
                        addCommentToPost(scnr);
                        break;
                    case 4:
                        likePost(scnr);
                        break;
                    case 5:
                        likeComment(scnr);
                        break;
                    case 6:
                        sendMessage(scnr);
                        break;
                    case 7:
                        receiveMessages(scnr);
                        break;
                    case 8:
                        displayPosts();
                        break;
                    case 9:
                        deletePost(scnr);
                        break;
                    case 0:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice");
                }
            } while (choice != 0);
        }
    }

    private static void createUser(Scanner scnr) {
        try {
            System.out.println("Enter a username: ");
            String userName = scnr.nextLine();
            System.out.println("Enter user ID: ");
            String userID = scnr.nextLine();
            System.out.println("Enter Email: ");
            String email = scnr.nextLine();

            User user = new User(userName, userID, email);
            users.add(user);
            System.out.println("User created!");
        } catch (Exception e) {
            System.out.println("Error creating user: " + e.getMessage());
        }
    }

    private static void createPost(Scanner scnr) {
        if (users.isEmpty()) {
            System.out.println("No users available to create a post.");
            return;
        }

        System.out.print("Enter your user ID: ");
        String userId = scnr.nextLine();
        User author = findUserById(userId);

        if (author == null) {
            System.out.println("User not found>~<");
            return;
        }

        try {
            System.out.print("Enter post title: ");
            String title = scnr.nextLine();
            System.out.print("Enter post content: ");
            String content = scnr.nextLine();

            Post post = new Post("P" + (posts.size() + 1), author, title, content);
            posts.add(post);
            System.out.println("Post created!");
            } catch (Exception e) {
            System.out.println("Error creating post: " + e.getMessage());
        }
    }

    private static void addCommentToPost(Scanner scnr) {
        System.out.print("Enter the post ID to comment on: ");
        String postId = scnr.nextLine();
        Post post = findPostById(postId);

        if (post == null) {
            System.out.println("Post not found>~<");
            return;
        }

        System.out.print("Enter your user ID to comment: ");
        String userId = scnr.nextLine();
        User author = findUserById(userId);

        if (author == null) {
            System.out.println("User not found>~<");
            return;
        }

        try {
            System.out.print("Enter your comment: ");
            String commentContent = scnr.nextLine();
            Comment comment = new Comment(author, postId, commentContent, "C" + (comments.size() + 1));

            post.addComment(comment);
            comments.add(comment);
            System.out.println("Comment added.");
        } catch (Exception e) {
            System.out.println("Error adding comment: " + e.getMessage());
        }
    }

    private static void likePost(Scanner scnr) {
        System.out.print("Enter post ID to like: ");
        String postId = scnr.nextLine();
        Post post = findPostById(postId);

        if (post == null) {
            System.out.println("Post not found>~<");
            return;
        }

        System.out.print("Enter your user ID to like the post: ");
        String userId = scnr.nextLine();
        User user = findUserById(userId);

        if (user == null) {
            System.out.println("User not found>~<");
            return;
        }

        try {
            post.like(user);
            System.out.println("Post liked successfully!");
        } catch (Exception e) {
            System.out.println("Error liking post: " + e.getMessage());
        }
    }

    private static void likeComment(Scanner scnr) {
        System.out.print("Enter comment ID to like: ");
        String commentId = scnr.nextLine();
        Comment comment = findCommentById(commentId);

        if (comment == null) {
            System.out.println("Comment not found>~<");
            return;
        }

        System.out.print("Enter your user ID to like the comment: ");
        String userId = scnr.nextLine();
        User user = findUserById(userId);

        if (user == null) {
            System.out.println("User not found>~<");
            return;
        }

        try {
            comment.addLike(user);
            System.out.println("Comment liked successfully!");
        } catch (Exception e) {
            System.out.println("Error liking comment: " + e.getMessage());
        }
    }

    private static void sendMessage(Scanner scnr) {
        System.out.print("Enter your user ID: ");
        String senderId = scnr.nextLine();
        User sender = findUserById(senderId);

        if (sender == null) {
            System.out.println("User not found>~<");
            return;
        }

        System.out.print("Enter the recipient's user ID: ");
        String recipientId = scnr.nextLine();
        User recipient = findUserById(recipientId);

        if (recipient == null) {
            System.out.println("Recipient not found>~<");
            return;
        }

        if (sender.equals(recipient)) {
            System.out.println("You cannot send a message to yourself.");
            return;
        }

        try {
            System.out.print("Enter the message content: ");
            String messageContent = scnr.nextLine();

            Message message = new Message(messageContent, sender, recipient);
            messages.add(message);
            System.out.println("Message sent.");
        } catch (Exception e) {
            System.out.println("Error sending message: " + e.getMessage());
        }
    }

    private static void receiveMessages(Scanner scnr) {
        System.out.print("Enter your user ID to view messages: ");
        String userId = scnr.nextLine();
        User recipient = findUserById(userId);

        if (recipient == null) {
            System.out.println("User not found>~<");
            return;
        }

        System.out.println("Messages received:");
        for (Message message : messages) {
            if (message.getRecipient().equals(recipient)) {
                System.out.println(message.getSender().getUserName() + ": " + message.getContent());
            }
        }
    }

    private static void displayPosts() {
        if (posts.isEmpty()) {
            System.out.println("No posts available!");
            return;
        }

        for (Post post : posts) {
            post.displayContent();
        }
    }

    private static void deletePost(Scanner scnr) {
        System.out.print("Enter the post ID to delete: ");
        String postId = scnr.nextLine();
        Post post = findPostById(postId);

        if (post == null) {
            System.out.println("Post not found>~<");
            return;
        }

        try {
            posts.remove(post);
            System.out.println("Post deleted.");
        } catch (Exception e) {
            System.out.println("Error deleting post: " + e.getMessage());
        }
    }

    private static User findUserById(String userId) {
        for (User user : users) {
            if (user.getUserID().equals(userId)) {
                return user;
            }
        }
        return null;
    }

    private static Post findPostById(String postId) {
        for (Post post : posts) {
            if (post.getPostId().equals(postId)) {
                return post;
            }
        }
        return null;
    }

    private static Comment findCommentById(String commentId) {
        for (Comment comment : comments) {
            if (comment.getCommentId().equals(commentId)) {
                return comment;
            }
        }
        return null;
    }
}
