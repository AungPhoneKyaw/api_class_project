package com.example.demo.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.example.demo.repository.QueueRepository;
import com.example.demo.model.QueueItem;

@Configuration
public class DatabaseInitializer {

    @Bean
    CommandLineRunner initDatabase(QueueRepository queueRepository) {
        return args -> {
            if (queueRepository.count() == 0) {
                queueRepository.save(new QueueItem(
                    1,                    // songId
                    101,                  // userId (required)
                    true,                 // paymentReceived (required)
                    "Pretender",          // title
                    "Official髭男dism",   // artist
                    330,                  // duration
                    "User123",            // requestedBy
                    1                     // queuePosition
                ));                
                System.out.println("🎵 Database & Collection Initialized with Sample Data!");
            }
        };
    }
}