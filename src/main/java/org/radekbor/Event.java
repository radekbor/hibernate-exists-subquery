package org.radekbor;

import javax.persistence.*;

@Entity
@Table(name = "EVENTS")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String log;

    @ManyToOne
    private Person person;

    @Enumerated(EnumType.STRING)
    private EventLevel eventLevel;

    public Event(int id) {
        this.id = id;
    }

    private Event() {

    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }

    public EventLevel getEventLevel() {
        return eventLevel;
    }

    public void setEventLevel(EventLevel eventLevel) {
        this.eventLevel = eventLevel;
    }

    @Override
    public String toString() {
        return String.format("Event(level=%s, log=%s)", this.eventLevel, this.log);
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
