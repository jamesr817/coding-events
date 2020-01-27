package org.launchcode.codingevents.models;


import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Objects;

//@MapperSuperClass is referred to as a persistence annotation
//This says that the fields in this class should be push down into the tables for the objects that extends it.
@MappedSuperclass
public abstract class AbstractEntity {

    @Id
    @GeneratedValue
    private int id;

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractEntity that = (AbstractEntity) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
