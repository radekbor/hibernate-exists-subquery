package org.radekbor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Comparator;

@Entity
@Table(name = "peoples")
public class Person {

    @Id
    private int id;
    private String firstName;
    private String lastName;


    private Person() {

    }

    public Person(int id) {
        this.id = id;
    }

    public Person(int id, String firstName, String lastName) {
        this(id);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Person) {
            Person p2 = (Person) obj;
            return this.id == p2.id &&
                    this.firstName.equals(p2.firstName) &&
                    this.lastName.equals(p2.lastName);
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("Person(%d : %s %s)", id, firstName, lastName);
    }
}
