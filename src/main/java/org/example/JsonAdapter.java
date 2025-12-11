package org.example;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Scanner;

import org.example.json_objects.Info;
import org.example.json_objects.MainJsonObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

//Shift + Alt + F
//Ctrl + Alt + L
public class JsonAdapter implements SendRequestWiki {
    public int searchPage(String input) throws IOException, InterruptedException  {
        String urlAddress = getUrlAddress(input);

        HttpWork httpWork = new HttpWork();
        String fileContent = httpWork.getJsonString(urlAddress);

        Gson gson = new GsonBuilder().serializeNulls().create();

        MainJsonObject content = gson.fromJson(fileContent, MainJsonObject.class);
        return chooseQueryPageid(content);
    }

    public String getUrlAddress(String input) {
        String modifiedInput = "\"" + input + "\"";
        String encodeInput = URLEncoder.encode(modifiedInput, StandardCharsets.UTF_8);
        return source+encodeInput;
    }

    public int chooseQueryPageid(MainJsonObject content) {
        List<Info> searches = content.getQuery().getSearch();
        int i = 1;

        if(searches.isEmpty()) { return 0; }

        System.out.println("Результат поиска:");
        for(Info info : searches) {
            System.out.println(i + ". " + info.getTitle());
            i++;
        }

        int numberQuery = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nВведите номер выбранное статьи: ");

        while(numberQuery < 1 || numberQuery >= i) {
            if(scanner.hasNextInt()) {
                numberQuery = scanner.nextInt();
            }
            else {
                System.out.println("Некорректный номер статьи, попробуйте ещё раз.");
                scanner.next();
            }
        }

        int pageid = searches.get(numberQuery-1).getPageid();
        return pageid;
    }

//    public boolean isCorrectNumberQuery(int numberQuery) {
//
//        return false;
//    }
}
