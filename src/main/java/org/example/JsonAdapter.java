package org.example;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.example.json_objects.Info;
import org.example.json_objects.MainJsonObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

//Shift + Alt + F
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

        System.out.println("Результат поиска:");
        for(Info info : searches) {
            System.out.println(i + ". " + info.getTitle());
            i++;
        }

        System.out.println("\nВведите номер выбранное статьи: ");
        int numberQuery = new Scanner(System.in).nextInt();
        int pageid = searches.get(numberQuery-1).getPageid();

        return pageid;
    }
}
