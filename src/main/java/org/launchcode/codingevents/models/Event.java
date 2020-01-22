package org.launchcode.codingevents.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

//Indicating that this Class/model is a persistent object. @Entity annotation
@Entity
public class Event {

    //Indicating id as a primary key
    @Id
    @GeneratedValue
    private int id;

    //The field below is no longer needed.
   //private static int nextId = 1;


    @Size(min = 3, max = 50, message = "Name must be between 3-50 characters.")
    @NotBlank(message = "Name required")
    @NotNull(message = "Cannot be null, Try again")
    private String name;

    @Size(max = 600, message = "Description too long, cannot exceed 600 characters.(Spaces included)")
    private String description;

    @NotBlank
    @Email(message = "Invalid email, Try again.")
    private String contactEmail;

    private EventType type;

    public Event(String name, String description, String contactEmail, EventType type) {
        //this();//Also no longer needed
        this.name = name;
        this.description = description;
        this.contactEmail = contactEmail;
        this.type= type;
    }

    /*This is our second constructor (empty constructor) used with the JPA. Because it should be empty and we no longer
    need the nextId we'll comment it out, and recreate an empty version of this constructor under it. This was we can
    see what we did and how we did it later if we need a reference.
     */
    //public Event() {
        //this.id = nextId;
        //nextId++;
    //}
    public Event() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    //Adding getter and setters for EventType
    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return id == event.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

