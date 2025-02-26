package com.voting.dao;

import com.voting.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class VoteDAO {
    public void castVote(int userId, int electionId, int candidateId) {
        Connection conn = DBConnection.getConnection();
        String sql = "INSERT INTO votes (user_id, candidate_id, election_id) VALUES (?, ?, ?)";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, userId);
            stmt.setInt(2, candidateId);
            stmt.setInt(3, electionId);
            stmt.executeUpdate();
            System.out.println("Vote Cast Successfully!");
        } catch (SQLException e) {
            System.out.println("You have already voted in this election!");
        }
    }
}
