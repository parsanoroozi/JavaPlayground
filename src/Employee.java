import java.time.LocalDate;

public class Employee extends Person {

    /**
     * final keyword:
     * final in class => public final class Name: it prevents other classes to inherit from it
     * final in method => public final int getSalary(): it prevents subclasses to override this method
     * final in field => it makes the variable or field, a constant
     * (actually final prevents polymorphism and dynamic binding)
     * */
    private String name;
    private double salary;
    private LocalDate hireDay;

    public Employee()
    {
        name = "";
        salary = 0;
        hireDay = LocalDate.now();
    }

    public Employee(String name, double salary, int year, int month, int day){
        this.name = name;
        this.salary = salary;
        this.hireDay = LocalDate.of(year, month, day);
    }

    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return String.format("an employee with a salary of $%.2f", salary);
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public LocalDate getHireDay() {
        return hireDay;
    }

    public void setHireDay(LocalDate hireDay) {
        this.hireDay = hireDay;
    }
}
