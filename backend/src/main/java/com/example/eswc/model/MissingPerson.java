package com.example.eswc.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class MissingPerson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String age;

    private String gender;

    private String photoUrl;

    private String lastSeenLocation;

    // Constructors, getters, setters

    public MissingPerson() {
    }

    public MissingPerson(String name, String age, String gender, String photoUrl, String lastSeenLocation) {
    this.name = name;
    this.age = age;
    this.gender = gender;
    this.photoUrl = photoUrl;
    this.lastSeenLocation = lastSeenLocation;
}

// Getters and setters
public Long getId() {
    return id;
}

public void setId(Long id) {
    this.id = id;
}

public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

public String getAge() {
    return age;
}

public void setAge(String age) {
    this.age = age;
}

public String getGender() {
    return gender;
}

public void setGender(String gender) {
    this.gender = gender;
}

public String getPhotoUrl() {
    return photoUrl;
}

public void setPhotoUrl(String photoUrl) {
    this.photoUrl = photoUrl;
}

public String getLastSeenLocation() {
    return lastSeenLocation;
}

public void setLastSeenLocation(String lastSeenLocation) {
    this.lastSeenLocation = lastSeenLocation;
}
}
