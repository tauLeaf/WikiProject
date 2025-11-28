package org.example.json_objects;

import java.util.ArrayList;
import java.util.List;

public class Query {
    private SearchInfo searchinfo;
    private List<Info> search = new ArrayList<Info>();

    public List<Info> getSearch() {
        return search;
    }
}
