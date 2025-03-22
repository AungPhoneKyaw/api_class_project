package com.example.demo.repository;

import com.example.demo.model.ThemeSetting;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ThemeRepository extends MongoRepository<ThemeSetting, String> {
    Optional<ThemeSetting> findByCrowdLevel(String crowdLevel);
}