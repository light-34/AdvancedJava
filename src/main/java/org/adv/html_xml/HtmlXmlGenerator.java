package org.adv.html_xml;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class HtmlXmlGenerator {
    public static void simpleHtml() {
        // 1. The raw HTML string
        String html = "<html><head><title>My Page</title></head>"
                + "<body><p>Hello World!</p>"
                + "<a href='https://google.com' id='main-link'>Click Here</a>"
                +"<p>This is a paragraph.</p>"
                + "</body></html>";

        Document doc = Jsoup.parse(html);
        System.out.println(doc.title());
        System.out.println(doc.getElementById("main-link").text());
        System.out.println(doc.getElementsByTag("p").text());
        System.out.println(doc.getElementsByTag("a").attr("href"));
    }

    public static void strictXmlHtml() {
        String html = "<html><body><img src='logo.png'><br><div data-val=\"a <b\">Save & Exit ©</div></body></html>";
        Document doc = Jsoup.parse(html);

        doc.outputSettings().syntax(Document.OutputSettings.Syntax.html);
        System.out.println("--- Strict HTML ---");
        System.out.println(doc.html());

        doc.outputSettings().syntax(Document.OutputSettings.Syntax.xml);
        System.out.println("--- Strict XML ---");
        System.out.println(doc.html());
    }

}
