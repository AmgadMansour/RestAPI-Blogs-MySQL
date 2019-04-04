package me.amgad;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog, Integer> {
    // This class is to basically to tell spring to connect to the datatbase, and provide some built in CRUD and retreival functionalities
    // that map to SQL statements
    //Java Persistence API (JPA) has already built functions to query the database similar to ORM concept.
}
