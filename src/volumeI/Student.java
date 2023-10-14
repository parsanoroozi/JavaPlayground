package volumeI;

public class Student extends Person{

    /**
     * protected => its like private but allows subclasses to use them...
     * 1. Visible to the class only (private).
     * 2. Visible to the world (public).
     * 3. Visible to the package and all subclasses (protected).
     * */

    /**
     * Object methods: 1) equals(), 2) hashCode(), 3) toString(), 4) getClass()
     * Class methods: 1) getName(), 2) getSuperclass()
     * */
    private String major;

    public Student(String name,String major){
        super(name);
        this.major = major;
    }
    public String getMajor(){
        return this.major;
    }
    @Override
    public String getDescription() {
        return "a student majoring in "+this.major;
    }
}
