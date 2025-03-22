package com.example.demo.controller;

import com.example.demo.model.ThemeSetting;
import com.example.demo.repository.ThemeRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/theme")
public class ThemeController {

    private final ThemeRepository themeRepository;

    public ThemeController(ThemeRepository themeRepository) {
        this.themeRepository = themeRepository;
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> updateTheme(@RequestBody Map<String, Object> request) {
        String newTheme = (String) request.get("theme");
        String crowdLevel = (String) request.get("crowd_level");
        int limit = (int) request.get("limit");

        // Find existing theme setting for the crowd level
        Optional<ThemeSetting> existingTheme = themeRepository.findByCrowdLevel(crowdLevel);

        if (existingTheme.isPresent()) {
            ThemeSetting themeSetting = existingTheme.get();
            themeSetting.setTheme(newTheme);
            themeSetting.setLimit(limit);
            themeRepository.save(themeSetting);
        } else {
            themeRepository.save(new ThemeSetting(newTheme, crowdLevel, limit));
        }

        // Prepare response
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Theme updated successfully");
        response.put("updated_theme", newTheme);
        response.put("crowd_level", crowdLevel);
        response.put("limit", limit);

        return ResponseEntity.ok(response);
    }
}