package org.example;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class WikiSearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Будь проклят Microsoft
        System.out.println("Введите запрос для поиска в Википедии: ");
        System.out.println("English example");
        String input = scanner.nextLine();
        //String input = "Книга";

        SendRequestWiki sendWiki = new JsonAdapter();
        try {
            sendWiki.search(input);
        }
        catch(IOException | InterruptedException e) {
            System.out.println("Что-то пошло не так.");
        }

        new File("./src/main/java/org/example/text.json").delete();

        scanner.close();
    }

}
