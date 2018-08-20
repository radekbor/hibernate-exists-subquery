package org.radekbor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Event")
public class Event {

    @Id
    private long id;
    private String log;

    @ManyToOne
    private Person person;

    public Event(long id) {
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
}
