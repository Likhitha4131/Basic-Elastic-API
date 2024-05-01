package com.example.demo.controller;


import com.example.demo.model.Data;
import com.example.demo.model.DataResponse;
import com.example.demo.service.ElasticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ElasticAPI {

    @Autowired
    private ElasticService elasticService;
    @GetMapping("/hello")
    public String sayHello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return "Hello, " + name + "!";
    }
    @GetMapping("/data")
//    public List<Data> getDataArray() {
//        return elasticService.generateDataArray(40);
//    }
//    public List<Data> getDataArray(@RequestParam int page, @RequestParam int pageSize) {
//        return elasticService.getPaginatedData(page, pageSize);
//    }
    // public List<Data> getDataArray(
    //         @RequestParam(required = false) String searchTerm,
    //         @RequestParam int page,
    //         @RequestParam int pageSize) {

    //     if (searchTerm != null && !searchTerm.isEmpty()) {
    //         return elasticService.searchDataByLabel(searchTerm, page, pageSize);
    //     } else {
    //         return elasticService.getPaginatedData(page, pageSize);
    //     }
    // }
    public DataResponse getDataArray(
        @RequestParam(required = false) String searchTerm,
        @RequestParam int page,
        @RequestParam int pageSize) {

    if (searchTerm != null && !searchTerm.isEmpty()) {
        return elasticService.searchDataByLabel(searchTerm, page, pageSize);
    } else {
        return elasticService.getPaginatedData(page, pageSize);
    }
}
}
