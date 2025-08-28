mport java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        PostManager manager = new PostManager();

        String postTitle = "Java Programming Tips";
        int engagementScore = manager.calculateEngagement(150, 75, 25);
        String category = manager.getCategoryRating(engagementScore);

        System.out.println("═══ Social Media Post Manager ═══");
        manager.displayPostStats(postTitle, engagementScore, category);
        System.out.println();

        String[] hashtags = {"#java", "#coding", "#programming", "#java", "#tips"};
        ArrayList<String> uniqueHashtags = manager.manageHashtags(hashtags);
        System.out.println("Unique Hashtags: " + uniqueHashtags);

        ArrayList<String> posts = new ArrayList<>();
        posts.add("Advanced Java Tutorial");
        posts.add("Spring Boot Guide");
        posts.add("Beginner Java Basics");

        HashMap<String, Integer> postEngagement = new HashMap<>();
        postEngagement.put("Advanced Java Tutorial", 800);
        postEngagement.put("Spring Boot Guide", 600);
        postEngagement.put("Beginner Java Basics", 100);

        LinkedList<String> trendingPosts = manager.findTrendingPosts(posts, postEngagement);
        System.out.println("Trending Posts: " + trendingPosts);

        HashSet<String> uniqueAuthors = manager.getUniqueAuthors("Alice", "Bob", "Alice", "Charlie", "Bob");
        System.out.println("Unique Authors: " + uniqueAuthors);
    }
}
