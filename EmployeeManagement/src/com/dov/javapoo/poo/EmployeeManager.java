package com.dov.javapoo.poo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeManager {
    // List to store all employee objects
    private List<Employee> employees;

    // Constructor to initialize the employee list
    public EmployeeManager() {
        employees = new ArrayList<>();
    }

    // Add an employee to the list
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    // Display all employees in the list
    public void displayAllEmployees() {
        employees.forEach(Employee::display);
    }

    // Find an employee by their ID (matricule)
    public Employee findEmployeeById(String id) {
        return employees.stream()
                .filter(emp -> emp.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    // Find employees who started in a specific year
    public List<Employee> findEmployeesByStartYear(int year) {
        return employees.stream()
                .filter(emp -> emp.getStartYear() == year)
                .collect(Collectors.toList());
    }

    // Calculate the total payroll (sum of all salaries)
    public double calculateTotalPayroll() {
        return employees.stream()
                .mapToDouble(Employee::getSalary)
                .sum();
    }

    // Find the most senior employees (employees with the earliest start year)
    public List<Employee> findMostSeniorEmployees() {
        int earliestYear = employees.stream()
                .mapToInt(Employee::getStartYear)
                .min()
                .orElse(0);

        return employees.stream()
                .filter(emp -> emp.getStartYear() == earliestYear)
                .collect(Collectors.toList());
    }

    // Find the lowest salary among all employees
    public double findLowestSalary() {
        return employees.stream()
                .mapToDouble(Employee::getSalary)
                .min()
                .orElse(0);
    }

    // Find employees who have the lowest salary
    public List<Employee> findEmployeesWithLowestSalary() {
        double minSalary = findLowestSalary();
        return employees.stream()
                .filter(emp -> emp.getSalary() == minSalary)
                .collect(Collectors.toList());
    }

    // Increase the salary of employees who have the lowest salary
    public void increaseLowestSalary(double increment) {
        double minSalary = findLowestSalary();
        employees.stream()
                .filter(emp -> emp.getSalary() == minSalary)
                .forEach(emp -> emp.setSalary(emp.getSalary() + increment));
    }

    // Find all employees with the position "computer scientist"
    public List<Employee> findITEmployees() {
        return employees.stream()
                .filter(emp -> emp.getPosition().equalsIgnoreCase("computer scientist"))
                .collect(Collectors.toList());
    }

    // Calculate the total salaries of "head of department" employees
    public double calculateTotalChefDeServiceSalaries() {
        return employees.stream()
                .filter(emp -> emp.getPosition().equalsIgnoreCase("head of department"))
                .mapToDouble(Employee::getSalary)
                .sum();
    }

    // Count the number of employees with the position "head of department"
    public long countChefDeService() {
        return employees.stream()
                .filter(emp -> emp.getPosition().equalsIgnoreCase("head of department"))
                .count();
    }

    // List all employees with the position "head of department"
    public List<Employee> listChefDeService() {
        return employees.stream()
                .filter(emp -> emp.getPosition().equalsIgnoreCase("head of department"))
                .collect(Collectors.toList());
    }

    // Find employees with more than 5 years of service (compared to 2020)
    // and with a salary between 15,000 and 60,000
    public List<Employee> findSeniorEmployeesWithSalaryRange() {
        return employees.stream()
                .filter(emp -> (2020 - emp.getStartYear()) > 5)
                .filter(emp -> emp.getSalary() >= 15000 && emp.getSalary() <= 60000)
                .collect(Collectors.toList());
    }
}
