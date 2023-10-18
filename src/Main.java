import java.io.IOException;

/**
 * Assertion: an assertion will throw an exception if the condition is false => assert x>=0;
 * if x is negative then an exception will throw
 * */

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        volumeII.InputOutput.main();
//        volumeII.StreamLibrary.main();
//        volumeI.concurrency.Main.main();
//        DeployingJavaApp.main();
//        SimpleFrameTest.main();
//        Swing.main();
//        CollectionFramework.main();
//        String[] words = { "Mary", "had", "a", "little", "lamb" };
//        GenericProgramming<String> mm = ArrayAlg.minmax(words);
//        System.out.println("min = " + mm.getFirst());
//        System.out.println("max = " + mm.getSecond());
//        System.out.println(GenericProgramming.getMiddle("petter", 1, "nina", false, "kevin", "arthur"));

//        GenericProgramming<String> obj = new GenericProgramming<>("hello");
//        System.out.println(obj.variable.getClass());
//        GenericProgramming.main();
//        Log.main();
//        LambdaExpressions.main();

        /**
         * All array types have a clone method that is public, not protected.You can
         * use it to make a new array that contains copies of all elements
         * */
//        int[] luckyNumbers = { 2, 3, 5, 7, 11, 13 };
//        int[] cloned = luckyNumbers.clone();
//        cloned[5] = 12; // doesn't change luckyNumbers[5]
//
//
//        ActionListener listener = new TimePrinter();
//        Timer t = new Timer(1000, listener);
//        TimePrinter l1 = new TimePrinter();
//        try {
//            TimePrinter l2 = l1.clone();
//        } catch (CloneNotSupportedException e) {
//            throw new RuntimeException(e);
//        }
//        t.start();
//        JOptionPane.showMessageDialog(null, "Quit program?");
//        System.exit(0);

//        ArrayList<Object> x = new ArrayList<Object>();
//        x.add(0,0);
//        x.add(0,1);
//        x.add(0,2);
//        x.add(0,3);
//        x.add(0,4);
//        x.add(0,5);
//        System.out.println(Arrays.toString(x.toArray()));
//        x.remove(0);
//        System.out.println(Arrays.toString(x.toArray()));
//
//
//        Manager boss = new Manager("Carl Cracker", 80000, 1987, 12, 15);
//        boss.setBonus(5000);
//        Employee[] staff = new Employee[3];
//        staff[0] = boss;
//        staff[1] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
//        staff[2] = new Employee("Tony Tester", 40000, 1990, 3, 15);
////        boss.setBonus(3000);
////        staff[0].setBonus(3000);
//        /**
//         * casting:
//         * */
//        Manager boss1 = (Manager) staff[0];
//        for (Employee e : staff)
//         System.out.println(e.getName() + " " + e.getSalary());
//
//        if(staff[0] instanceof Manager) System.out.println("emp");
//
//        Object obj = new Student("Pansy Parkinson", "witchcraft and wizardry");
//
//        Person[] people = new Person[2];
//        people[0] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
//        people[1] = new Student("Maria Morris", "computer science");
//        for (Person p : people)
//            System.out.println(p.getName() + ", " + p.getDescription());


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

//        Employee emp1 = new Employee("ali", 12000, 2023, 10,24);
//        Employee emp2 = new Employee("ali", 12000, 2023, 10,24);
//        Employee emp3 = emp1;
//        if(emp1.equals(emp2)) System.out.println("they are equal");
//        if(emp1.equals(emp3)) System.out.println("1 and 3 are equal");

    }
}