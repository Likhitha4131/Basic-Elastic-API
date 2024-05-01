package com.example.demo.service;

import com.example.demo.model.Data;
import com.example.demo.model.DataResponse;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ElasticService {
    private List<Data> dataArray;
//    public List<Data> generateDataArray(int size) {
//        List<Data> dataArray = new ArrayList<>();
//
//        for (int i = 0; i < size; i++) {
//            int id = i + 1; // Assuming ids start from 1
//            String label = "Label_" + id;
//            String value = "Value_" + id;
//
//            Data data = new Data();
//            data.setId(id);
//            data.setLabel(label);
//            data.setValue(value);
//
//            dataArray.add(data);
//        }
//
//        return dataArray;
//    }

    public ElasticService() {
        
        this.dataArray = generateDummyData(100); 
    }
    private List<Data> generateDummyData(int size) {
        List<Data> dummyData = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Data data = new Data();
            data.setId(i + 1);
            data.setLabel("Label_" + (i + 1));
            data.setValue("Value_" + (i + 1));
            dummyData.add(data);
        }
        return dummyData;
    }

    // public List<Data> getPaginatedData(int page, int pageSize) {
    //     int startIndex = (page - 1) * pageSize;
    //     int endIndex = Math.min(startIndex + pageSize, dataArray.size());
    //     if (startIndex >= endIndex) {
    //         return new ArrayList<>();
    //     }
    //     return dataArray.subList(startIndex, endIndex);
    // }
    public DataResponse getPaginatedData(int page, int pageSize) {
        int startIndex = (page - 1) * pageSize;
        int endIndex = Math.min(startIndex + pageSize, dataArray.size());
        if (startIndex >= endIndex) {
            return new DataResponse(new ArrayList<>(), dataArray.size());
        }
        List<Data> paginatedData = dataArray.subList(startIndex, endIndex);
        return new DataResponse(paginatedData, dataArray.size());
    }
    // public List<Data> searchDataByLabel(String searchTerm, int page, int pageSize) {
    //     List<Data> filteredData = dataArray.stream()
    //             .filter(data -> data.getLabel().toLowerCase().contains(searchTerm.toLowerCase()))
    //             .collect(Collectors.toList());

    //     int startIndex = (page - 1) * pageSize;
    //     int endIndex = Math.min(startIndex + pageSize, filteredData.size());
    //     if (startIndex >= endIndex) {
    //         return new ArrayList<>(); 
    //     }
    //     return filteredData.subList(startIndex, endIndex);
    // }
    public DataResponse searchDataByLabel(String searchTerm, int page, int pageSize) {
        List<Data> filteredData = dataArray.stream()
                .filter(data -> data.getLabel().toLowerCase().contains(searchTerm.toLowerCase()))
                .collect(Collectors.toList());

        int startIndex = (page - 1) * pageSize;
        int endIndex = Math.min(startIndex + pageSize, filteredData.size());
        if (startIndex >= endIndex) {
            return new DataResponse(new ArrayList<>(), dataArray.size()); 
        }
        List<Data> paginatedData = filteredData.subList(startIndex, endIndex);
        return new DataResponse(paginatedData, dataArray.size());
    }

}
