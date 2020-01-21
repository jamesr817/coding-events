package org.launchcode.codingevents.models;

public enum EventType {
    CONFERENCE("Conference"),
    MEETUP("MeetUp"),
    SOCIAL("Social"),
    WORKSHOP("Workshop");

    //Our constructor
    private final String displayName;

    EventType(String displayName) {
        this.displayName = displayName;
    }


    public String getDisplayName() {
        return displayName;
    }
}
