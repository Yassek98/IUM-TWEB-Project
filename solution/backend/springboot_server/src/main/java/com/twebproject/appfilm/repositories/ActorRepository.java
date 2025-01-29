package com.twebproject.appfilm.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.twebproject.appfilm.models.filmactors.Actor;
import com.twebproject.appfilm.models.filmactors.ActorId;

/**
 * Repository interface for accessing Actor entities from the database.
 */
@Repository
public interface ActorRepository extends JpaRepository<Actor, ActorId> {

    /**
     * Finds Actor entities by name containing the specified string, ignoring case.
     *
     * @param name the string to search for in actor names
     * @return a list of Actor entities with names containing the specified string
     */
    @Query(value = "SELECT * FROM actors a WHERE LOWER(a.name) LIKE LOWER(CONCAT('%', :name, '%'))", nativeQuery=true) // JPQL query
    List<Actor> findByIdName(@Param("name") String name);
}