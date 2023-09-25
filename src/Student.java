public class Student extends Person{

    /**
     * protected => its like private but allows subclasses to use them...
     * 1. Visible to the class only (private).
     * 2. Visible to the world (public).
     * 3. Visible to the package and all subclasses (protected).
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
