package volumeI;

import java.util.Arrays;
import java.util.Comparator;
import javax.swing.*;


public class LambdaExpressions {

    /**
     * A lambda expression is a block of code that you can pass around.
     * so it can be executed later, once or multiple times.
     */
    public static void main(){
        System.out.println("we are ready to start lambda expressions");
        Comparator<String> comp
                = (first, second) // Same as (String first, String second)
                -> first.length() - second.length();

        String[] planets = new String[] { "Mercury", "Venus", "Earth", "Mars",
                "Jupiter", "Saturn", "Uranus", "Neptune" };
        System.out.println(Arrays.toString(planets));
        System.out.println("Sorted in dictionary order:");
        Arrays.sort(planets);
        System.out.println(Arrays.toString(planets));
        System.out.println("Sorted by length:");
        Arrays.sort(planets, comp);
        System.out.println(Arrays.toString(planets));

        /**
         * instead of that, if this is about calling a function in lambda...
         * */
        Timer t = new Timer(1000, event -> System.out.println(event));
        /**
         * you can simply do that...
         * */
        Timer t1 = new Timer(1000, System.out::println);

        /**
         * or like bellow:
         * Arrays.sort(strings, String::compareToIgnoreCase);
         * */

        /**
         * • object::instanceMethod
         * • Class::staticMethod
         * • Class::instanceMethod
         *
         * You can capture the "this" parameter in a method reference. For example, this::equals
         * is the same as x -> this.equals(x). It is also valid to use super. The method expression
         * super::instanceMethod
         * uses this as the target and invokes the superclass version of the given method
         *
         * Constructor references are just like method references, except that the name of
         * the method is new. For example, Person::new is a reference to a Person constructor.
         *         ArrayList<String> names = . . .;
         *         Stream<Person> stream = names.stream().map(Person::new);
         *         List<Person> people = stream.collect(Collectors.toList());
         *
         *         Person[] people = stream.toArray(Person[]::new);
         *
         * The rule is that any captured variable in a lambda expression must be effectively
         * final => the capture variable is a variable that we use inside our lambda, but it has been declared outside of it
         *
         * To accept the lambda, we need to pick (or, in rare cases, provide) a functional
         * interface. Table 6.1 lists the most important functional interfaces that are provided
         * in the Java API. In this case, we can use the Runnable interface:
         * public static void repeat(int n, Runnable action)
         * {
         *  for (int i = 0; i < n; i++) action.run();
         * }
         * */

        /**
         * 6.3.8 More about Comparators
         * The Comparator interface has a number of convenient static methods for creating
         * comparators. These methods are intended to be used with lambda expressions
         * or method references.
         * The static comparing method takes a “key extractor” function that maps a type T to
         * a comparable type (such as String). The function is applied to the objects to be
         * compared, and the comparison is then made on the returned keys. For example,
         * suppose you have an array of Person objects. Here is how you can sort them
         * by name:
         * Arrays.sort(people, Comparator.comparing(Person::getName));
         * */









    }
}
