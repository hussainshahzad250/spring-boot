package com.sas.filedownload.utils;

import com.sas.filedownload.response.EmployeeResponse;

import java.io.PrintWriter;
import java.util.List;

public class PsvExporter {

    public static void downloadPsv(PrintWriter writer, List<EmployeeResponse> employees) {
        writer.write("Emp Id|First Name|Last Name|Email|Mobile|Designation \n");
        for (EmployeeResponse employee : employees) {
            writer.write(employee.getEmployeeId() + "|" + employee.getFirstName() + "|" + employee.getLastName() + "|" + employee.getEmail() + "|" + employee.getMobile() + "|" + employee.getDesignation() + "\n");
        }
    }
}
