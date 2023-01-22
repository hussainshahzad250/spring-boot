package com.sas.filedownload.service;

import com.sas.filedownload.response.EmployeeResponse;

import java.util.List;

public interface EmployeeService {

    List<EmployeeResponse> fetchEmployee();
}
