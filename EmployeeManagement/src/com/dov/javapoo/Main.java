
package com.dov.javapoo;

import com.dov.javapoo.poo.EmployeeManager;
import com.dov.javapoo.poo.Employee;


public class Main {
    public static void main(String[] args) {
        // Creating an instance of EmployeeManager to manage all employee-related operations
        EmployeeManager manager = new EmployeeManager();

        // Adding employees to the manager
        manager.addEmployee(new Employee("MA0001", "ALBERT", "NIELSON", "Directeur", 2000, 120000));
        manager.addEmployee(new Employee("MA0002", "MALIK", "YOAN", "Chef de service", 2001, 55000));
        manager.addEmployee(new Employee("MA0003", "VINCENT", "GOGH", "Informaticien", 2002, 40000));
        manager.addEmployee(new Employee("MA0004", "YOURI", "DODO", "Chef de service", 2003, 45000));
        manager.addEmployee(new Employee("MA0005", "NAEL", "MILES", "Informaticien", 2004, 45000));
        manager.addEmployee(new Employee("MA0006", "BOLAN", "KIKI", "Comptable", 2005, 45000));
        manager.addEmployee(new Employee("MA0007", "DOVER", "LOUIK", "Chef de service", 2006, 20000));
        manager.addEmployee(new Employee("MA0008", "KLIENS", "LYBE", "Informaticien", 2007, 35000));
        manager.addEmployee(new Employee("MA0009", "SIKA", "NIYLE", "Informaticien", 2008, 35000));
        manager.addEmployee(new Employee("MA0010", "JEAN", "DE DIEU", "Manager", 2009, 60000));
        manager.addEmployee(new Employee("MA0011", "DIANE", "SHUR", "CTO", 2010, 70000));

        // Displaying all employees
        System.out.println("\nAll Employees:");
        manager.displayAllEmployees();

        // Finding an employee by ID (existing employee)
        System.out.println("\nEmployee with ID MA0007:");
        Employee emp = manager.findEmployeeById("MA0007");
        if (emp != null) emp.display(); // Display the employee if found
        else System.out.println("Employee not found."); // Show message if not found

        // Finding an employee by ID (non-existing employee)
        System.out.println("\nEmployee with ID MAAGG7:");
        emp = manager.findEmployeeById("MAAGG7");
        if (emp != null) emp.display(); // Display the employee if found
        else System.out.println("Employee not found."); // Show message if not found

        // Displaying employees who started in the year 2008
        System.out.println("\nEmployees who started in 2008:");
        manager.findEmployeesByStartYear(2008).forEach(Employee::display);

        // Calculating the total payroll (sum of all employee salaries)
        System.out.println("\nTotal Payroll: $" + manager.calculateTotalPayroll());

        // Finding and displaying the most senior employees
        System.out.println("\nMost Senior Employees:");
        manager.findMostSeniorEmployees().forEach(Employee::display);

        // Finding the lowest salary among all employees
        System.out.println("\nLowest Salary: $" + manager.findLowestSalary());

        // Displaying employees who have the lowest salary
        System.out.println("\nEmployees with Lowest Salary:");
        manager.findEmployeesWithLowestSalary().forEach(Employee::display);

        // Increasing the salary of employees with the lowest salary by $550
        manager.increaseLowestSalary(550);
        System.out.println("\nAfter increasing lowest salary by $550:");
        manager.findEmployeesWithLowestSalary().forEach(Employee::display);

        // Displaying all IT employees (position: "Informaticien")
        System.out.println("\nIT Employees:");
        manager.findITEmployees().forEach(Employee::display);

        // Calculating the total salaries for "Chef de service" positions
        System.out.println("\nTotal Salaries for 'Chef de service': $" + manager.calculateTotalChefDeServiceSalaries());

        // Counting the number of employees with the "Chef de service" position
        System.out.println("\nNumber of 'Chef de service': " + manager.countChefDeService());

        // Listing all employees with the "Chef de service" position
        System.out.println("\nList of all 'Chef de service':");
        manager.listChefDeService().forEach(Employee::display);

        // Finding employees with more than 5 years of service (as of 2020)
        // and a salary between $15,000 and $60,000
        System.out.println("\nEmployees with >5 years of service (as of 2020) and salary between $15,000 and $60,000:");
        manager.findSeniorEmployeesWithSalaryRange().forEach(Employee::display);
    }
}
