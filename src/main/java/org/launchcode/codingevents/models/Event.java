package org.launchcode.codingevents.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Event extends AbstractEntity {

    @Size(min = 3, max = 50, message = "Name must be between 3-50 characters.")
    @NotBlank(message = "Name required")
    @NotNull(message = "Cannot be null, Try again")
    private String name;

    @Size(max = 600, message = "Description too long, cannot exceed 600 characters.(Spaces included)")
    private String description;

    @NotBlank
    @Email(message = "Invalid email, Try again.")
    private String contactEmail;

    /*Since we've created the EventCategory object, which does the same as our EventType enums, we will no longer need
    the EventType enums class. Enums are very useful, however for this scenario, the EventCategory object offers a
     much more dynamic way to categorize events for the user since it allows the user to create their own categories*/

    //private EventType type;

    //We'll replace the line 28 with this:
    @ManyToOne
    @NotNull(message = "Category is required.")
    private EventCategory eventCategory;
    //Next change out everything in this class for EventType with EventCategory equivalents.

    /*With us adding EventCategory, our goal is to setup a many-to-one relationship in our database.
    Now in any case an Event can fall into multiple categories, but for this web app we'll have it to where an event can
    only fall into one category. This is where the @ManyToOne annotation comes from above the EventCategory field above.
     This is a part of the process to how we establish our Primary to foreign keys relationship within our database.*/

    /*We took out EventType eventType for the parameters of our Event constructor and replaced with it with
    EventCategory eventCategory. Then replaced the eventType getter and setter with eventCategory getter and setter.
     */
    public Event(String name, String description, String contactEmail, EventCategory eventCategory) {
        this.name = name;
        this.description = description;
        this.contactEmail = contactEmail;
        //this.eventType = eventType;
        this.eventCategory= eventCategory;
    }

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

    //*No longer using
    //public EventType getType() {
    //    return type;
    //}

    //*No longer using
    //public void setType(EventType type) {
    //    this.type = type;
    //}


    public EventCategory getEventCategory() {
        return eventCategory;
    }

    public void setEventCategory(EventCategory eventCategory) {
        this.eventCategory = eventCategory;
    }

    @Override
    public String toString() {
        return name;
    }
}

