package org.example;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.Scanner;

public class WikiSearch {
    public static void main(String[] args) throws IOException {
        System.out.print("Введите запрос для поиска в Википедии: ");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        int pageid = 0;
        SendRequestWiki sendWiki = new JsonAdapter();
        try {
            pageid = sendWiki.searchPage(input);
        }
        catch(IOException | InterruptedException e) {
            System.out.println("Ошибка ввода");
        }

        if(pageid == 0) {
            System.out.println("Совпадений не найдено.");
        }
        else {
            openPageInBrowse(pageid);
        }

        new File("./src/main/java/org/example/text.json").delete();
        scanner.close();
    }

    public static void openPageInBrowse(int pageid) throws IOException {
        Desktop obj = Desktop.getDesktop();
        String urlAddress = "https://ru.wikipedia.org/w/index.php?curid=" + pageid;

        obj.browse(URI.create(urlAddress));
    }
}
