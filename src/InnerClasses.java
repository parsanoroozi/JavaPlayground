import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class InnerClasses {
    /**
     * 6.4 Inner Classes
     * An inner class is a class that is defined inside another class. Why would you want
     * to do that? There are three reasons:
     * • Inner class methods can access the data from the scope in which they are
     * defined—including the data that would otherwise be private.
     * • Inner classes can be hidden from other classes in the same package.
     * • Anonymous inner classes are handy when you want to define callbacks without
     * writing a lot of code.
     *
     * if you make your inner classes "local" => they can access even local variables that are defined inside a method...
     * but we can use them without changing them.
     * like bellow:
     * System.out.println("At the tone, the time is " + new Date());
     *  if (beep) Toolkit.getDefaultToolkit().beep();
     *  here we are using a field (beep) that is defined inside getDefaultToolkit() method.
     *
     *  6.4.6 Anonymous Inner Classes
     * When using local inner classes, you can often go a step further. If you want to
     * make only a single object of this class, you don’t even need to give the class a
     * name. Such a class is called an anonymous inner class.
     *
     * 6.4.7 Static Inner Classes
     * Occasionally, you may want to use an inner class simply to hide one class inside
     * another—but you don’t need the inner class to have a reference to the outer class
     * object. You can suppress the generation of that reference by declaring the inner
     * class static.
     *
     * NOTE: Unlike regular inner classes, static inner classes can have static fields
     * and methods
     *
     * NOTE: Inner classes that are declared inside an interface are automatically
     * static and public.
     * */

    private int interval;
    private boolean beep;
    public InnerClasses(int interval, boolean beep){
        this.interval = interval;
        this.beep = beep;
    }

    public class TimePrinter implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("At the tone, the time is " + new Date());
            // or you can simply write "beep" for reaching the outer classes' fields
            if (InnerClasses.this.beep) Toolkit.getDefaultToolkit().beep();


        }
    }
}
