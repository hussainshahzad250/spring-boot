package com.opencsv;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import com.opencsv.request.User;
import com.opencsv.utility.SmartCsvReader;
import com.opencsv.utility.SmartCsvWriter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@SpringBootTest
class SpringbootOpencsvApplicationTests {

    @Autowired
    private SmartCsvWriter smartCsvWriter;

    @Autowired
    private SmartCsvReader smartCsvReader;

    @Test
    public void writeSpaceships() throws CsvRequiredFieldEmptyException, CsvDataTypeMismatchException, IOException {
        smartCsvWriter.writeSpaceships();
    }

    @Test
    public void readSmartCsvFile() throws FileNotFoundException {
        List<User> spaceShips = smartCsvReader.readCsvFile();
        spaceShips.forEach(spaceship -> System.out.println(spaceship));
    }


}
