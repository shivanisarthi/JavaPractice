package com.knoldus.learning.service;

import com.knoldus.learning.entity.Employee;

import java.io.FileNotFoundException;
import java.util.List;

public interface DatabaseReader {
    public List<Employee> readDataFromEmployee() throws FileNotFoundException;
}
