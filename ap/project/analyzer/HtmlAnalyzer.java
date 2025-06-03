package ap.project.analyzer;

import ap.project.Conf;
import ap.project.parser.HtmlParser;
import ap.project.utils.DirectoryTools;
import ap.project.utils.FileTools;
import ap.project.utils.ObjectCounter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.HashSet;

public class HtmlAnalyzer {



    public class HtmlAnalyzer {


        public static Set<String> getAllImageUrls() {
            Set<String> imageUrls = new HashSet<>();
            for (String fileAddress : fileList) {
                try {
                    List<String> lines = FileTools.getTextFileLines(fileAddress);
                    if (lines != null) {
                        List<String> urls = HtmlParser.getAllImageUrlsFromList(lines);
                        imageUrls.addAll(urls);
                    }
                } catch (Exception e) {
                    System.err.println("Error processing file " + fileAddress + ": " + e.getMessage());
                }
            }
            return imageUrls;
        }

        public static void saveImageUrlsToFile(String outputFile) {
            Set<String> imageUrls = getAllImageUrls();
            try (PrintWriter writer = new PrintWriter(outputFile)) {
                for (String url : imageUrls) {
                    writer.println(url);
                }
                System.out.println("Image URLs saved to " + outputFile);
            } catch (IOException e) {
                System.err.println("Failed to save image URLs: " + e.getMessage());
            }
        }


    }

    private static List<String> fileList = DirectoryTools.getFilesAbsolutePathInDirectory(Conf.SAVE_DIRECTORY);

    public static List<String> getAllUrls() {
        List<String> urls = fileList.stream()
                .map(fileAddress -> FileTools.getTextFileLines(fileAddress))
                .filter(s -> s != null)
                .flatMap(s -> s.stream())
                .map(s -> HtmlParser.getFirstUrl(s))
                .filter(s -> s != null)
                .filter(s -> s.length() > 1)
                .collect(Collectors.toList());
        return urls;
    }

    public static List<String> getTopUrls(int k){
        Map<String, Long> urlCount = getAllUrls().stream()
                .collect(Collectors.groupingBy(
                        s -> s,
                        Collectors.counting()
                ));

        List<String> topUrls = urlCount.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(k)
                .map(s -> s.getKey())
                .collect(Collectors.toList());

        return topUrls;
    }
    public static void printTopCountUrls(int k){
        ObjectCounter<String> urlCounter=new ObjectCounter<>();
        getAllUrls().forEach(s -> urlCounter.add(s));
        for (Map.Entry<String, Integer> urlCountEntry : urlCounter.getTop(k)) {
            System.out.println(urlCountEntry.getKey()+" -> "+urlCountEntry.getValue());
        }
    }

    public static void main(String[] args) {

        HtmlAnalyzer.printTopCountUrls(10);

        System.out.println("____________________");
        HtmlAnalyzer.getTopUrls(10).forEach(s -> System.out.println(s));

    }
}