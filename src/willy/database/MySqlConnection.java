/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package willy.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.JDBCType;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Willy
 */
public class MySqlConnection {

    public static final String LOCALHOST = "jdbc:mysql://localhost:3306/";
    private final Connection con;

    public MySqlConnection(final String URL, final String username, final String password) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        this.con = DriverManager.getConnection(URL, username, password);
    }

    public void disconnect() throws SQLException {
        con.close();
    }

    public ResultSet executeQuery(final String query) throws SQLException {
        PreparedStatement p = con.prepareStatement(query);
        return p.executeQuery();
    }

    public boolean executeUpdate(final String query, final MySqlParam... params) throws SQLException {
        PreparedStatement p = con.prepareStatement(query);
        int i = 0;
        for (MySqlParam param : params) {
            i++;
            p.setObject(i, param.getValue(), param.getType());
        }
        return p.execute();
    }

    public ResultSet executeQuery(final String query, final MySqlParam... params) throws SQLException {
        PreparedStatement p = con.prepareStatement(query);
        int i = 0;
        for (MySqlParam param : params) {
            i++;
            p.setObject(i, param.getValue(), param.getType());
        }
        return p.executeQuery();
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        MySqlConnection s = new MySqlConnection(LOCALHOST + "LibraryBD", "root", "n0m3l0");
        int a;
        ResultSet rs = s.executeQuery("SELECT\n"
                + "	`Library`.`lbk_id`  AS `LibraryID`,\n"
                + "	`Book`.`bok_id`     AS `BookID`,\n"
                + "	`Book`.`bok_nam`    AS `Name`,\n"
                + "	`Book`.`bok_psh`    AS `Publisher`,\n"
                + "	`Author`.`ath_nam`  AS `Author`,\n"
                + "	`Library`.`lbk_edt` AS `Edition`,\n"
                + "	`Library`.`lbk_tot` AS `Total`,\n"
                + "	`Library`.`lbk_brd` AS `Borrowed`\n"
                + "FROM\n"
                + "	`Library`, `Book`, `Author`, `BookAuthor`\n"
                + "WHERE\n"
                + "	`Library`.`lbk_bok` = `Book`.`bok_id` AND\n"
                + "	`BookAuthor`.`bok_id` = `Book`.`bok_id` AND\n"
                + "	`BookAuthor`.`ath_id` = `Author`.`ath_id` AND\n"
                + "	(\n"
                + "		LOCATE(?, `Book`.`bok_nam`) != 0 OR\n"
                + "		LOCATE(?, `Author`.`ath_nam`) != 0\n"
                + "	);", new MySqlParam(JDBCType.VARCHAR, "Resnick"), new MySqlParam(JDBCType.VARCHAR, "Resnick"));
        while (rs.next()) {
            System.out.println(String.format(
                    "The LibraryID is %d, with the book %d: %s, %s, %s, %s. We have %d, and %d borrowed",
                    rs.getInt("LibraryID"),
                    rs.getInt("BookID"),
                    rs.getString("Name"),
                    rs.getString("Publisher"),
                    rs.getString("Author"),
                    rs.getString("Edition"),
                    rs.getInt("Total"),
                    rs.getInt("Borrowed")
            ));
        }
    }

}
