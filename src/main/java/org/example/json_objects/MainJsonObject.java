package org.example.json_objects;

import com.google.gson.annotations.SerializedName;

public class MainJsonObject {
    private String batchcomplete;
    @SerializedName("continue")
    private Continue _continue;
    private Query query;

    public Query getQuery() {
        return query;
    }
}
