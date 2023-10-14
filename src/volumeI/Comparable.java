package volumeI;

public interface Comparable <T>{
    /**
     *  all methods in an interface are public
     *  interfaces can inherit from each other => using implements
     *  classes and interfaces can implement multiple interfaces => class A implements I1,I2....
     *  benefit of an interface over an abstract class is that classes can only extend one class,
     *  but it's not true about the interfaces.
     *  Interfaces can contain static method.
     *  with default methods you can define methods that you don't need to implement(override) it inside the class.
     * */
    int compareTo(T other);
}
