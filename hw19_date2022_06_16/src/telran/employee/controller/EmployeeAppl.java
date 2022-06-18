package telran.employee.controller;

import telran.employee.dao.CompanyImpl;
import telran.employee.model.Employee;
import telran.employee.model.Manager;
import telran.employee.model.SalesManager;
import telran.employee.model.WageEmployee;

public class EmployeeAppl {
    public static void main(String[] args) {
        Employee[] firm = new Employee[5];
        firm[0] = new Manager(1000, "John", "Smith", 182, 20_000, 20);
        firm[1] = new WageEmployee(2000, "Mary", "Smith", 182, 40);
        firm[2] = new SalesManager(3000, "Peter", "Griffin", 182, 40000, 0.1);
        firm[3] = new SalesManager(4000, "Tigran", "Petrosyan", 81, 80000, 0.1);
        CompanyImpl company = new CompanyImpl(5);
        for (int i = 0; i < firm.length; i++) {
            company.addEmployee(firm[i]);    
        }
        company.printEmployees();
        System.out.println("Total salary " + company.totalSalary());
    }
}
