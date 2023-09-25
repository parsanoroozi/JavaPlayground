import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        ArrayList<Object> x = new ArrayList<Object>();
        x.add(0,0);
        x.add(0,1);
        x.add(0,2);
        x.add(0,3);
        x.add(0,4);
        x.add(0,5);
        System.out.println(Arrays.toString(x.toArray()));
        x.remove(0);
        System.out.println(Arrays.toString(x.toArray()));


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

        Object obj = new Student("Pansy Parkinson", "witchcraft and wizardry");

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

        Employee emp1 = new Employee("ali", 12000, 2023, 10,24);
        Employee emp2 = new Employee("ali", 12000, 2023, 10,24);
        Employee emp3 = emp1;
        if(emp1.equals(emp2)) System.out.println("they are equal");
        if(emp1.equals(emp3)) System.out.println("1 and 3 are equal");

    }
}