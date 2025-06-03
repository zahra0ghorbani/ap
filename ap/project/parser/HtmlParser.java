package ap.project.parser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HtmlParser {
    public static String getFirstImageUrl(String htmlLine) {
        String url = null;
        int startIndex = htmlLine.indexOf("src=\"");
        if (startIndex >= 0) {
            try {
                int srcLength = "src=\"".length();
                int endIndex = htmlLine.indexOf("\"", startIndex + srcLength);
                url = htmlLine.substring(startIndex + srcLength, endIndex);
            } catch (Exception e) {
            }
        }
        return url;
    }

    private static List<String> getAllImageUrlsFromHtmlLinesStream(Stream<String> htmlLinesStream) {
        return htmlLinesStream
                .map(line -> getFirstImageUrl(line))
                .filter(s -> s != null)
                .collect(Collectors.toList());
    }

    public static List<String> getAllImageUrlsFromFile(String filePath) throws IOException {
        return getAllImageUrlsFromHtmlLinesStream(Files.lines(Path.of(filePath)));
    }

    public static List<String> getAllImageUrlsFromList(List<String> htmlLines) {
        return getAllImageUrlsFromHtmlLinesStream(htmlLines.stream());
    }


    public static String getFirstUrl(String htmlLine) {
        String url = null;
        int startIndex = htmlLine.indexOf("href=\"");
        if (startIndex >= 0) {
            try {
                int hrefLength = "href\"".length();
                int endIndex = htmlLine.indexOf("\"", startIndex + hrefLength + 1);
                url = htmlLine.substring(startIndex + hrefLength + 1, endIndex);
            } catch (Exception e) {
            }
        }
        return url;
    }

    private static List<String> getAllUrlsFromHtmlLinesStream(Stream<String> htmlLinesStream) throws IOException {
        List<String> urls = htmlLinesStream
                .map(line -> getFirstUrl(line))
                .filter(s -> s != null)
                .collect(Collectors.toList());
        return urls;
    }

    public static List<String> getAllUrlsFromFile(String filePath) throws IOException {
        return getAllUrlsFromHtmlLinesStream(Files.lines(Path.of(filePath)));
    }

    public static List<String> getAllUrlsFromList(List<String> htmlLines) throws IOException {
        return getAllUrlsFromHtmlLinesStream(htmlLines.stream());
    }
}
