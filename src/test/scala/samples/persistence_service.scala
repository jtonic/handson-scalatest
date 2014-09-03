import org.scalamock.scalatest.MockFactory
import org.scalatest.junit.JUnitRunner
import org.scalatest.{FeatureSpec, GivenWhenThen}
import ro.jtonic.handson.scalatest.{PersistenceService, Person, PersonDao}
import org.junit.runner.RunWith

/**
 * Created by jtonic on 30.08.2014.
 */
@RunWith(classOf[JUnitRunner])
class PersistenceServiceSpec extends FeatureSpec with GivenWhenThen with MockFactory {
  scenario("Save and retrieve a person") {
    Given("A person, a mocked dao and the persistence service")
    val personDao = mock[PersonDao]
    val person: Person = new Person("1112", "Antonel", "Pazargic")

    val service = new PersistenceService(personDao)
    When("have some expectations")
    inSequence {
      (personDao.save _).expects(person).once()
      (personDao.findPerson _).expects(person.getSsn).once()
    }

    Then("Save the person")
    service.saveAndRetrieve(person)
  }
}

