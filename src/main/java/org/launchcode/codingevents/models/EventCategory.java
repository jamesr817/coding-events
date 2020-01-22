package org.launchcode.codingevents.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class EventCategory {

    @Id
    @GeneratedValue
    private int id;

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

    public int getId() {
        return id;
    }

    //TODO: Should there be custom @Override methods like the ones in the Event model class? Why or why not?
}
