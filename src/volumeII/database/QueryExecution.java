package volumeII.database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static volumeII.Database.getConnection;

public class QueryExecution {

    /**
     * The queries involving authors are complex. A book can have multiple authors,
     * so the BooksAuthors table stores the correspondence between authors and books.
     * For example, the book with ISBN 0-201-96426-0 has two authors with codes
     * DATE and DARW. The BooksAuthors table has the rows
     * 0-201-96426-0, DATE, 1
     * 0-201-96426-0, DARW, 2
     * to indicate this fact. The third column lists the order of the authors. (We can’t
     * just use the position of the rows in the table. There is no fixed row ordering
     * in a relational table.) Thus, the query has to join the Books, BooksAuthors, and Authors
     * tables to compare the author name with the one selected by the user.
     * SELECT Books.Price, Books.Title FROM Books, BooksAuthors, Authors, Publishers
     * WHERE Authors.Author_Id = BooksAuthors.Author_Id AND BooksAuthors.ISBN = Books.ISBN
     * AND Books.Publisher_Id = Publishers.Publisher_Id AND Authors.Name = ? AND Publishers.Name = ?
     * */

    /** rule of thumb: If you can do it in SQL, don’t do it in Java*/

    /**
     * The changePrices method executes an UPDATE statement. Note that the WHERE clause
     * of the UPDATE statement needs the publisher code and we know only the publisher
     * name. This problem is solved with a nested subquery:
     * UPDATE Books
     * SET Price = Price + ?
     * WHERE Books.Publisher_Id = (SELECT Publisher_Id FROM Publishers WHERE Name = ?)
     * */
    public static int writeQuery(String query) throws SQLException, IOException {

        try(Connection con = getConnection();
            Statement stat = con.createStatement()){
            return stat.executeUpdate(query);
        }
    }

    public static ResultSet readQuery(String query) throws SQLException, IOException {

        try(Connection con = getConnection();
            Statement stat = con.createStatement()){
            return stat.executeQuery(query);
        }
    }
}
