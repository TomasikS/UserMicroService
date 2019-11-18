/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.springbootswagger2.model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 *
 * @author stefan.tomasik
 */
public class Database {

    User uzivatel;
    List<User> users = new ArrayList();
    String s1;
    String s2;
    String s3;
    String s4;
    String s5;
    String s7;
    String s8;
    
    
      public Connection createConnection() throws SQLException, ClassNotFoundException, FileNotFoundException, IOException {
        Connection connection;
        Properties properties = new Properties();
        properties.load(new java.io.FileInputStream("C://Users//stefan.tomasik//Documents//NetBeansProjects//spring-boot-swagger2//spring-boot-swagger2//src//main//resources//application.properties"));
        String url = properties.getProperty("host");
        String user = properties.getProperty("username");;
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");
        Class.forName(driver);

        connection = DriverManager.getConnection(url, user, password);
        return connection;
    }
    
    public List getData() {
        Connection connection = null;
        Statement stmt = null;
        try {
           // Class.forName("org.postgresql.Driver");
            //connection = DriverManager
                   // .getConnection("jdbc:postgresql://localhost:5432/uzivatel",
                      ///      "postgres", "postgres");
                      
            connection =  createConnection();      
            connection.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM uzivatel;");
            while (rs.next()) {

                s1 = rs.getString(2);
                s2 = rs.getString(3);
                s3 = rs.getString(4);
                s4 = rs.getString(5);
                s5 = rs.getString(6);
                s5 = rs.getString(7);
                s5 = rs.getString(8);

            }
            User u = new User(s1, s2, s3, s4, s5,s7,s8);
            users.add(u);
            rs.close();
            stmt.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Operation done successfully");
        return users;
    }

    public void save(User user) {
        Connection connection = null;
        Statement stmt = null;
        try {
           // Class.forName("org.postgresql.Driver");
           // connection = DriverManager
            //        .getConnection("jdbc:postgresql://localhost:5432/uzivatel",
            //                "postgres", "postgres");
            
            connection =  createConnection();  
            connection.setAutoCommit(false);
            System.out.println("Opened database successfully");
            stmt = connection.createStatement();
            String sql = "INSERT INTO Uzivatel(meno,priezvisko,adresa,kontakt,rola,login,heslo)"
                    + "VALUES('Jana', 'Kissova','RV','xyz','admin'+ 'jana'+ 'jana')";

            stmt.executeUpdate(sql);

            stmt.close();
            connection.commit();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Records created successfully");
    }

    public void delete(int id) {
        Connection connection = null;
        Statement stmt = null;
        try {
            //Class.forName("org.postgresql.Driver");
          //  connection = DriverManager
             //       .getConnection("jdbc:postgresql://localhost:5432/uzivatel",
                  ///          "postgres", "postgres");
                  
            connection =  createConnection();        
            connection.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = connection.createStatement();
            String sql = "DELETE from Uzivatel where id=" + id + ";";
            stmt.executeUpdate(sql);
            connection.commit();

            stmt.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Operation done successfully");
    }

}
