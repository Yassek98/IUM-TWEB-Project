package com.twebproject.appfilm.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.twebproject.appfilm.models.Actor;
/**
 * Repository interface for accessing Actor entities from the database.
 */
@Repository
public interface ActorRepository extends JpaRepository<Actor, Integer> {


    /**
     * Finds Actor entities by name containing the specified string, ignoring case.
     *
     * @param name the string to search for in actor names
     * @return a list of Actor entities with names containing the specified string, ignoring case
     */
    List<Actor> findByNameIgnoreCaseContaining(String name);

    /**
     * Finds Actor entities by name containing the specified string, ignoring case using a native query.
     *
     * @param name the string to search for in actor names
     * @return a list of Actor entities with names containing the specified string, ignoring case
     */
    @Query(value = "SELECT * FROM \"Actors\" a WHERE LOWER(a.name) LIKE LOWER(CONCAT('%', :name, '%'))", nativeQuery = true)
    List<Actor> findByNameIgnoreCaseContainingNative(@Param("name") String name);

    /**
     * Finds Actor entities by role containing the specified string, ignoring case.
     *
     * @param role the string to search for in actor roles
     * @return a list of Actor entities with roles containing the specified string
     */
    List<Actor> findByRole(String role);

    @Query("SELECT new Actor(MIN(a.id), a.name) FROM Actor a WHERE lower(a.name) LIKE lower(concat('%', :name, '%')) GROUP BY a.name")
    List<Actor> findUniqueActorsByName(@Param("name") String name);

}