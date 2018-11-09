package com.mohit.dao;

import java.awt.Choice;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mohit.model.Employee;
public class EmployeeTest {
    private static int choice;
    public static void main(String[] args) {
        EmployeeDaoImpl empOperations = new EmployeeDaoImpl();
        Employee e1 = new Employee();
        do {
            System.out.println("1. Insert ");
            System.out.println("2. List ");
            System.out.println("3. Exit ");
            System.out.println("Enter your choice ");
            Scanner sc = new Scanner(System.in);
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter the employee Number ");
                    Scanner sc1 = new Scanner(System.in);
                    int empid = sc1.nextInt();
                    System.out.println("Enter the employee Name ");
                    Scanner sc2 = new Scanner(System.in);
                    String empname = sc2.nextLine();
                    System.out.println("Enter the Salary ");
                    Scanner sc3 = new Scanner(System.in);
                    double empsal = sc3.nextDouble();
                    e1.setEmpid(empid);
                    e1.setEmpname(empname);
                    e1.setSalary(empsal);
                    empOperations.insertEmployee(e1);
                    break;
                case 2:
                     empOperations.findAllEmployees();
                    break;
            }
        } while (choice != 3);
    }
}
