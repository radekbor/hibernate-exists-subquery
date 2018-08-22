package org.radekbor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.io.Serializable;
import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {

    @Query("select e.person from Event e")
    List<Person> findAllWithEvent();

    @Query("select distinct e.person from Event e where e.eventLevel = ?1")
    List<Person> findAllWithEvent(EventLevel info);

    @Query("select p from Person p where not exists (select e.person from Event e where e.person = p)")
    List<Person> findAllWithoutEvent();

    @Query("select p from Person p where not exists (select e.person from Event e where e.person = p and e.eventLevel = ?1)")
    List<Person> findAllWithoutEvent(EventLevel level);

}
