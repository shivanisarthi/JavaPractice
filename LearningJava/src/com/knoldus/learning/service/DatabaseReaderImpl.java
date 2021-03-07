package com.knoldus.learning.service;

import com.knoldus.learning.entity.Employee;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseReaderImpl implements DatabaseReader{

    @Override
    public List<Employee> readDataFromEmployee() throws FileNotFoundException {
        String stringsline = "";
        String comma = ",";

        List<Employee> employList = new ArrayList<>();
        try
        {
            BufferedReader bufferedReaderObject = new BufferedReader(new FileReader("./src/com/knoldus/learning/Database/Data.csv"));
            while((stringsline = bufferedReaderObject.readLine())!=null)
            {
                String[] employeeDataOb = stringsline.split(comma);
                Employee employee = new Employee(Integer.parseInt(employeeDataOb[0]) , employeeDataOb[1]);
                employList.add(employee);
            }
        }
        catch(IOException ioException)
        {
            ioException.printStackTrace();
        }
        return employList;
    }
}
