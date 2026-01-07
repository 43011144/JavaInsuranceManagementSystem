/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.question1project2;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import java.sql.PreparedStatement;


/**
 *
 * @author kgift
 */
public class Customers {

    // Database Connection
    private static final String URL = "jdbc:mysql://localhost:3306/managementsystem";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Inserting data into customer table
    public int insertCustomer(String Name, int Age) {
        int Id = -1;
        String sql = "INSERT INTO Customers(Name, Age) VALUES (?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, Name);
            stmt.setInt(2, Age);  // FIXED: Should insert Age here, not Id
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                Id = rs.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Id;
    }
    //This is an insert policy method
    public void insertPolicy(int customerId, String policyType, double coverageAmount, double premiumAmount) {
    String sql = "INSERT INTO policies (customer_id, policy_type, coverage_amount, premium_amount) VALUES (?, ?, ?, ?)";

    try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, customerId);
        stmt.setString(2, policyType);
        stmt.setDouble(3, coverageAmount);
        stmt.setDouble(4, premiumAmount);
        stmt.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

    // Premium Calculations
    public double calculatePremium(String policyType, double coverageAmount) {
        switch (policyType) {
            case "Life":
                return coverageAmount * 0.05;
            case "Health":
                return coverageAmount * 0.08;
            case "Auto":
                return coverageAmount * 0.10;
            default:
                return 0.0;
        }
    }
}