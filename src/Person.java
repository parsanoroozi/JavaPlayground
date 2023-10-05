

public class Person {

    static int test = 12;

    enum Size {SMALL, MEDIUM, LARGE, EXTRALARGE};
    private String name;
    private int age;
    private static int ID = 20;

    {
        System.out.println("before init, for obj");
    }

    static
    {
        System.out.println("before init, for static");
        ID = 25;
    }

    public Size manSize = Size.LARGE;

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public Person(){
        this("parsa", 23);
        System.out.println("no args constructor!");
    }

    public static int getID(){
        return ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
