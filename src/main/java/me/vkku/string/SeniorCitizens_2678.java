package me.vkku.string;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class SeniorCitizens_2678 {
    public int countSeniors(String[] details) {
        long count = Arrays.stream(details)
                .filter(citizen -> Integer.parseInt(citizen.substring(11, 13)) > 60)
                .count();
        return (int) count;
    }

    @Test
    public void driver(){
        SeniorCitizens_2678 seniorCitizens2678 = new SeniorCitizens_2678();
        String[] details = {"7868190130M7522","5303914400F9211","9273338290F4010"};
        System.out.println(seniorCitizens2678.countSeniors(details));
    }

}
