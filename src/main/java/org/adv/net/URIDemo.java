package org.adv.net;

import java.net.URI;

public class URIDemo {

    public static void main(String[] args) throws Exception {
        URI  uri = new URI(
                "https",
                "www.google.com",
                "/doc/resource1.html",
                "query=java&spring",
                "section");

        System.out.println(uri);

        URI baseUri = URI.create("http://www.example.com:1080/docs/");

        // Resolves relative to the base directory
        URI resolvedUri = baseUri.resolve("resource1.html");

        System.out.println(resolvedUri);

        System.out.println("******** GOOGLE WEB SITE DATA *********");
        System.out.println(URIMethods.retriveGoogleWebData());

    }
}
