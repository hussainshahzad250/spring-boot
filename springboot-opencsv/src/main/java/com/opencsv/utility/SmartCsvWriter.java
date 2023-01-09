package com.opencsv.utility;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.time.LocalDate;
import java.util.List;

import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import com.opencsv.request.User;
import com.opencsv.util.DateUtil;
import org.springframework.stereotype.Component;

@Component
public class SmartCsvWriter {

	public void writeSpaceships()
			throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
		Writer writer = new FileWriter("userdetails.csv");

		StatefulBeanToCsv<User> beanToCsv = new StatefulBeanToCsvBuilder<User>(writer).withSeparator(',')
				.withLineEnd(CSVWriter.DEFAULT_LINE_END).withOrderedResults(true).build();

		List<User> users = List.of(
				new User(10, "Sahil", 20, DateUtil.parseLocalDate("07-02-1992", DateUtil.DD_MM_YYYY)),
				new User(11, "Rahil", 22, DateUtil.parseLocalDate("07-02-1994", DateUtil.DD_MM_YYYY)),
				new User(12, "Hussain", 30, DateUtil.parseLocalDate("07-02-1996", DateUtil.DD_MM_YYYY)));

		beanToCsv.write(users);
		beanToCsv.write(new User(13, "Kishor", 35, LocalDate.now()));
		beanToCsv.getCapturedExceptions();
		writer.close();
	}
}
