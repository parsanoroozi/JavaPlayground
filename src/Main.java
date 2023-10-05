import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
import static java.lang.System.out;

public class Main {
    public static void main(String[] args) {

        out.println(Person.test);

        Person person = new Person();
        System.out.println(Person.getID());

//        Scanner scanner = new Scanner(System.in);
//        StringBuilder input = new StringBuilder();
//        while (scanner.hasNext()){
//            input.append(scanner.nextLine());
//        }
//        System.out.println("the input was: ");
//        System.out.println(input);

//        System.out.println("whats your name?");
//        String name = scanner.nextLine();
//        System.out.println("your name was "+name+", isn't it?");
//
//        String word = scanner.next();
//        System.out.println("and the next was : " + word+". wasn't it?");
//        System.out.println("your age? ");
//        int age = scanner.nextInt();
//        System.out.println("the age was: "+ age+". yeaahhhhh");





//        double x = 9.997;
//        int a = (int) x;
//        System.out.println(x);
//        System.out.println(a);
//        int b = (int) Math.round(x);
//        System.out.println(b);
//        System.out.println("Hello world!");
//        String builder = "hello" +
//                "from" +
//                "the" +
//                "other" +
//                "side";
//        System.out.println(builder);
//
//        String s1 = "take me to church I'll worship like a dog at the shrine of your lies";
//        s1 += ". i'll tell you my sins then you can sharpen your knife";
//        System.out.println(s1);
//        String[] words = {"parsa", "koosha", "ali", "hosein", "nima", "mehran", "ebrahim", "kamran", "bita"};
//        String joined = String.join("@", words);
//        System.out.println(joined);
//        System.out.println(s1.trim());
//        int[] codes = s1.codePoints().toArray();
//        Arrays.stream(s1.codePoints().toArray()).forEach(i -> System.out.println(i));
//        System.out.println(new String(codes, 0, codes.length));


//        Person man1 = new Person("Parsa", 23);
//        System.out.println(man1.getName());
//        System.out.println(man1.getAge());
//        System.out.println(man1.getClass());
//        System.out.println(man1);
//        System.out.println(man1.manSize);
//        man1.manSize = Person.Size.EXTRALARGE;
//        System.out.println(man1.manSize);
//        if(man1 instanceof Person){
//            System.out.println("its a person");
//        }
    }
}