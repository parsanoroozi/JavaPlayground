package volumeII;


import java.awt.image.ImageProducer;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import static volumeII.database.QueryExecution.readQuery;

public class Database {
    /**
     * jdbc (Java DataBase Connectivity)
     *  tip:
     *  JDBC is a standard for Database Access
     *  JPA is a standard for ORM
     *
     * the jdbc idea:
     *  Programs written according to the API
     * talk to the driver manager, which, in turn, uses a driver to talk to the actual
     * database.
     * */

    /**
     * Each host variable in a prepared query is indicated with a ?. If there is more than
     * one variable, you must keep track of the positions of the ? when setting the values.
     * For example, our prepared query becomes
     * String publisherQuery =
     *  "SELECT Books.Price, Books.Title" +
     *  " FROM Books, Publishers" +
     *  " WHERE Books.Publisher_Id = Publishers.Publisher_Id AND Publishers.Name = ?";
     * PreparedStatement stat = conn.prepareStatement(publisherQuery);
     * Before executing the prepared statement, you must bind the host variables to actual values with a set method. As with the get methods of the ResultSet interface,
     * there are different set methods for the various types. Here, we want to set a string
     * to a publisher name.
     * stat.setString(1, publisher);
     * */

    /**
     * CONNECTION POOL
     * The solution is to pool connections. This means that database connections are not
     * physically closed but are kept in a queue and reused. Connection pooling is an
     * important service, and the JDBC specification provides hooks for implementors
     * to supply it. However, the JDK itself does not provide any implementation, and
     * database vendors don’t usually include one with their JDBC drivers either.
     * Instead, vendors of web containers and application servers supply connection
     * pool implementations.
     * Using a connection pool is completely transparent to the programmer. Acquire
     * a connection from a source of pooled connections by obtaining a data source and
     * calling getConnection. When you are done using the connection, call close. That doesn’t
     * close the physical connection but tells the pool that you are done using it. The
     * connection pool typically makes an effort to pool prepared statements as well.
     * */
    public static void main() throws SQLException, IOException {

        String name = "Addison-Wesley";
        String query = "SELECT * FROM books INNER JOIN publishers \n" +
                "ON books.Publisher_Id = publishers.Publisher_Id \n" +
                "WHERE publishers.Name = '"+name+"'";
//        String query = "select * from books";
        ResultSet res = readQuery(query);
        Map<String, Double> books = new HashMap<>();
        while (res.next()){
            books.put(res.getString("Title"), res.getDouble("Price"));
        }
        System.out.println(books.size());
        System.out.println(books);
//        runTest();

    }

    /**
     * To execute a SQL statement, you first create a Statement object. To create
     * statement objects, use the Connection object that you obtained from the call to
     * DriverManager.getConnection.
     * Statement stat = conn.createStatement();
     * Next, place the statement that you want to execute into a string, for example
     * String command = "UPDATE Books"
     *  + " SET Price = Price - 5.00"
     *  + " WHERE Title NOT LIKE '%Introduction%'";
     * Then call the executeUpdate method of the Statement interface:
     * stat.executeUpdate(command);
     *
     * When you execute a query(executeQuery), you are interested in the result. The executeQuery object
     * returns an object of type ResultSet that you can use to walk through the result one
     * row at a time.
     * */

    public static void runTest() throws SQLException, IOException {
        try(Connection con = getConnection();
            Statement stat = con.createStatement()){

            stat.executeUpdate("CREATE TABLE Greetings (Message CHAR(20))");
            stat.executeUpdate("INSERT INTO Greetings VALUES ('Hello World of jdbc')");

            /**
             * When inspecting an individual row, you will want to know the contents of the
             * fields. A large number of accessor methods give you this information.
             * String isbn = rs.getString(1);
             * double price = rs.getDouble("Price");
             * There are accessors for various types, such as getString and getDouble. Each accessor
             * has two forms: One takes a numeric argument and the other takes a string argument. When you supply a numeric argument, you refer to the column with that
             * number. For example, rs.getString(1) returns the value of the first column in the
             * current row.*/
            //CAUTION: Unlike array indexes, database column numbers start at 1.
            try(ResultSet result = stat.executeQuery("SELECT * FROM Greetings")){
                if(result.next()) System.out.println(result.getString(1));
            }
            stat.executeUpdate("DROP TABLE Greetings");
        }
    }
/**
 *  you have to download your database jdbc driver jar file and add it to your application classpath
 *  in intellij you can do it by:
 *  1) first download the jdbc connector for your db and place the jar file somewhere
 *  2) go to your project root directory in the left tab bar and right click on it
 *  3) click on "open module settings"
 *  4) on the left under the "project settings" click on libraries
 *  5) click on the plus sign and choose java for the jar file
 *  6) brows to the location where you installed the jdbc driver jar file and select it
 *  7) apply settings
 * */
    public static Connection getConnection() throws IOException, SQLException {
        Properties props = new Properties();
        try(InputStream in = Files.newInputStream(Paths.get("src/volumeII/database/database.properties"))){
            props.load(in);
        }
        String url= props.getProperty("jdbc.url");
        String username = props.getProperty("jdbc.username");
        String password = props.getProperty("jdbc.password");
        return DriverManager.getConnection(url, username, password);
    }

}
