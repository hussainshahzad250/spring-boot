package com.sas.filedownload.utils;

import com.google.gson.Gson;
import com.sas.filedownload.response.EmployeeResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JsonExporter {

    public String export(List<EmployeeResponse> employeeResponses) {
        return new Gson().toJson(employeeResponses);
    }
}
