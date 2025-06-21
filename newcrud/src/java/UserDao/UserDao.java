/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UserDao;

import java.sql.*;
import UserData.User;

/**
 *
 * @author Sarvesh Kumar
 */
public class UserDao {

    public static Connection getConnection() {
        Connection con = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/newcrud", "root", "");
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return con;
    }

    //Save Function
    public static int save(User u) {
        int status = 0;
        try {
            Connection con = getConnection();
            PreparedStatement stmt = con.prepareStatement("INSERT INTO register(name, passwd, email, gender, country) VALUES(?, ?, ?, ?, ?)");
            stmt.setString(1, u.getName());
            stmt.setString(2, u.getPasswd());
            stmt.setString(3, u.getEmail());
            stmt.setString(4, u.getGender());
            stmt.setString(5, u.getCountry());
            status = stmt.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return status;
    }
    
    //Update function
}
