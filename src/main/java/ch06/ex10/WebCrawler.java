package ch06.ex10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class WebCrawler {

    public CompletableFuture<List<URL>> crawl(URL url) throws InterruptedException, ExecutionException {
        return CompletableFuture.supplyAsync(() -> readPage(url))
                                .thenApply(Parser::getLinks);
    }

    public String readPage(URL url) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                }
            }
        }
    }

    static URL getResource(String resource) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        return classLoader.getResource(resource);
    }

    public static void main(String[] args) throws Exception {
        new WebCrawler().crawl(getResource("ch06/html/index.html"))
                        .thenAccept(System.out::println);
        ForkJoinPool.commonPool().awaitQuiescence(10, TimeUnit.SECONDS);
    }

}
