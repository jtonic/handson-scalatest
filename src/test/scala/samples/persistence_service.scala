import org.junit.runner.RunWith
import org.scalamock.scalatest.MockFactory
import org.scalatest.junit.JUnitRunner
import org.scalatest.{FeatureSpec, GivenWhenThen}
import ro.jtonic.handson.scalatest.{PersistenceService, PersonDao, Teacher}

/**
 * Created by jtonic on 30.08.2014.
 */
@RunWith(classOf[JUnitRunner])
class PersistenceServiceSpec extends FeatureSpec with GivenWhenThen with MockFactory {
  scenario("Save and retrieve a person") {
    Given("A person, a mocked dao and the persistence service")
    val personDao = mock[PersonDao]
    val teacher = new Teacher("Antonel Pazargic")

    val service = new PersistenceService(personDao)
    When("have some expectations")
    inSequence {
      (personDao.save(_: Teacher)).expects(teacher).once()
      (personDao.find(_: Long)).expects(*).once()
    }

    Then("Save the person")
    service.saveAndRetrieve(teacher)
  }
}

