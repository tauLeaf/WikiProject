package org.example.json_objects;

import java.util.ArrayList;
import java.util.List;

public class Query {
    public SearchInfo searchinfo;
    public List<Info> search = new ArrayList<Info>();

    public List<Info> getSearch() {
        return search;
    }
}
