package ro.jtonic.handson.scalatest;

/**
 * Created by jtonic on 30.08.2014.
 */
public class PersistenceService {

    private PersonDao personDao;

    public PersistenceService(PersonDao personDao) {
        this.personDao = personDao;
    }

    public void savePerson(Person person) {
        this.personDao.save(person);
    }

    public Person findPerson(String ssn) {
        return this.personDao.find(ssn);
    }

    public Person saveAndRetrieve(Person person) {
        this.personDao.save(person);
        return this.personDao.find(person.getSsn());
    }

    public Teacher saveAndRetrieve(Teacher teacher) {
        this.personDao.save(teacher);
        return this.personDao.find(teacher.getId());
    }
}
