package telran.employee.model;

public class Manager extends Employee {
    private double baseSalary;
    private double grade;

    public Manager(int id, String firstName, String lastName, double hours, double baseSalary, double grade) {
        super(id, firstName, lastName, hours);
        this.baseSalary = baseSalary;
        this.grade = grade;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public double calcSallary() {
        double salary = baseSalary + hours * grade;
        return salary < minWage * hours ? minWage * hours : salary;
    }
}
