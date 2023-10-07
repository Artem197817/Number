package com.example.Number.DAO;

import com.example.Number.service.ReaderFileService;

import java.util.Map;

public class NumberThousandsRepositories {
    ReaderFileService readerFileService;
    Map<String, String> thousandsMap;

    public NumberThousandsRepositories(ReaderFileService readerFileService) {
        this.readerFileService = readerFileService;
    }

    public Map<String, String> getThousandsMap() {
        return thousandsMap;
    }

    public void full() {
        this.thousandsMap = readerFileService.fileReader("thousands.txt");
    }
}
