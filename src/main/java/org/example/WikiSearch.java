package org.example;

import java.io.File;
import java.io.IOException;
import java.lang.module.InvalidModuleDescriptorException;
import java.util.Scanner;

public class WikiSearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Будь проклят Microsoft
        System.out.print("Введите запрос для поиска в Википедии: ");
        String input = scanner.nextLine();

        SendRequestWiki sendWiki = new JsonAdapter();
        try {
            sendWiki.search(input);
        }
        // Не все ошибки обрабатывает
        catch(IOException | InterruptedException e) {
            System.out.println("Что-то пошло не так.");
        }
        catch(Exception e) {
            System.out.println("Что-то ГЛОБАЛЬНО пошло не так");
        }

        new File("./src/main/java/org/example/text.json").delete();
        scanner.close();
    }
}
