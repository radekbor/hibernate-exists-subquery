package org.radekbor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {


    @Query("select p from Person p where exists (select e from Event e where e.person = p)")
    List<Person> findAllWithEvent();

    @Query("select p from Person p where not exists (select e from Event e where e.person = p)")
    List<Person> findAllWithoutEvent();
}
