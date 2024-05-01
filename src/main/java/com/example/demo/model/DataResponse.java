package com.example.demo.model;

import java.util.List;

public class DataResponse {
    private List<Data> data;
    private int totalRecords;

    public DataResponse(List<Data> data, int totalRecords) {
        this.data = data;
        this.totalRecords = totalRecords;
    }

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    public int getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(int totalRecords) {
        this.totalRecords = totalRecords;
    }
}


