package com.example.Number.DAO;

import com.example.Number.service.ReaderFileService;

import java.util.Map;

public class NumberUnitsRepositories {

    ReaderFileService readerFileService;
    Map<String,String> unitsMap;

    public NumberUnitsRepositories(ReaderFileService readerFileService) {
        this.readerFileService = readerFileService;
    }


    public Map<String, String> getUnitsMap() {
        return unitsMap;
    }

    public void full() {
        unitsMap = readerFileService.fileReader("units.txt");
    }
    }



