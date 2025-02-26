package com.voting.dao;

import com.voting.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ElectionDAO {
    public void displayElections() {
        Connection conn = DBConnection.getConnection();
        String sql = "SELECT * FROM elections";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            System.out.println("Available Elections:");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + ". " + rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public boolean addElection(String name) {
        Connection conn = DBConnection.getConnection();
        String sql = "INSERT INTO elections (name) VALUES (?)";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
