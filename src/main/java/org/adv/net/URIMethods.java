package org.adv.net;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class URIMethods {
    public  static String retriveGoogleWebData() {
       try {
           //1. Build URI and Response
           URI uri = URI.create("https://www.google.com");
           HttpRequest request = HttpRequest.newBuilder().uri(uri).GET().build();

           //2. Send Request via HttpClient
           HttpClient client = HttpClient.newHttpClient();
           HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

           //3. Return the result
           return response.body();
       } catch (Exception e) {
           e.printStackTrace();
           return "null data";
       }
    }
}
