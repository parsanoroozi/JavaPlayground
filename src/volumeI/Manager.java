package volumeI;

import java.io.Serializable;

public class Manager extends Employee implements Serializable, Cloneable {
    /**
     *The fact that an object variable (such as the variable e) can refer to multiple actual
     * types is called polymorphism. Automatically selecting the appropriate method at
     * runtime is called dynamic binding. We discuss both topics in more detail in this
     * chapter.
     */

    /**
     * At runtime, the call e.getSalary() is resolved as follows:
     * 1. First, the virtual machine fetches the method table for the actual type of e.
     * That may be the table for Employee, Manager, or another subclass of Employee.
     * 2. Then, the virtual machine looks up the defining class for the getSalary()
     * signature. Now it knows which method to call.
     * 3. Finally, the virtual machine calls the method.
     * Dynamic binding has a very important property: It makes programs extensible
     * without the need for modifying existing code. Suppose a new class Executive is
     * added and there is the possibility that the variable e refers to an object of that
     * class. The code containing the call e.getSalary() need not be recompiled. The
     * Executive.getSalary() method is called automatically if e happens to refer to an object
     * of type Executive.
     * */
    private double bonus;

    public Manager(String name, double salary, int year, int month, int day){
        super(name,salary,year,month,day);
        this.bonus = 0;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getSalary(){
        return super.getSalary() + this.bonus;
    }
}
