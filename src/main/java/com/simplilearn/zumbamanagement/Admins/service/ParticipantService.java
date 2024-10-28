package com.simplilearn.zumbamanagement.Admins.service;

import com.simplilearn.zumbamanagement.Admins.DAO.ParticipantDAO;
import com.simplilearn.zumbamanagement.Admins.models.Participant;

import java.util.List;

public class ParticipantService {
    private final ParticipantDAO participantDAO;

    public ParticipantService() {
        this.participantDAO = new ParticipantDAO();
    }

    // Method to add a new participant
    public int addParticipant(String name, String email, String phone, int batchId) {
        Participant newParticipant = new Participant(0, name, email, phone, batchId);
        return participantDAO.addParticipant(newParticipant);
    }

    // Method to get a participant by ID
    public Participant getParticipantById(int id) {
        return participantDAO.getParticipantById(id);
    }

    // Method to update a participant
    public int updateParticipant(int id, String name, String email, String phone, int batchId) {
        Participant updatedParticipant = new Participant(id, name, email, phone, batchId);
        return participantDAO.updateParticipant(updatedParticipant);
    }

    // Method to delete a participant
    public int deleteParticipant(int id) {
        return participantDAO.deleteParticipant(id);
    }

    // Method to get all participants
    public List<Participant> getAllParticipants() {
        return participantDAO.getAllParticipants();
    }
}
