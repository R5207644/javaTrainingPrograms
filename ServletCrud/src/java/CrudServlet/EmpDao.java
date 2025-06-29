/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CrudServlet;

import java.util.*;
import java.sql.*;

/**
 *
 * @author Sarvesh Kumar
 */
public class EmpDao {

    public static Connection getConnection() {
        Connection con = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_crud", "root", "");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
        return con;
    }

    public static int save(Emp e) {
        int status = 0;
        try {
            Connection con = EmpDao.getConnection();
            PreparedStatement ps = con.prepareStatement("INSERT INTO user905(name, passwd, email, country) values (?, ?, ?, ?)");
            ps.setString(1, e.getName());
            ps.setString(2, e.getPasswd());
            ps.setString(3, e.getEmail());
            ps.setString(4, e.getCountry());

            status = ps.executeUpdate();

            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return status;
    }

    public static int update(Emp e) {
        int status = 0;

        try {
            Connection con = EmpDao.getConnection();

            PreparedStatement ps = con.prepareStatement("UPDATE user905 SET name=?, passwd = ?, email = ?, country = ? WHERE id = ?");
            ps.setString(1, e.getName());
            ps.setString(2, e.getPasswd());
            ps.setString(3, e.getEmail());
            ps.setString(4, e.getCountry());
            ps.setInt(5, e.getId());

            status = ps.executeUpdate();

            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return status;
    }
    
    public static int delete(int id) {
        int status = 0;

        try {
            Connection con = EmpDao.getConnection();

            PreparedStatement ps = con.prepareStatement("DELETE FROM user905 WHERE id = ?");
            ps.setInt(1, id);

            status = ps.executeUpdate();

            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return status;
    }
    
    public static Emp getEmpById(int id) {
        Emp e = new Emp();
        try {
            Connection con = EmpDao.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM user905 WHERE id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                e.setId(rs.getInt(1));
                e.setName(rs.getString(2));
                e.setPasswd(rs.getString(3));
                e.setEmail(rs.getString(4));
                e.setCountry(rs.getString(5));
            }
            
            con.close();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        
        return e;
    }
    
    public static List<Emp> getAllEmployees() {
        List<Emp> list = new ArrayList<Emp>();
        
        try {
            Connection con = EmpDao.getConnection();
            
            PreparedStatement ps = con.prepareStatement("SELECT * FROM user905");
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                Emp e = new Emp();
                e.setId(rs.getInt(1));
                e.setName(rs.getString(2));
                e.setPasswd(rs.getString(3));
                e.setEmail(rs.getString(4));
                e.setCountry(rs.getString(5));
                
                list.add(e);
            }
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        } 
        return list;
    }
    
}
