package com.simplilearn.zumbamanagement.Admins.DAO;

import com.simplilearn.zumbamanagement.DB.DB;
import com.simplilearn.zumbamanagement.Admins.models.Participant;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ParticipantDAO {

    private DB db;

    public ParticipantDAO() {
        db = DB.getDB();
    }

    // Method to add a new participant
    public int addParticipant(Participant participant) {
        String sql = "INSERT INTO participants (name, email, phone, batch_id) VALUES ('"
                + participant.getName() + "', '"
                + participant.getEmail() + "', '"
                + participant.getPhone() + "', "
                + participant.getBatchId() + ")";
        return db.executeUpdate(sql);
    }

    // Method to get a participant by ID
    public Participant getParticipantById(int id) {
        String sql = "SELECT * FROM participants WHERE id = " + id;
        ResultSet rs = db.executeQuery(sql);
        try {
            if (rs != null && rs.next()) {
                return new Participant(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("phone"),
                        rs.getInt("batch_id")  // Change here
                );
            }
        } catch (SQLException e) {
            System.out.println("Error fetching participant: " + e.getMessage());
        }
        return null;
    }

    // Method to update a participant
    public int updateParticipant(Participant participant) {
        String sql = "UPDATE participants SET "
                + "name = '" + participant.getName() + "', "
                + "email = '" + participant.getEmail() + "', "
                + "phone = '" + participant.getPhone() + "', "
                + "batch_id = " + participant.getBatchId()  // Change here
                + " WHERE id = " + participant.getId();
        return db.executeUpdate(sql);
    }

    // Method to delete a participant
    public int deleteParticipant(int id) {
        String sql = "DELETE FROM participants WHERE id = " + id;
        return db.executeUpdate(sql);
    }

    // Method to get all participants
    public List<Participant> getAllParticipants() {
        List<Participant> participants = new ArrayList<>();
        String sql = "SELECT * FROM participants";
        ResultSet rs = db.executeQuery(sql);
        try {
            while (rs != null && rs.next()) {
                participants.add(new Participant(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("phone"),
                        rs.getInt("batch_id")  // Change here
                ));
            }
        } catch (SQLException e) {
            System.out.println("Error fetching participants: " + e.getMessage());
        }
        return participants;
    }
}
