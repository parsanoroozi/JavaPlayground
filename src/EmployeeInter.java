public class EmployeeInter implements Comparable<Employee>{
    @Override
    public int compareTo(Employee otherObject) {
        Employee other = (Employee) otherObject;
        return Double.compare(other.getSalary(), ((Employee) otherObject).getSalary());
    }
}
