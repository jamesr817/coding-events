package org.launchcode.codingevents.models;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class EventCategory extends AbstractEntity {

    @Size(min = 3, message = "Category name must be between 3-50 characters.")
    @NotBlank(message = "Name for new category is required. Please try again.")
    @NotNull(message = "Field cannot be null.")
    private String name;

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

    @Override
    public String toString() {
        return name;
    }

}
