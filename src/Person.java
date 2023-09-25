public abstract class Person {
    /**
     * in abstract classes you can either write the method signature or really implement the method
     * this is the benefit of it over  interfaces cause in the interfaces you cannot implement methods
     * also Abstract classes cannot be instantiated
     * */
    private final String name;
    public Person(){
        this.name = "";
    }
    public Person(String name){
        this.name= name;
    }
    public String getName(){
        return this.name;
    }
    public abstract String getDescription();
}
