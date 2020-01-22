package org.launchcode.codingevents.data;

import org.launchcode.codingevents.models.Event;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/*Originally this was used to extract data management code out of our controller. This was also used to mimic the
the data layer (creating, reading, deleting events). We won't be using this for long, since we'll be using a Repository
Interface to handle what this class did. Refer to EventsRepository in the "data" folder. To keep as a visual reference
we'll comment out this whole class, instead of deleting
 */
//public class EventData {
//
//    //need a place to put events
//    private static final Map<Integer, Event> events= new HashMap<>();
//
//    //get all events
//    public static Collection<Event> getAll(){
//        return events.values();
//    }
//
//    //get a single event
//    public static Event getById(int id) {
//        return events.get(id);
//
//    }
//
//    //add an event
//    public static void add(Event event) {
//        events.put(event.getId(), event);
//    }
//
//    //remove an event
//    public static void remove(int id) {
//        events.remove(id);
//    }
//}
