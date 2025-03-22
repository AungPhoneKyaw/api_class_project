package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "theme_settings")
public class ThemeSetting {

    @Id
    private String id;
    private String theme; // e.g., "party", "chill", "romantic"
    private String crowdLevel; // e.g., "low", "medium", "high"
    private int limit; // Number of recommendations

    public ThemeSetting(String theme, String crowdLevel, int limit) {
        this.theme = theme;
        this.crowdLevel = crowdLevel;
        this.limit = limit;
    }

    // Getters and Setters
    public String getId() { return id; }
    public String getTheme() { return theme; }
    public String getCrowdLevel() { return crowdLevel; }
    public int getLimit() { return limit; }

    public void setTheme(String theme) { this.theme = theme; }
    public void setCrowdLevel(String crowdLevel) { this.crowdLevel = crowdLevel; }
    public void setLimit(int limit) { this.limit = limit; }
}