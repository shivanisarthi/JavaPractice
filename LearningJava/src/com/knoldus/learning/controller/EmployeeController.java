package com.knoldus.learning.controller;

import com.knoldus.learning.entity.Employee;
import com.knoldus.learning.service.*;

import java.io.FileNotFoundException;
import java.util.List;

public class EmployeeController {

    public static void main(String[] a) throws FileNotFoundException {
        ValidateEmployeeService validateEmployeeService = new ValidateEmployeeServiceImpl();
        SaveEmployeeService saveEmployeeService = new SaveEmployeeServiceImpl();

        DatabaseReader readEmployeeData= new DatabaseReaderImpl();
        List<Employee> employList =  readEmployeeData.readDataFromEmployee();

        System.out.println("Total employee size  :  "+employList.size());

        for (Employee ob : employList) {
            if(validateEmployeeService.validateEmployee(ob))
                saveEmployeeService.saveEmployee(ob);
        }
        System.out.println("Saved employee  : " + saveEmployeeService.getEmployeeCount());
        }
}
