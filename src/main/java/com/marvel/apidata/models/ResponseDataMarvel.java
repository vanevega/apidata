
package com.marvel.apidata.models;

import java.util.List;


public class ResponseDataMarvel {
    private int offset;
    private int limit;
    private int total;
    private int count;
    private List<CharacterMarvel> results;

    public ResponseDataMarvel(int count, int limit, int offset, List<CharacterMarvel> results, int total) {
        this.count = count;
        this.limit = limit;
        this.offset = offset;
        this.results = results;
        this.total = total;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<CharacterMarvel> getResults() {
        return results;
    }

    public void setResults(List<CharacterMarvel> results) {
        this.results = results;
    }

}
