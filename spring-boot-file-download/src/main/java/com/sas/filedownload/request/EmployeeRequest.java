package com.sas.filedownload.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EmployeeRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String mobile;
    private String designation;
}
