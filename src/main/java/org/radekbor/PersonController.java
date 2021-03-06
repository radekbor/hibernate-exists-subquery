package org.radekbor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private EventRepository eventRepository;

    @GetMapping("/person")
    public List<Person> getAllPeoples() {
        return personRepository.findAll();
    }

    @GetMapping("/person/with-event")
    public List<Person> getAllPeoplesWithEvents() {
        return personRepository.findAllWithEvent();
    }

    @GetMapping("/person/without-event")
    public List<Person> getAllPeoplesWithoutEvents() {
        return personRepository.findAllWithoutEvent();
    }

    @GetMapping("/event")
    public List<Event> getAllEvent() {
        return eventRepository.findAll();
    }

    @GetMapping("/event/people")
    public List<Person> getAllEventsPeoples() {
        return eventRepository.findAllWithEvent();
    }

}
