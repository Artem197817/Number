package com.example.Number.DAO;

import com.example.Number.service.ReaderFileService;

import java.util.Map;

public class NumberTensRepositories {
    ReaderFileService readerFileService;
    Map<String,String> tensMap;

    public NumberTensRepositories(ReaderFileService readerFileService) {
        this.readerFileService = readerFileService;
    }

    public Map<String, String> getTensMap() {
        return tensMap;
    }

    public void full() {
        this.tensMap = readerFileService.fileReader("tens.txt");
    }
}
