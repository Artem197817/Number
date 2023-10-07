package com.example.Number.model;

import com.example.Number.service.ReaderFileService;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class NumberUnitsRepositories {

    ReaderFileService readerFileService;
    Map<String,String> unitsMap;

    public NumberUnitsRepositories(ReaderFileService readerFileService) {
        this.readerFileService = readerFileService;
    }

    public void setUnitsMap(Map<String, String> unitsMap) {
        this.unitsMap = unitsMap;
    }

    public Map<String, String> getUnitsMap() {
        return unitsMap;
    }

    public void full() {
        unitsMap = readerFileService.fileReader("units.txt");
    }
    }



