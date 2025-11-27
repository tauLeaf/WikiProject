package org.example.json_objects;

import com.google.gson.annotations.SerializedName;

public class MainJsonObject {
    public String batchcomplete;
    @SerializedName("continue")
    public Continue _continue;
    public Query query;

    public Query getQuery() {
        return query;
    }
}
