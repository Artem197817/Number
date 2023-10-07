package com.example.Number.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class ReaderFileService {


    public String[] bufferReader;

    public HashMap<String, String> fileReader(String path) {
        HashMap<String, String> mapService = new HashMap<>();
        File file = new File(path);
        try (
                BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                bufferReader = line.toLowerCase().split(":");
                mapService.put(bufferReader[0], bufferReader[1]);
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        return mapService;
    }
}
