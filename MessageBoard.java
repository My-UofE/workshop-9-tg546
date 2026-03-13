import java.util.*;
import java.time.LocalDate;
import java.io.*;
import java.time.format.DateTimeFormatter;


public class MessageBoard implements Serializable {
    private List<Post> posts;
    private String boardName;

    public MessageBoard(String boardName) {
        this.boardName = boardName;
        this.posts = new ArrayList<>();
    }
    public String getBoardName() {
        return boardName;
    }

    public int[] getPostIDs() {
        int[] postIDs = new int[posts.size()];
        int i = 0;
        for (Post post : posts) {
            postIDs[i++] = post.getPostId();
        }
        return postIDs;
    }

    public int getPostIndex(int postID) throws IDInvalidException {
        for (int i = 0; i < posts.size(); i++) {
            if (posts.get(i).getPostId() == postID) {
                return i;
            }
        }
        throw new IDInvalidException("Invalid post ID.");
    }


    public int addPost(String author, String subject, String message){
    // this should create a new post and add it to the posts ArrayList
        Post tempPost = new Post(author, subject, message);
        int id = tempPost.getPostId();
        posts.add(tempPost);

        return id;
    }


    public String getFormattedPost(int postID) throws IDInvalidException{
    // this should make use of getPostIndex to access the post
    // and print it using the .toFormattedString() method
        //get post object
        int index = getPostIndex(postID);
        return posts.get(index).toFormattedString();
    }


    public void deletePost(int postID) throws IDInvalidException{
        //get index
        int index = getPostIndex(postID);
        posts.remove(index);
    }


    public int[] searchPostsBySubject(String keyword){
        int[] searchedPosts = new int[0];
        //iterate through each post
        for (Post p1 : posts){
            if (p1.toString().contains("subject="+keyword)){
                searchedPosts = Arrays.copyOf(searchedPosts, searchedPosts.length + 1);
                searchedPosts[searchedPosts.length - 1] = p1.getPostId();
            }
        }

        return searchedPosts;
    }
    
}