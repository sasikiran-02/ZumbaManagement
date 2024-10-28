package com.simplilearn.zumbamanagement.Admins.DAO;

import com.simplilearn.zumbamanagement.DB.DB;
import com.simplilearn.zumbamanagement.Admins.models.Batch;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BatchDAO {

    private DB db;

    public BatchDAO() {
        db = DB.getDB();
    }

    // Method to add a new batch
    public int addBatch(Batch batch) {
        String sql = "INSERT INTO batches (time, instructor, max_participants) VALUES ('"
                + batch.getTime() + "', '"
                + batch.getInstructor() + "', "
                + batch.getMaxParticipants() + ")";
        return db.executeUpdate(sql);
    }

    // Method to get a batch by ID
    public Batch getBatchById(int id) {
        String sql = "SELECT * FROM batches WHERE id = " + id;
        ResultSet rs = db.executeQuery(sql);
        try {
            if (rs != null && rs.next()) {
                return new Batch(
                        rs.getInt("id"),
                        rs.getString("time"),
                        rs.getString("instructor"),
                        rs.getInt("max_participants")
                );
            }
        } catch (SQLException e) {
            System.out.println("Error fetching batch: " + e.getMessage());
        }
        return null;
    }

    // Method to update a batch
    public int updateBatch(Batch batch) {
        String sql = "UPDATE batches SET "
                + "time = '" + batch.getTime() + "', "
                + "instructor = '" + batch.getInstructor() + "', "
                + "max_participants = " + batch.getMaxParticipants()
                + " WHERE id = " + batch.getId();
        return db.executeUpdate(sql);
    }

    // Method to delete a batch
    public int deleteBatch(int id) {
        String sql = "DELETE FROM batches WHERE id = " + id;
        return db.executeUpdate(sql);
    }

    // Method to get all batches
    public List<Batch> getAllBatches() {
        List<Batch> batches = new ArrayList<>();
        String sql = "SELECT * FROM batches";
        ResultSet rs = db.executeQuery(sql);
        try {
            while (rs != null && rs.next()) {
                batches.add(new Batch(
                        rs.getInt("id"),
                        rs.getString("time"),
                        rs.getString("instructor"),
                        rs.getInt("max_participants")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Error fetching batches: " + e.getMessage());
        }
        return batches;
    }
}
