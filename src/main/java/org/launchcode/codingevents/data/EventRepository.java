package org.launchcode.codingevents.data;

import org.launchcode.codingevents.models.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//Spring boot will handle creating a class on the fly in memory to work with this interface
@Repository
public interface EventRepository extends CrudRepository<Event, Integer> {
}
