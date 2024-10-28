package com.simplilearn.zumbamanagement.Admins.service;

import com.simplilearn.zumbamanagement.Admins.DAO.BatchDAO;
import com.simplilearn.zumbamanagement.Admins.models.Batch;

import java.util.List;

public class BatchService {
    private BatchDAO batchDAO;

    public BatchService() {
        this.batchDAO = new BatchDAO();
    }

    // Add a new batch
    public int addBatch(Batch batch) {
        return batchDAO.addBatch(batch);
    }

    // Get a batch by ID
    public Batch getBatch(int id) {
        return batchDAO.getBatchById(id);
    }

    // Update an existing batch
    public int updateBatch(Batch batch) {
        return batchDAO.updateBatch(batch);
    }

    // Delete a batch
    public int deleteBatch(int id) {
        return batchDAO.deleteBatch(id);
    }

    // Get all batches
    public List<Batch> getAllBatches() {
        return batchDAO.getAllBatches();
    }
}
