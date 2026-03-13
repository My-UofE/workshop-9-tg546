public class TestMBApp {
    public static void main(String[] args) {
        MessageBoard m = new MessageBoard("Coding Support");
        m.addPost("Alex Adam", "Help with Java", "Hi, could anyone help me I need to learn how to code in java!");
        m.addPost("Belinda Bennett", "Help with Java", "Hi Alex. Yes I can send some tutorials I found useful.");
        m.addPost("Cindy Carter", "Coding on a Chromebook", "Hi, could anyone help me I need to learn how to code in java!");
        m.addPost("Dennis Dobson", "Windows problems", "My windows laptop is stuck on a reboot loop. Does anyone know what to do!");

        int[] getPostIds = m.getPostIDs();
        for (int post : getPostIds){
            System.out.println(m.getFormattedPost(post));
        }



        System.out.println(m.searchPostsBySubject("java"));
    }
}
