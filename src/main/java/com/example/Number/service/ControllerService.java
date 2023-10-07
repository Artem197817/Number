package com.example.Number.service;

import com.example.Number.DAO.NumberHundredsRepositories;
import com.example.Number.DAO.NumberTensRepositories;
import com.example.Number.DAO.NumberThousandsRepositories;
import com.example.Number.DAO.NumberUnitsRepositories;

public class ControllerService {

    NumberUnitsRepositories numberUnitsRepositories;
    NumberTensRepositories numberTensRepositories;
    NumberHundredsRepositories numberHundredsRepositories;
    NumberThousandsRepositories numberThousandsRepositories;

    public ControllerService(NumberUnitsRepositories numberUnitsRepositories, NumberTensRepositories numberTensRepositories,
                             NumberHundredsRepositories numberHundredsRepositories, NumberThousandsRepositories numberThousandsRepositories) {
        this.numberUnitsRepositories = numberUnitsRepositories;
        this.numberTensRepositories = numberTensRepositories;
        this.numberHundredsRepositories = numberHundredsRepositories;
        this.numberThousandsRepositories = numberThousandsRepositories;
    }

    public String controller(String number) {
        // validator

        return switch (number.length()) {
            case 1 -> units(number);
            case 2 -> tens(number);
            case 3 -> hundreds(number);
            case 4, 5, 6 -> thousands(number);
            default -> null;
        };

    }

    private String thousands(String number) {
        String[] temp = split(number);
        StringBuilder result = new StringBuilder();
        StringBuilder hundreds = new StringBuilder();
        StringBuilder thousands = new StringBuilder();
        int length = temp.length;
        int thousand = Integer.parseInt(temp[length - 4]);
        for (int i = length - 3; i < length; i++) {
            hundreds.append(temp[i]);
        }
        for (int i = 0; i < length - 3; i++) {
            thousands.append(temp[i]);
        }
        if (thousands.toString().equals("000"))
            return "";
        if (thousand > 4) {
            result.append(controller(thousands.toString())).append(" тысяч ")
                    .append(hundreds(hundreds.toString()));
            return result.toString();
        } else {
            String[] temp2 = controller(thousands.toString()).split(" ");
            for (int i = 0; i < temp2.length - 1; i++) {
                result.append(temp2[i]).append(" ");
            }
            result.append(numberThousandsRepositories.getThousandsMap().get(String.valueOf(thousand))).append(" ")
                    .append(hundreds(hundreds.toString()));
        }
        return result.toString();
    }

    private String hundreds(String number) {
        if (number.equals("000"))
            return "";
        String[] temp = split(number);
        StringBuilder result = new StringBuilder();
        if (!temp[0].equals("0"))
            result.append(numberHundredsRepositories.getHundredsMap().get(temp[0])).append(" ");
        if (!temp[1].equals("0")) {
            String str = temp[1] + temp[2];
            result.append(tens(str));
        }
        if (!temp[2].equals("0"))
            result.append(units(temp[2]));


        return result.toString();
    }

    private String[] split(String number) {
        return number.trim().split("");
    }

    private String tens(String number) {
        if (number.equals("00"))
            return "";
        if (Integer.parseInt(number) < 20)
            return units(number);
        StringBuilder result = new StringBuilder();
        String[] temp = split(number);
        if (!temp[0].equals("0"))
            result.append(numberTensRepositories.getTensMap().get(temp[0])).append(" ");
        if (!temp[1].equals("0"))
            result.append(units(temp[1]));
        return result.toString();
    }

    public String units(String number) {
        if (!number.equals("0"))
            return numberUnitsRepositories.getUnitsMap().get(number);
        return "";
    }
}
