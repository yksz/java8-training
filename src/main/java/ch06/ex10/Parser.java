package ch06.ex10;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

class Parser {

    public static List<URL> getLinks(String page) {
        Document document = Jsoup.parse(page);
        Elements elements = document.select("a[href]");
        List<URL> links = new ArrayList<>();
        for (Element a : elements) {
            try {
                links.add(new URL(a.attr("href")));
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        return links;
    }

}
