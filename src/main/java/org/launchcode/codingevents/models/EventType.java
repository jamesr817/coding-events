package org.launchcode.codingevents.models;

public enum EventType {
//Different Types of events to might be store in Coding Events web app. Below are our fields, displayName is in ()
    CONFERENCE("Conference"),
    MEETUP("MeetUp"),
    SOCIAL("Social"),
    WORKSHOP("Workshop");

    //Our constructor
    private final String displayName;

    EventType(String displayName) {
        this.displayName = displayName;
    }

    //Our getter, no need for a setter because this is "final".
    public String getDisplayName() {
        return displayName;
    }
}
