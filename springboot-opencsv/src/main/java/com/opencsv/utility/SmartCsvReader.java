package com.opencsv.utility;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.request.User;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

@Component
public class SmartCsvReader {

	public List<User> readCsvFile() throws FileNotFoundException {
		FileReader reader = new FileReader("userdetails.csv");
		CsvToBean<User> csvtobean = new CsvToBeanBuilder<User>(reader).withType(User.class)
				.withSeparator(',').build();

		return csvtobean.parse();
	}
}
