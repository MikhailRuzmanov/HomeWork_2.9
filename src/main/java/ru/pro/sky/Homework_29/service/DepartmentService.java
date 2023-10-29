package ru.pro.sky.Homework_29.service;

import ru.pro.sky.Homework_29.model.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
    public List<Employee> getAllByDepartment(int dep);
    public List<Employee> getMin(int dep);
    public List<Employee> getMax(int dep);
    public List<Employee> getSum(int dep);



    public Map<Integer, List<Employee>> getAll();
}
