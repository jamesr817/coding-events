package org.launchcode.codingevents.models;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class EventCategory extends AbstractEntity {

    @Size(min = 3, message = "Category name must be between 3-50 characters.")
    @NotBlank(message = "Name for new category is required. Please try again.")
    @NotNull(message = "Field cannot be null.")
    private String name;

    //Starting to set up our one to many relationship
    /*We start by doing just what we did in the Event model class by adding an annotation. Since this is going to be a
    one to many relationship though, we have to use @OneToMany Annotation. We also need to add a parameter to this
    annotation that tells hibernate how to determine which events are in a given category. We do this with the
    "mappedBy" keyword, and in this case we're mapping by eventCategory.- mappedBy = "eventCategory".
    The mappedBy value has to be the name of the field in the class we're storing here that creates this relationship.
    Which is located in the "Events" model class. This now applies a foreign key reference to an event category.
     */
    @OneToMany(mappedBy = "eventCategory")
    private final List<Event> events = new ArrayList<>();

    public EventCategory(String name){
        this.name = name;
    }

    public EventCategory(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //Our getter for our new field, no need to add a setter.
    public List<Event> getEvents() {
        return events;
    }

    @Override
    public String toString() {
        return name;
    }

}
