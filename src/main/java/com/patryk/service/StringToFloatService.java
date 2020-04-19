package com.patryk.service;


import org.springframework.stereotype.Service;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import static java.lang.Float.parseFloat;

@Service
public class StringToFloatService {

    public float validateAndChangeStringToFloat(String floatAsString){
        return validateFloatPattern(floatAsString) ? parseFloat(floatAsString) : convertStringSalaryToFloat(floatAsString);
    }

    private float convertStringSalaryToFloat(String salaryAsString){
        IntStream intStream = salaryAsString.codePoints();
        return parseFloat(intStream.map(x -> x == ',' ? x = '.' : x)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString());
    }

    private boolean validateFloatPattern(String salaryAsString){
        Pattern properFloatPattern = Pattern.compile("[+-]?([0-9]*[.])?[0-9]+");
        return  properFloatPattern.matcher(salaryAsString).matches();
    }
}
