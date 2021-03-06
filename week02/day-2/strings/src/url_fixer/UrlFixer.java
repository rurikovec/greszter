package url_fixer;

import java.util.ArrayList;

public class UrlFixer {
    public static void main(String[] args) {
        String url = "https//www.reddit.com/r/nevertellmethebots";

        // Accidentally I got the wrong URL for a funny subreddit. It's probably "odds" and not "bots"
        // Also, the URL is missing a crucial component, find out what it is and insert it too!
        // Try to solve it more than once using different String functions!

        String newurl = url.replace("bots", "odds");
        StringBuilder urlFix = new StringBuilder(newurl);
        urlFix.insert(newurl.indexOf("//"), ":");

        System.out.println(urlFix.toString());


    }
}
