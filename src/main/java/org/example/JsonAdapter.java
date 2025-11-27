package org.example;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;

import org.example.json_objects.MainJsonObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

//Shift + Alt + F
public class JsonAdapter implements SendRequestWiki {
    public void search(String input) throws IOException, InterruptedException  {
        String modifiedInput = "\"" + input + "\"";
        String encodeInput = URLEncoder.encode(modifiedInput, "UTF-8");
        String urlAddress = source+encodeInput;

        HttpSend httpSend = new HttpSend();
        String fileContent = httpSend.getJsonString(urlAddress);

        Gson gson = new GsonBuilder().serializeNulls().create();

        MainJsonObject content = gson.fromJson(fileContent, MainJsonObject.class);
        String page = content.getQuery().getSearch().get(0).getTitle();

        Desktop obj = Desktop.getDesktop();
        urlAddress = "https://ru.wikipedia.org/wiki/" + page.replaceAll(" ", "_");

        obj.browse(URI.create(urlAddress));

    }
}
