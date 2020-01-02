package org.launchcode.codingevents.controllers;


import org.launchcode.codingevents.data.EventData;
import org.launchcode.codingevents.models.Event;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("events")
public class EventController {


    @GetMapping
    public String displayAllEvents(Model model) {
        model.addAttribute("title", "All Events");
        model.addAttribute("events", EventData.getAll());
        return "events/index";
    }

    //Lives at /events/create
//    @GetMapping("create")
//    public String renderCreateEventForm(Model model) {
//        model.addAttribute("title", "Create Event");
//        return "events/create";
//    }
    //To help with easily display error messages we've defined to the user:
    @GetMapping("create")
    public String renderCreateEventForm(Model model) {
        model.addAttribute("title", "Create Event");
        model.addAttribute(new Event());
        return "events/create";
    }

    //Lives at /events/create
//    @PostMapping("create")
//    public String processCreateEventForm(@RequestParam String eventName, @RequestParam String eventDescription) {
//        EventData.add(new Event(eventName, eventDescription));
//        return "redirect:";
//    }
    //Refactoring the create function for model-binding
//    @PostMapping("create")
//    public String processCreateEventForm(@ModelAttribute Event newEvent) {
//        EventData.add(newEvent);
//        return "redirect:";
//    }
    //Updating the the above method to check validation rules we've added using @Valid annotation and Errors
    @PostMapping("create")
    public String processCreateEventForm(@ModelAttribute @Valid Event newEvent, Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Create Event");
            //Below line is no longer need with changes made to Event.java model class and refactored HTML with th:field
            //model.addAttribute("errorMsg","Bad Data");//Use this just for now.
            return "events/create";
        }
        EventData.add(newEvent);
        return "redirect:";
    }

    //A handler method to display the form we'll be using to delete items
    @GetMapping("delete")
    public String displayDeleteForm(Model model) {
        model.addAttribute("title","Delete Events");
        model.addAttribute("events",EventData.getAll());
        return "events/delete";

    }

    //Implementing a POST handler for deleting events form
    @PostMapping("delete")
    public String processDeleteEventsForm(@RequestParam(required = false) int[] eventIds) {
        if (eventIds != null) {
            for (int id : eventIds) {
                EventData.remove(id);
            }
        }
        return "redirect:";
    }
}
