package telran.employee.dao;

import telran.employee.model.Employee;
import telran.employee.model.SalesManager;

public class CompanyImpl implements Company {

    Employee[] employees;
    int size;

    public CompanyImpl(int capacity) {
        employees = new Employee[capacity];
    }

    public int size() {
        return size;
    }

    private void setSize(int size) {
        this.size = size;
    }

    @Override
    public boolean addEmployee(Employee employee) {
        if (employee == null) {
            return false;
        }
        for (int i = 0; i <= size(); i++) {
            if (employees[i] == null) {
                setSize(i + 1);
                break;
            }
            if (employees[i].getId() == employee.getId()) {
                return false;
            }
        }
        employees[size() - 1] = employee;
        return true;
    }

    @Override
    public Employee removeEmployee(int id) {
        for (int i = 0; i < size(); i++) {
            if (employees[i].getId() == id) {
                int size = size();
                Employee tempEmpl = employees[i];
                employees[i] = employees[size - 1];
                employees[size - 1] = null;
                setSize(size - 1);
                return tempEmpl;
            }
        }
        return null;
    }

    @Override
    public Employee findEmployeeByID(int id) {
        for (int i = 0; i < size(); i++) {
            if (employees[i].getId() == id) {
                return employees[i];
            }
        }
        return null;
    }

    @Override
    public double totalSalary() {
        double res = 0;
        for (int i = 0; i < size(); i++) {
            if (employees[i] != null) {
                res += employees[i].calcSallary();
            }
        }
        return res;
    }

    @Override
    public double averageSalary() {
        return totalSalary() / size;
    }

    @Override
    public double totalSales() {
        double res = 0;
        for (int i = 0; i < size(); i++) {
            if (employees[i]!=null&&employees[i] instanceof SalesManager) {
                SalesManager temp = (SalesManager) employees[i];
                res += temp.getSalesValue();
            }
        }
        return res;
    }

       @Override
    public void printEmployees() {
        for (int i = 0; i < size(); i++) {
            System.out.println(employees[i].toString());
        }
    }

}
