import java.io.IOException;

public class TestPostApp{
    public static void main(String[] args){
        Post p1 = new Post("Alex Adam", "Help with JavaE", "Hi, could anyone help me I need to learn how to code in java!");
        try {
            p1.saveAsTextFile("Test file.txt");
        // code to save the post
        } catch( IOException ex ) {
                System.out.println("File not saved.");
                ex.printStackTrace();
        }
    }
}