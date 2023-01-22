package com.sas.filedownload.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EmployeeResponse {
    private Long employeeId;
    private String firstName;
    private String lastName;
    private String email;
    private String mobile;
    private String designation;
}
