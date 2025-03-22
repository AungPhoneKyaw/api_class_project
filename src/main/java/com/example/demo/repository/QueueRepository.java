package com.example.demo.repository;

import com.example.demo.model.QueueItem;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QueueRepository extends MongoRepository<QueueItem, String> {
    long count(); // Gets the number of items in the queue
    void deleteBySongIdAndUserId(int songId, int userId);
    List<QueueItem> findAllByOrderByQueuePositionAsc();
}
