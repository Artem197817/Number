package com.example.Number.DAO;

import com.example.Number.service.ReaderFileService;

import java.util.Map;

public class NumberHundredsRepositories {
    ReaderFileService readerFileService;
    Map<String,String> hundredsMap;

    public NumberHundredsRepositories(ReaderFileService readerFileService) {
        this.readerFileService = readerFileService;
    }

    public Map<String, String> getHundredsMap() {
        return hundredsMap;
    }

    public void full() {
        this.hundredsMap = readerFileService.fileReader("hundreds.txt");
    }
}
