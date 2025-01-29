package com.twebproject.appfilm.models.filmactors;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;

/**
 * Represents the composite key for the Actor entity.
 */
@Embeddable
public class ActorId implements Serializable {

    private Long id; // Film ID
    private String name; // Actor name
    private String role; // Actor role

    public ActorId() {}

    public ActorId(Long id, String name, String role) {
        this.id = id;
        this.name = name;
        this.role = role;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ActorId that)) return false;
        return Objects.equals(id, that.id)
            && Objects.equals(name, that.name)
            && Objects.equals(role, that.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, role);
    }
}
