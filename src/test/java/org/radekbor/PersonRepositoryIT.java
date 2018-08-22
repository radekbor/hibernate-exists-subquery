package org.radekbor;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.logging.Logger;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonRepositoryIT {

    private static final Logger log = Logger.getLogger(PersonRepositoryIT.class.toString());

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private EventRepository eventRepository;

    @Before
    public void setUp() throws Exception {
        List<Event> allEvents = eventRepository.findAll();
        assertThat(allEvents).hasSize(3);

        List<Person> allPersons = personRepository.findAll();
        assertThat(allPersons).hasSize(3);


        allEvents.forEach(
                event -> log.info(String.format("%s %s", event.getPerson(), event))
        );
    }

    @Test
    public void shouldReturnPersonWithoutEvents() {

        // When
        List<Person> allWithoutEvent = eventRepository.findAllWithoutEvent();

        // Then
        assertThat(allWithoutEvent).contains(new Person(3, "Jannet", "Doe"));
        assertThat(allWithoutEvent).doesNotContain(
                new Person(1, "John", "Doe"),
                new Person(2, "Jane", "Doe"));
    }

    @Test
    public void shouldReturnPersonWitEvents() {

        // When
        List<Person> allWithEvent = eventRepository.findAllWithEvent();

        // Then
        assertThat(allWithEvent).contains(
                new Person(1, "John", "Doe"),
                new Person(2, "Jane", "Doe"));
        assertThat(allWithEvent).doesNotContain(new Person(3, "Jannet", "Doe"));

    }

    @Test
    public void shouldReturnPersonWitEventsWithSpecificLevel() {

        // When
        List<Person> allWithEvent = eventRepository.findAllWithEvent(EventLevel.INFO);

        allWithEvent.forEach(person -> System.out.print(person.toString()));
        // Then
        assertThat(allWithEvent).contains(new Person(1, "John", "Doe"));
        assertThat(allWithEvent).doesNotContain(
                new Person(2, "Jane", "Doe"),
                new Person(3, "Jannet", "Doe")

        );
    }

    @Test
    public void shouldReturnPersonWithoutEventsWithSpecificLevel() {

        // When
        List<Person> allWithEvent = eventRepository.findAllWithoutEvent(EventLevel.INFO);

        allWithEvent.forEach(person -> System.out.print(person.toString()));
        // Then
        assertThat(allWithEvent).doesNotContain(new Person(1, "John", "Doe"));
        assertThat(allWithEvent).contains(
                new Person(2, "Jane", "Doe"),
                new Person(3, "Jannet", "Doe")

        );
    }

}