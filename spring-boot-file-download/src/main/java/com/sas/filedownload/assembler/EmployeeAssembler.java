package com.sas.filedownload.assembler;

import com.sas.filedownload.entity.Employee;
import com.sas.filedownload.response.EmployeeResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmployeeAssembler {

    public List<EmployeeResponse> entityToDtoList(List<Employee> employees) {
        if (CollectionUtils.isEmpty(employees))
            return Collections.emptyList();
        return employees.stream().map(this::entityToDto).collect(Collectors.toList());
    }

    public EmployeeResponse entityToDto(Employee employee) {
        EmployeeResponse employeeResponse = new EmployeeResponse();
        employeeResponse.setEmployeeId(employee.getEmployeeId());
        employeeResponse.setFirstName(employee.getFirstName());
        employeeResponse.setLastName(employee.getLastName());
        employeeResponse.setEmail(employee.getEmail());
        employeeResponse.setMobile(employee.getMobile());
        employeeResponse.setDesignation(employee.getDesignation());
        return employeeResponse;
    }
}
