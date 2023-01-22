package com.sas.filedownload.service;

import com.sas.filedownload.assembler.EmployeeAssembler;
import com.sas.filedownload.entity.Employee;
import com.sas.filedownload.repository.EmployeeRepository;
import com.sas.filedownload.response.EmployeeResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeAssembler employeeAssembler;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<EmployeeResponse> fetchEmployee() {
        List<Employee> employees = employeeRepository.findAll();
        return employeeAssembler.entityToDtoList(employees);
    }
}
