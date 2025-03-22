package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "song_queue")
public class QueueItem {

    @Id
    private String id;
    private int songId;
    private int userId;
    private boolean paymentReceived;
    private String title;
    private String artist;
    private int duration; // Duration in seconds
    private String requestedBy;
    private int queuePosition;

    // ✅ Constructor for adding a song with full details
    public QueueItem(int songId, int userId, boolean paymentReceived, String title, String artist, int duration, String requestedBy, int queuePosition) {
        this.songId = songId;
        this.userId = userId;
        this.paymentReceived = paymentReceived;
        this.title = title;
        this.artist = artist;
        this.duration = duration;
        this.requestedBy = requestedBy;
        this.queuePosition = queuePosition;
    }

    // ✅ Constructor for simpler queue operations
    public QueueItem(int songId, int userId, boolean paymentReceived, int queuePosition) {
        this.songId = songId;
        this.userId = userId;
        this.paymentReceived = paymentReceived;
        this.queuePosition = queuePosition;
    }

    // ✅ Default constructor (required for MongoDB)
    public QueueItem() {
    }

    public String getId() { return id; }
    public int getSongId() { return songId; }
    public int getUserId() { return userId; }
    public boolean isPaymentReceived() { return paymentReceived; }
    public String getTitle() { return title; }
    public String getArtist() { return artist; }
    public int getDuration() { return duration; }
    public String getRequestedBy() { return requestedBy; }
    public int getQueuePosition() { return queuePosition; }

    public void setQueuePosition(int queuePosition) { this.queuePosition = queuePosition; }
}