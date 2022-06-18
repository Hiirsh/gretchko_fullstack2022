package telran.employee.dao;

import telran.employee.model.Employee;

public interface Company {
    boolean addEmployee(Employee emp);

    Employee removeEmployee(int id);

    Employee findEmployeeByID(int id);

    double totalSalary();

    double averageSalary();

    double totalSales();

    int size();

    void printEmployees();
}
