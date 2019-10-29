/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.springbootswagger2.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
    
    public List getData() {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/uzivatel",
                            "postgres", "postgres");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
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
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Operation done successfully");
        return users;
    }

    public void save(User user) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/uzivatel",
                            "postgres", "postgres");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");
            stmt = c.createStatement();
            String sql = "INSERT INTO Uzivatel(meno,priezvisko,adresa,kontakt,rola,login,heslo)"
                    + "VALUES('Jana', 'Kissova','RV','xyz','admin'+ 'jana'+ 'jana')";

            stmt.executeUpdate(sql);

            stmt.close();
            c.commit();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Records created successfully");
    }

    public void delete(int id) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/uzivatel",
                            "postgres", "postgres");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            String sql = "DELETE from Uzivatel where id=" + id + ";";
            stmt.executeUpdate(sql);
            c.commit();

            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Operation done successfully");
    }

}
