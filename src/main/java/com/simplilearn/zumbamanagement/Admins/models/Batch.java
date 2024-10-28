package com.simplilearn.zumbamanagement.Admins.models;

public class Batch {
    private int id;
    private String time;
    private String instructor;
    private int maxParticipants;

    // Constructor
    public Batch(int id, String time, String instructor, int maxParticipants) {
        this.id = id;
        this.time = time;
        this.instructor = instructor;
        this.maxParticipants = maxParticipants;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public int getMaxParticipants() {
        return maxParticipants;
    }

    public void setMaxParticipants(int maxParticipants) {
        this.maxParticipants = maxParticipants;
    }
}
