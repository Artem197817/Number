package com.example.Number;

import com.example.Number.DAO.NumberHundredsRepositories;
import com.example.Number.DAO.NumberTensRepositories;
import com.example.Number.DAO.NumberThousandsRepositories;
import com.example.Number.DAO.NumberUnitsRepositories;
import com.example.Number.service.ControllerService;
import com.example.Number.service.ReaderFileService;

public class Main {
    public static void main(String[] args) {
        ReaderFileService readerFileService = new ReaderFileService();
        NumberUnitsRepositories numberUnitsRepositories = new NumberUnitsRepositories(readerFileService);
        numberUnitsRepositories.full();
        NumberTensRepositories numberTensRepositories = new NumberTensRepositories(readerFileService);
        numberTensRepositories.full();
        NumberHundredsRepositories numberHundredsRepositories = new NumberHundredsRepositories(readerFileService);
        numberHundredsRepositories.full();
        NumberThousandsRepositories numberThousandsRepositories = new NumberThousandsRepositories(readerFileService);
        numberThousandsRepositories.full();
        ControllerService controllerService = new ControllerService(numberUnitsRepositories, numberTensRepositories,
                numberHundredsRepositories, numberThousandsRepositories);
        System.out.println(controllerService.controller("5"));
        System.out.println(controllerService.controller("89"));
        System.out.println(controllerService.controller("15"));
        System.out.println(controllerService.controller("100"));
        System.out.println(controllerService.controller("990"));
        System.out.println(controllerService.controller("365"));
        System.out.println(controllerService.controller("369070"));
        System.out.println(controllerService.controller("9000"));
        System.out.println(controllerService.controller("92060"));
        System.out.println(controllerService.controller("1007"));

    }
}
