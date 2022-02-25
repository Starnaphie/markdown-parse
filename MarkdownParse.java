import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.net.*;

public class MarkdownParse {
    public static ArrayList<String> getLinks(String markdown) throws IOException {
        // ArrayList<String> toReturn = new ArrayList<>();
        // // find the next [, then find the ], then find the (, then take up to
        // // the next )
        // int currentIndex = 0;
        // while(currentIndex < markdown.length()) {
        //     int nextOpenBracket = markdown.indexOf("[", currentIndex);
        //     if (nextOpenBracket == -1) {
        //         break;
        //     }
        //     int nextCloseBracket = markdown.indexOf("]", nextOpenBracket);
        //     int openParen = markdown.indexOf("(", nextCloseBracket);
        //     int closeParen = markdown.indexOf(")", openParen);
        //     String link = markdown.substring(openParen + 1, closeParen);

        //     URL url;
        //     try {
        //         url = new URL(link);    
        //     } catch (IOException e) {
        //         currentIndex = closeParen + 1;
        //         continue;
        //     }
            
        //     HttpURLConnection huc = (HttpURLConnection)url.openConnection();
        //     int responseCode = huc.getResponseCode();
 
        //     if (responseCode == HttpURLConnection.HTTP_OK) {
        //         toReturn.add(link);
        //     } 
        //     currentIndex = closeParen + 1;
        // }
        // return toReturn;

        ArrayList<String> toReturn = new ArrayList<>();
        Scanner sc = new Scanner(markdown);
        String regex = "(.*(?<!!)\\[.+\\]\\()(\\h*\\S+\\h*)(\\).*)";

        while (sc.hasNextLine()) {
            String line = sc.nextLine();

            Matcher matcher = Pattern.compile(regex).matcher(line);

            if (matcher.find()) {
                String link = matcher.group(2);

                // URL url;
                // try {
                //     url = new URL(link);    
                // } catch (IOException e) {
                //     continue;
                // }
                
                // HttpURLConnection huc = (HttpURLConnection)url.openConnection();
                // int responseCode = huc.getResponseCode();
    
                // if (responseCode == HttpURLConnection.HTTP_OK) {
                    toReturn.add(link);
                // } 

            }
        }

        return toReturn;
    }
    public static void main(String[] args) throws IOException {
		Path fileName = Path.of(args[0]);
	    String contents = Files.readString(fileName);
        ArrayList<String> links = getLinks(contents);
        System.out.println(links);
    }
}
