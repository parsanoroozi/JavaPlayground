package volumeI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class TimePrinter implements ActionListener, Cloneable {

    /**
     * Does it matter if the copy is shallow? It depends. If the subobject shared between
     * the original and the shallow clone is immutable, then the sharing is safe.
     * This certainly happens if the subobject belongs to an immutable class, such as String.
     *
     * A subclass can call
     * a protected clone method only to clone its own objects.You must redefine clone
     * to be public to allow objects to be cloned by any method
     * */

    public TimePrinter clone() throws CloneNotSupportedException{
        return (TimePrinter) super.clone();
    }
    public void actionPerformed(ActionEvent event){
        System.out.println("at the tone, the time is: "+ new Date());
        Toolkit.getDefaultToolkit().beep();
    }
}
