import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * • SEVERE
 * • WARNING
 * • INFO
 * • CONFIG
 * • FINE
 * • FINER
 * • FINEST
 * By default, the top three levels are actually logged. You can set a different
 * level—for example,
 * logger.setLevel(Level.FINE)
 *
 *
 * A program may contain multiple resource bundles—for example, one for menus
 * and another for log messages. Each resource bundle has a name (such as
 * "com.mycompany.logmessages"). To add mappings to a resource bundle, supply a file for
 * each locale. English message mappings are in a file com/mycompany/logmessages_en.properties,
 * and German message mappings are in a file com/mycompany/logmessages_de.properties. (The
 * en and de are the language codes.) You place the files together with the class files
 * of your application, so that the ResourceBundle class will automatically locate them.
 * These files are plain text files, consisting of entries such as
 * readingFile=Achtung! Datei wird eingelesen
 * renamingFile=Datei wird umbenannt
 * . . .
 * When requesting a logger, you can specify a resource bundle:
 * Logger logger = Logger.getLogger(loggerName, "com.mycompany.logmessages");
 * Then you specify the resource bundle key, not the actual message string, for the
 * log message.
 * logger.info("readingFile");
 * You often need to include arguments into localized messages. A message may
 * contain placeholders: {0}, {1}, and so on. For example, to include the file name
 * with a log message, use the placeholder like this:
 * Reading file {0}.
 * Achtung! Datei {0} wird eingelesen.
 * Then, to pass values into the placeholders, call one of the following methods:
 * logger.log(Level.INFO, "readingFile", fileName);
 * logger.log(Level.INFO, "renamingFile", new Object[] { oldName, newName });
 *
 * */
public class Log
{
    private static final Logger myLogger = Logger.getLogger("com.mycompany.myapp");

    public static void main(String [] args){
        System.out.println("running the class");
    }
    public static void main(){
//        Logger.getGlobal().setLevel(Level.OFF);
        Logger.getGlobal().info("File-> open menu item selected");
        String message = "log message it is";
        myLogger.warning(message);
        myLogger.fine(message);
        myLogger.log(Level.FINE, message);



    }
}
