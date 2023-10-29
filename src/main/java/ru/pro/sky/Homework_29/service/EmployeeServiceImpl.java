package ru.pro.sky.Homework_29.service;

import org.springframework.stereotype.Service;
import ru.pro.sky.Homework_29.exeption.EmployeeAlreadyAddedException;
import ru.pro.sky.Homework_29.exeption.EmployeeNotFoundException;
import ru.pro.sky.Homework_29.model.Employee;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private final Map<String, Employee> employeeMap;


    public EmployeeServiceImpl() {
        this.employeeMap = new HashMap<>();

    }

    @Override
    public Employee add (String firstName, String lastName,  int salary, int department){
        Employee employee = new Employee(firstName, lastName, salary, department);
        String s= firstName + lastName;
        if (employeeMap.containsKey(s)) {
            throw new EmployeeAlreadyAddedException();
        }
        employeeMap.put(s, employee);
        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName, int salary, int department){
        Employee employee = new Employee(firstName, lastName, salary, department);
        if (employeeMap.containsValue(employee)) {
            String s= firstName + lastName;
            employeeMap.remove(s);
            return employee;
        }
        throw new EmployeeNotFoundException();
    }


    @Override
    public Employee find (String firstName, String lastName, int salary, int department){
        Employee employee = new Employee(firstName, lastName, salary, department);
        String s= firstName + lastName;
        if (employeeMap.containsKey(s)) {
            return employee;
        }

        throw new EmployeeNotFoundException();
    }


    @Override
    public Collection<Employee> findAll () {
        return Collections.unmodifiableCollection(employeeMap.values());
    }

    @Override
    public Map<String, Employee> getMap(){
        return employeeMap;
    }




}
