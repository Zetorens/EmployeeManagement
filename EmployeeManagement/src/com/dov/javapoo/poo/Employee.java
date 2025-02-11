package com.dov.javapoo.poo;

public class Employee {
    // Private attributes to store employee information
    private String id;
    private String lastName;
    private String firstName;
    private String position;
    private int startYear;
    private double salary;

    // Constructor to initialize an employee with all attributes
    public Employee(String id, String lastName, String firstName, String position, int startYear, double salary) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.position = position;
        this.startYear = startYear;
        this.salary = salary;
    }

    // Getters to access private attributes

    public String getId() { 
        return id;
    }

    public String getLastName() { 
        return lastName;
    }

    public String getFirstName() { 
        return firstName;
    }

    public String getPosition() { 
        return position;
    }

    public int getStartYear() { 
        return startYear;
    }

    public double getSalary() { 
        return salary;
    }

    // Setter to update the employee's salary
    public void setSalary(double salary) {
        this.salary = salary;
    }

    // Display method to print employee details
    public void display() {
        System.out.println("ID: " + id + ", Name: " + lastName + " " + firstName +
                ", Position: " + position + ", Start Year: " + startYear + ", Salary: $" + salary);
    }
}
