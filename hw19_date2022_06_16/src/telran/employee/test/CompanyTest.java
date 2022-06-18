package telran.employee.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Assertions.*;

import telran.employee.dao.Company;
import telran.employee.dao.CompanyImpl;
import telran.employee.model.Employee;
import telran.employee.model.Manager;
import telran.employee.model.SalesManager;
import telran.employee.model.WageEmployee;

public class CompanyTest {
    CompanyImpl company;
    Employee[] firm;

    @BeforeEach
    void setUp() throws Exception {
        company = new CompanyImpl(5);
        firm = new Employee[5];
        firm = new Employee[5];
        firm[0] = new Manager(1000, "John", "Smith", 182, 20_000, 20);
        firm[1] = new WageEmployee(2000, "Mary", "Smith", 182, 40);
        firm[2] = new SalesManager(3000, "Peter", "Jackson", 182, 40_000, 0.1);
        firm[3] = new SalesManager(4000, "Tigran", "Petrosian", 91, 80_000, 0.1);
        for (int i = 0; i < firm.length; i++) {
            company.addEmployee(firm[i]);
        }
    }

    @Test
    public void testAddEmployee() {
        assertFalse(company.addEmployee(firm[3]));
        Employee employee = new SalesManager(5000, "Michael", "Shumaher", 182, 70_000, 0.1);
        assertTrue(company.addEmployee(employee));
        assertEquals(5, company.size());
    }

    @Test
    void testRemoveEmployee() {
        assertEquals(firm[3], company.removeEmployee(4000));
    }

    @Test
    void testFindEmployee() {
        assertEquals(firm[3], company.findEmployeeByID(4000));
        assertTrue(company.findEmployeeByID(4010) == null);
    }

    @Test
    void testTotalSalary() {
        assertEquals(44380.0, company.totalSalary());
    }

    @Test
    void testAverageSalary() {
        assertEquals(11095, company.averageSalary());
    }

    @Test
    void testTotalSales() {
        assertEquals(120_000, company.totalSales());
    }

    @Test
    void testSize() {
        assertEquals(4, company.size());
    }

    @Test
    void testPrintEmployees() {
        final PrintStream standardOut = System.out;
        final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        CompanyImpl company = new CompanyImpl(1);
        company.addEmployee(new SalesManager(1, "John", "Doy", 182, 80_000, 0.1));
        company.printEmployees();
        assertEquals("firstName=John, id=1, lastName=Doy, salary=8000.0", outputStreamCaptor.toString().trim());
    }
}
