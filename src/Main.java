import java.time.LocalDate;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        Manager boss = new Manager("Carl Cracker", 80000, 1987, 12, 15);
        boss.setBonus(5000);
        Employee[] staff = new Employee[3];
        staff[0] = boss;
        staff[1] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
        staff[2] = new Employee("Tony Tester", 40000, 1990, 3, 15);
//        boss.setBonus(3000);
//        staff[0].setBonus(3000);
        /**
         * casting:
         * */
        Manager boss1 = (Manager) staff[0];
        for (Employee e : staff)
         System.out.println(e.getName() + " " + e.getSalary());

        if(staff[0] instanceof Manager) System.out.println("emp");

        Person[] people = new Person[2];
        people[0] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
        people[1] = new Student("Maria Morris", "computer science");
        for (Person p : people)
            System.out.println(p.getName() + ", " + p.getDescription());


//        System.out.println(new Date());
//        System.out.println(LocalDate.now());
//        LocalDate local = LocalDate.of(2000, 12,10);
//        System.out.println(local);
//
//        System.out.println(local.getYear());
//        System.out.println(local.getMonth());
//        System.out.println(local.getDayOfMonth());
//        System.out.println(local.getDayOfWeek());
//        System.out.println(local.getDayOfYear());
//        Employee employee = new Employee("ali", 18, 2005, 8, 24);
//        System.out.println("name: "+ employee.getName());
//        String n = employee.getName();
//        n = "mohammad";
//        System.out.println("n : " + n);
//        System.out.println("name: "+ employee.getName());



    }
}