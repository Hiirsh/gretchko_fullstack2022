package telran.employee.model;

public class WageEmployee extends Employee {

    private double wage;

    public WageEmployee(int id, String firstName, String lastName, double hours, double wage) {
        super(id, firstName, lastName, hours);
        this.wage = wage;
    }

    public double getwage() {
        return wage;
    }

    public void setwage(double wage) {
        this.wage = wage;
    }

    public double calcSallary() {
        return wage < minWage ? minWage : wage * hours;
    }
}
