package com.voting.dao;

import com.voting.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CandidateDAO {
    // Display candidates for a specific election
    public void displayCandidates(int electionId) {
        Connection conn = DBConnection.getConnection();
        String sql = "SELECT * FROM candidates WHERE election_id = ?";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, electionId);
            ResultSet rs = stmt.executeQuery();
            System.out.println("Candidates for Election " + electionId + ":");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + ". " + rs.getString("name") + " (" + rs.getString("party") + ")");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Add a new candidate to an election
    public boolean addCandidate(int electionId, String candidateName, String party) {
        Connection conn = DBConnection.getConnection();
        String sql = "INSERT INTO candidates (name, party, election_id) VALUES (?, ?, ?)";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, candidateName);
            stmt.setString(2, party);
            stmt.setInt(3, electionId);

            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0; // Returns true if insertion is successful
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}

