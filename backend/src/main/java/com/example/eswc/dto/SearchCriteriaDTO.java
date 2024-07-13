package com.example.eswc.dto;

public class SearchCriteriaDTO {

    private String name;

    private String gender;

    private String lastSeenLocation;

    // Constructors, getters, setters

    public SearchCriteriaDTO() {
    }

    public SearchCriteriaDTO(String name, String gender, String lastSeenLocation) {
    this.name = name;
    this.gender = gender;
    this.lastSeenLocation = lastSeenLocation;
}

// Getters and setters
public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

public String getGender() {
    return gender;
}

public void setGender(String gender) {
    this.gender = gender;
}

public String getLastSeenLocation() {
    return lastSeenLocation;
}

public void setLastSeenLocation(String lastSeenLocation) {
    this.lastSeenLocation = lastSeenLocation;
}
}
