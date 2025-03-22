package com.example.demo.controller;

import com.example.demo.model.QueueItem;
import com.example.demo.repository.QueueRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/queue")
public class QueueController {

    private final QueueRepository queueRepository;

    public QueueController(QueueRepository queueRepository) {
        this.queueRepository = queueRepository;
    }

    @PostMapping("/add")
    public Map<String, Object> addSongToQueue(@RequestBody QueueItem queueItem) {
        int queuePosition = (int) queueRepository.count() + 1;
        queueItem.setQueuePosition(queuePosition);
        
        queueRepository.save(queueItem);

        // Response
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Song added to queue successfully");
        response.put("queue_position", queuePosition);
        return response;
    }

    @DeleteMapping("/remove")
    public ResponseEntity<Map<String, String>> removeSongFromQueue(@RequestBody Map<String, Integer> request) {
        int songId = request.get("song_id");
        int userId = request.get("user_id");

        queueRepository.deleteBySongIdAndUserId(songId, userId);

        Map<String, String> response = new HashMap<>();
        response.put("message", "Song removed from queue successfully");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/list")
    public ResponseEntity<Map<String, Object>> getQueueList() {
        List<QueueItem> queue = queueRepository.findAllByOrderByQueuePositionAsc();

        Map<String, Object> response = new HashMap<>();
        response.put("queue", queue);
        return ResponseEntity.ok(response);
    }
}