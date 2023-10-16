package volumeII;

import volumeI.Employee;
import volumeI.Manager;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static java.lang.System.in;

public class InputOutput {
    /**
     * In the Java API, an object from which we can read a sequence of bytes is called
     * an input stream. An object to which we can write a sequence of bytes is called an
     * output stream. These sources and destinations of byte sequences can be—and often
     * are—files, but they can also be network connections and even blocks of memory.
     * */
    public static void main() throws IOException, ClassNotFoundException {

        /**
         * The available method lets you check the number of bytes that are currently available
         * for reading. This means a fragment like the following is unlikely to block:
         * int bytesAvailable = in.available();
         * if (bytesAvailable > 0)
         * {
         *  byte[] data = new byte[bytesAvailable];
         *  in.read(data);
         * }
         *
         * When you have finished reading or writing to an input/output stream, close it
         * by calling the close method.
         * */
        int byteAvailable = in.available();
        if (byteAvailable > 0){
            byte [] data = new byte[byteAvailable];
            in.read(data);
        }

        /**
         *  Finally, there are input/output streams
         * that do useful stuff; for example, the ZipInputStream and ZipOutputStream let you read
         * and write files in the familiar ZIP compression format.
         *
         * Java uses a clever mechanism to separate two kinds of responsibilities. Some input
         * streams (such as the FileInputStream and the input stream returned by the openStream
         * method of the URL class) can retrieve bytes from files and other more exotic locations. Other input streams (such as the DataInputStream) can assemble bytes into more
         * useful data types. The Java programmer has to combine the two. For example, to
         * be able to read numbers from a file, first create a FileInputStream and then pass it to
         * the constructor of a DataInputStream.
         * FileInputStream fin = new FileInputStream("employee.dat");
         * DataInputStream din = new DataInputStream(fin);
         * double x = din.readDouble();
         * 56 Chapter 2 Input and Output
         * */

        /**
         * When saving data, you have the choice between binary and text formats. For example, if the integer 1234 is saved in binary, it is written as the sequence of bytes
         * 00 00 04 D2 (in hexadecimal notation). In text format, it is saved as the string "1234".
         * Although binary I/O is fast and efficient, it is not easily readable by humans.
         * */

        /**
         * PrintWriter out = new PrintWriter("employee.txt", "UTF-8");
         * is equivalent to
         * PrintWriter out = new PrintWriter(
         *  new FileOutputStream("employee.txt"), "UTF-8");
         * */
        PrintWriter out = new PrintWriter("employee.txt", "UTF-8");
        String name = "Harry Hacker";
        double salary = 75000;
        out.println(name);
        out.print(' ');
        out.println(salary);
        out.println("that's all!");
        out.close();
        List<String> lines = Files.readAllLines( Path.of("employee.txt"));
        System.out.println(lines);

        /**
         * The RandomAccessFile class lets you read or write data anywhere in a file. Disk files
         * are random-access, but input/output streams that communicate with a network
         * socket are not.
         *
         * ZIP archives store one or more files in a (usually) compressed format. Each ZIP
         * archive has a header with information such as the name of each file and the
         * compression method that was used. In Java, you can use a ZipInputStream to read a
         * ZIP archive. You need to look at the individual entries in the archive. The getNextEntry
         * method returns an object of type ZipEntry that describes the entry. Pass the entry
         * to the getInputStream method of the ZipInputStream to obtain an input stream for reading
         * the entry. Then call closeEntry to read the next entry. Here is a typical code sequence
         * to read through a ZIP file:
         * ZipInputStream zin = new ZipInputStream(new FileInputStream(zipname));
         * ZipEntry entry;
         * while ((entry = zin.getNextEntry()) != null)
         * {
         *  InputStream in = zin.getInputStream(entry);
         * read the contents of in
         *  zin.closeEntry();
         * }
         * zin.close();
         * */

        /**
         * we can store and  read objects with binary formats
         * ,but we need our class to implement Serializable.
         * Saving such a network of objects is a challenge. Of course, we cannot save and
         * restore the memory addresses for the secretary objects. When an object is
         * reloaded, it will likely occupy a completely different memory address than it
         * originally did.
         * Instead, each object is saved with the serial number, hence the name object
         * serialization for this mechanism
         * */

        ObjectOutputStream outO = new ObjectOutputStream(new FileOutputStream("employeeObject.dat"));
        Employee harry = new Employee("Harry Hacker", 50000, 1989, 10, 1);
        Manager boss = new Manager("Carl Cracker", 80000, 1987, 12, 15);
        outO.writeObject(harry);
        outO.writeObject(boss);
        outO.close();

        ObjectInputStream in = new ObjectInputStream(new FileInputStream("employeeObject.dat"));
        Employee e1 = (Employee) in.readObject();
        Employee e2 = (Employee) in.readObject();

        System.out.println(e1.toString());
        System.out.println(e2.toString());

        /**
         * There is an amusing use for the serialization mechanism: It gives you an easy
         * way to clone an object, provided the class is serializable. Simply serialize it to an
         * output stream and then read it back in. The result is a new object that is a deep
         * copy of the existing object. You don’t have to write the object to a file—you can
         * use a ByteArrayOutputStream to save the data into a byte array.
         * */
        Employee harry1 = new Employee("Harry Hacker", 35000, 1989, 10, 1);
        try {
            Employee harry2 = (Employee) harry1.clone();
            harry1.setName("not Harry anymore");
            System.out.println(harry1.getName());
            System.out.println(harry2.getName());
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }

        /**
         *  the input/output stream classes are concerned with the contents of files, whereas the classes that
         * we discuss here are concerned with the storage of files on a disk.
         * */

        /** PATH: There's a Path class with many methods and fields for working with absolute and relative paths... */
        Path absolute = Paths.get("/home", "harry");
        Path relative = Paths.get("myprog", "conf", "user.properties");
        System.out.println("absolute path : " + absolute);
        System.out.println("relative path : " + relative);

        /**
         * The Files class makes quick work of common file operations. For example, you
         * can easily read the entire contents of a file:
         * byte[] bytes = Files.readAllBytes(path);
         * If you want to read the file as a string, call readAllBytes followed by
         * String content = new String(bytes, charset);
         * But if you want the file as a sequence of lines, call
         * List<String> lines = Files.readAllLines(path, charset);
         * Conversely, if you want to write a string, call
         * Files.write(path, content.getBytes(charset));
         * To append to a given file, use
         * Files.write(path, content.getBytes(charset), StandardOpenOption.APPEND);
         * You can also write a collection of lines with
         * Files.write(path, lines);
         *
         * To create a new directory, call
         * Files.createDirectory(path);
         * All but the last component in the path must already exist.To create intermediate
         * directories as well, use
         * Files.createDirectories(path);
         *
         * To copy a file from one location to another, simply call
         * Files.copy(fromPath, toPath);
         * To move the file (that is, copy and delete the original), call
         * Files.move(fromPath, toPath);
         * Finally, to delete a file, simply call
         * Files.delete(path);
         * This method throws an exception if the file doesn’t exist, so instead you may want
         * to use
         * boolean deleted = Files.deleteIfExists(path);
         *
         * The following static methods return a boolean value to check a property of a path:
         * • exists
         * • isHidden
         * • isReadable, isWritable, isExecutable
         * • isRegularFile, isDirectory, isSymbolicLink
         * The size method returns the number of bytes in a file.
         * long fileSize = Files.size(path);
         * The getOwner method returns the owner of the file, as an instance of
         * java.nio.file.attribute.UserPrincipal.
         *
         * As you saw in the preceding section, the Files.walk method produces a Stream<Path>
         * that traverses the descendants of a directory. Sometimes, you need more finegrained control over the traversal process. In that case, use the Files.newDirectoryStream
         * object instead. It yields a DirectoryStream. Note that this is not a subinterface of
         * java.util.stream.Stream but an interface that is specialized for directory traversal. It is
         * a subinterface of Iterable so that you can use directory stream in an enhanced for
         * loop. Here is the usage pattern:
         * try (DirectoryStream<Path> entries = Files.newDirectoryStream(dir))
         * {
         *  for (Path entry : entries)
         * Process entries
         * }
         * You can filter the files with a glob pattern:
         * try (DirectoryStream<Path> entries = Files.newDirectoryStream(dir, "*.java"))
         * */

        /**
         * for memory mapping which is the fastest mechanism for file transfer:
         * First, get a channel for the file. A channel is an abstraction for a disk file that lets
         * you access operating system features such as memory mapping, file locking, and
         * fast data transfers between files.
         * FileChannel channel = FileChannel.open(path, options);
         * Then, get a ByteBuffer from the channel by calling the map method of the FileChannel
         * class. Specify the area of the file that you want to map and a mapping mode. Three
         * modes are supported
         * • FileChannel.MapMode.READ_ONLY: The resulting buffer is read-only. Any attempt to
         * write to the buffer results in a ReadOnlyBufferException.
         * • FileChannel.MapMode.READ_WRITE: The resulting buffer is writable, and the changes will
         * be written back to the file at some time. Note that other programs that have
         * mapped the same file might not see those changes immediately. The exact
         * behavior of simultaneous file mapping by multiple programs depends on the
         * operating system.
         * • FileChannel.MapMode.PRIVATE: The resulting buffer is writable, but any changes are
         * private to this buffer and not propagated to the file
         *
         * Once you have the buffer, you can read and write data using the methods of the
         * ByteBuffer class and the Buffer superclass.
         * Buffers support both sequential and random data access. A buffer has a position
         * that is advanced by get and put operations. For example, you can sequentially
         * traverse all bytes in the buffer as
         * while (buffer.hasRemaining())
         * {
         *  byte b = buffer.get();
         *  . . .
         * }
         * Alternatively, you can use random access:
         * for (int i = 0; i < buffer.limit(); i++)
         * {
         *  byte b = buffer.get(i);
         *  . . .
         * }
         *
         * To write numbers to a buffer, use one of the methods
         * putInt
         * putLong
         * putShort
         * putChar
         * putFloat
         * putDouble
         * At some point, and certainly when the channel is closed, these changes are written
         * back to the file.
         *
         * When you use memory mapping, you make a single buffer that spans the entire
         * file or the area of the file that you’re interested in. You can also use buffers to read
         * and write more modest chunks of information.
         * In this section, we briefly describe the basic operations on Buffer objects. A buffer
         * is an array of values of the same type. The Buffer class is an abstract class with
         * concrete subclasses ByteBuffer, CharBuffer, DoubleBuffer, FloatBuffer, IntBuffer, LongBuffer, and
         * ShortBuffer.
         * */

        /**
         * When multiple simultaneously executing programs need to modify the same file,
         * they need to communicate in some way, or the file can easily become damaged.
         * File locks can solve this problem. A file lock controls access to a file or a range of
         * bytes within a file.
         * Suppose your application saves a configuration file with user preferences. If a
         * user invokes two instances of the application, it could happen that both of them
         * want to write the configuration file at the same time. In that situation, the first
         * instance should lock the file. When the second instance finds the file locked, it
         * can decide to wait until the file is unlocked or simply skip the writing process.
         *
         * FileChannel = FileChannel.open(path);
         * FileLock lock = channel.lock();
         * or
         * FileLock lock = channel.tryLock();
         *
         *  void close() 1.7
         * releases this lock.
         * */


        /**
         * Regular Expression (Regex):
         *
         * If you want to match elements in a collection or stream, turn the pattern into a
         * predicate:
         * Stream<String> strings = . . .;
         * Stream<String> result = strings.filter(pattern.asPredicate());
         *
         * The replaceAll method of the Matcher class replaces all occurrences of a regular expression with a replacement string. For example, the following instructions replace
         * all sequences of digits with a # character:
         * Pattern pattern = Pattern.compile("[0-9]+");
         * Matcher matcher = pattern.matcher(input);
         * String output = matcher.replaceAll("#");
         * */


    }
}
