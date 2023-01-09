package com.opencsv.request;

import java.time.LocalDate;

import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvCustomBindByPosition;

import com.opencsv.converter.LocalDateConverter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User {

	@CsvBindByPosition(position = 0)
	private Integer id;

	@CsvBindByPosition(position = 2)
	private String name;

	@CsvBindByPosition(position = 1)
	private Integer age;

	@CsvCustomBindByPosition(position = 3, converter = LocalDateConverter.class)
	private LocalDate birthDate;
}
