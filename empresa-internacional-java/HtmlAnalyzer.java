import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

public class HtmlAnalyzer {
    public static void main(String[] args) {
        try {
            String url = args[0];
            String content = readUrl(url);
            System.out.println(content);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public static String readUrl(String url) throws IOException {
        String content = null;
        List<String> listContent = new ArrayList<>();
        int max = 0;
        int count = 0;
        try (InputStream inputStream = new URL(url).openStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                listContent.add(line);
                String trimmed = line.trim();
                if (isCloseTag(trimmed)) {
                    count--;
                } else if (isTag(trimmed)
                        && !isComment(line)) {
                    count++;
                } else if (count > max
                        && !trimmed.isEmpty()) {
                    max = count;
                    content = trimmed;
                }
            }
            if (count != 0) {
                content = "malformed HTML";
            }
        }
        listContent.forEach(System.out::println);
        return content;
    }

    public static boolean isTag(String tag) {
        if (!tag.isEmpty()
                && tag.startsWith("<")
                && tag.endsWith(">")) {
            return true;
        }
        return false;
    }

    public static boolean isComment(String tag) {
        if (tag.startsWith("<!")
                || tag.startsWith("//")) {
            return true;
        }
        return false;
    }

    public static boolean isCloseTag(String tag) {
        if (isTag(tag)
                && !isComment(tag)
                && tag.startsWith("</")) {
            return true;
        }
        return false;
    }
}