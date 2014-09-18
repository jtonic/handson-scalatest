import org.junit.runner.RunWith
import org.scalamock.scalatest.MockFactory
import org.scalatest.junit.JUnitRunner
import org.scalatest.{FeatureSpec, GivenWhenThen}

/**
 * Created by jtonic on 30.08.2014.
 */

@RunWith(classOf[JUnitRunner])
class PersistenceServiceSpec extends FeatureSpec with GivenWhenThen with MockFactory {

  ignore("Save and retrieve a person") {
    // Uncomment the code below and un-ignore the scenario to reproduce the scalamock issue
    // https://github.com/paulbutcher/ScalaMock/issues/73

/*
    Given("A person, a mocked dao and the persistence service")

    val person = new Person("1112", "Antonel", "Pazargic")
    val teacher = new Teacher(1L, "Antonel Pazargic")

    val service = new PersistenceService(personDao)
    When("have some expectations")
    inAnyOrder {
      (personDao.save(_: Teacher)).expects(teacher).once()
//      (personDao.find(_: Long)).expects(1L).once()
    }

    Then("Save the person")
    service.saveAndRetrieve(teacher)
*/
  }

}

