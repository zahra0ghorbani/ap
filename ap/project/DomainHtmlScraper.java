
package ap.project;

import ap.project.fetcher.HtmlFetcher;
import ap.project.parser.HtmlParser;
import ap.project.store.HtmlFileManager;

import java.io.IOException;
import java.util.*;

public class DomainHtmlScraper {
    private String domainAddress;
    private Queue<String> queue;

    private HtmlFileManager htmlFileManager;

    public DomainHtmlScraper(String domainAddress, String savePath) {
        this.domainAddress = domainAddress;
        this.queue = new LinkedList<>();
        this.htmlFileManager=new HtmlFileManager(savePath);
    }

    public void start() throws IOException {
        List<String> htmlLines = HtmlFetcher.fetchHtml(domainAddress);
        this.htmlFileManager.save(htmlLines);

        List<String> urls = HtmlParser.getAllUrlsFromList(htmlLines);
        queue.addAll(new HashSet<>(urls));
        int counter=1;

        while (!queue.isEmpty()){
            String url = queue.remove();
            counter++;
            try {
                htmlLines = HtmlFetcher.fetchHtml(domainAddress);
                this.htmlFileManager.save(htmlLines);

                urls = HtmlParser.getAllUrlsFromList(htmlLines);
                queue.addAll(new HashSet<>(urls));
            }
            catch (Exception e){
                System.out.println("ERROR: "+url+"\t -> "+e.getMessage());
            }
            System.out.println("["+counter+"] "+url+" fetch and saved (queue size:"+queue.size()+").");
        }
        System.out.println("Operation complete");
    }

    public class DomainHtmlScraper {
        private String domainAddress;
        private Queue<String> queue;
        private Set<String> visitedUrls;
        private HtmlFileManager htmlFileManager;

        public DomainHtmlScraper(String domainAddress, String savePath) {
            this.domainAddress = domainAddress;
            this.queue = new LinkedList<>();
            this.visitedUrls = new HashSet<>();
            this.htmlFileManager = new HtmlFileManager(savePath);
        }

        public void start() throws IOException {
            List<String> htmlLines = HtmlFetcher.fetchHtml(domainAddress);
            this.htmlFileManager.save(htmlLines);

            List<String> urls = HtmlParser.getAllUrlsFromList(htmlLines);
            urls.stream()
                    .filter(u -> !visitedUrls.contains(u))
                    .forEach(u -> {
                        queue.add(u);
                        visitedUrls.add(u);
                    });

            int counter = 1;

            while (!queue.isEmpty()) {
                String url = queue.remove();
                counter++;

                try {
                    htmlLines = HtmlFetcher.fetchHtml(url);
                    this.htmlFileManager.save(htmlLines);

                    urls = HtmlParser.getAllUrlsFromList(htmlLines);
                    urls.stream()
                            .filter(u -> !visitedUrls.contains(u))
                            .forEach(u -> {
                                queue.add(u);
                                visitedUrls.add(u);
                            });

                } catch (Exception e) {
                    System.out.println("ERROR: " + url + "\t -> " + e.getMessage());
                }

                System.out.println("[" + counter + "] " + url + " fetch and saved (queue size:" + queue.size() + ").");
            }

            System.out.println("Operation complete");
        }
    }


}