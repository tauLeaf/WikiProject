package org.example;

import java.io.IOException;

public interface SendRequestWiki {
    String source = "https://ru.wikipedia.org/w/api.php?action=query&list=search&utf8=&format=json&srsearch=";
    int searchPage(String input) throws IOException, InterruptedException;
    String getUrlAddress(String input);
}
