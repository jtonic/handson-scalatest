package ro.jtonic.handson.scalatest;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by jtonic on 30.08.2014.
 */
public class PersonDao {

    private final Set<Person> persons = new HashSet<>();

    public void save(Person person){
        persons.add(person);
    }

    public Person findPerson(String ssn) {
        while (persons.iterator().hasNext()) {
            Person person = persons.iterator().next();
            if (person.getSsn().equalsIgnoreCase(ssn)) {
                return person;
            }
        }
        throw new IllegalArgumentException("Not found!!!");
    }
}
