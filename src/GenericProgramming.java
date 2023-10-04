import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Logger;

/**
 * . How do
 * we know that the class to which T belongs has a compareTo method?
 * The solution is to restrict T to a class that implements the Comparable interface—a
 * standard interface with a single method, compareTo. You can achieve this by giving
 * a bound for the type variable T:
 * public static <T extends Comparable> T min(T[] a) . . .
 * */

/**
 * 8.6.9 You Can Defeat Checked Exception Checking
 * A bedrock principle of Java exception handling is that you must provide a handler
 * for all checked exceptions. You can use generics to defeat this scheme. The key
 * ingredient is this method:
 * @SuppressWarnings("unchecked")
 * public static <T extends Throwable> void throwAs(Throwable e) throws T
 * {
 *  throw (T) e;
 * }
 *
 *
 * When you work with generic classes, you need to learn a few rules about inheritance and subtypes. Let’s start with a situation which many programmers find
 * unintuitive. Consider a class and a subclass, such as Employee and Manager. Is Pair<Manager>
 * a subclass of Pair<Employee>? Perhaps surprisingly, the answer is “no.”
 *
 * wild card type:
 * public static void printBuddies(Pair<? extends Employee> p)
 * */

public class GenericProgramming<T extends Object> {

    private T first;
    private T second;

    public T variable;

    public GenericProgramming(){this.first=null;this.second=null;}
    public GenericProgramming(T first, T second){
        this.first = first;
        this.second = second;
    }

    public GenericProgramming(T t){
        this.variable = t;
    }

    public T getFirst(){return this.first;}
    public T getSecond(){return this.second;}
    public void setFirst(T first){this.first = first;}
    public void setSecond(T second){this.second = second;}

    /**
     * Generic methods can get defined inside either a generic class or an ordinary class
     * and unlike generic classes you don't need to define the type, you just have to pass the values in any type that you want
     * */
    public static <T> T getMiddle(T... a){
        return a[a.length/2];
    }


    public static ArrayList<String> stringList = new ArrayList<>();

    public static void main(){

        stringList.add("a");
        stringList.add("b");
        stringList.add("c");
        stringList.add("d");
        stringList.add("e");
        Logger.getGlobal().info(stringList.toString());


    }
}
