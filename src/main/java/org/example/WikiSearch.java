package org.example;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.Scanner;

public class WikiSearch {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int pageid = 0;

        // Будь проклят Microsoft
        System.out.print("Введите запрос для поиска в Википедии: ");
        String input = scanner.nextLine();

        SendRequestWiki sendWiki = new JsonAdapter();
        try {
            pageid = sendWiki.searchPage(input);
        }
        // Не все ошибки обрабатывает
        catch(IOException | InterruptedException e) {
            System.out.println("Что-то пошло не так.");
        }
        catch(Exception e) {
            System.out.println("Что-то ГЛОБАЛЬНО пошло не так");
        }

        openPageInBrowse(pageid);

        new File("./src/main/java/org/example/text.json").delete();
        scanner.close();
    }

    public static void openPageInBrowse(int pageid) throws IOException {
        Desktop obj = Desktop.getDesktop();
        String urlAddress = "https://ru.wikipedia.org/w/index.php?curid=" + pageid;

        obj.browse(URI.create(urlAddress));
    }
}
