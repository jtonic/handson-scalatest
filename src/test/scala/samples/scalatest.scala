package samples

import org.junit.runner.RunWith
import org.scalatest.{GivenWhenThen, FeatureSpec, FunSuite}
import org.scalatest.junit.JUnitRunner
import org.scalatest.Matchers._

@RunWith(classOf[JUnitRunner])
class SetSuite extends FunSuite {

  test("An empty Set should have size 0") {
    assert(Set.empty.size == 0)
  }

  test("A 3 items Set should have size 3") {
    val list = 2 :: 4 :: 6 :: Nil
    list.size should be(3)
  }

  test("Invoking head on an empty Set should produce NoSuchElementException") {
    intercept[NoSuchElementException] {
      Set.empty.head
    }
  }
}

@RunWith(classOf[JUnitRunner])
class TVSetSpec extends FeatureSpec with GivenWhenThen {

  info(
    """As a TV set owner
      |I want to be able to turn the TV on and off
      |So I can watch TV when I want
      |And save energy when I'm not watching TV
    """.stripMargin)

  feature("TV power button") {
    scenario("User presses power button when TV is off") {
      Given("a TV set that is switched off")
      val tv = new TVSet
      assert(!tv.isOn)

      When("the power button is pressed")
      tv.pressPowerButton()

      Then("the TV should switch on")
      assert(tv.isOn)
    }
  }
}

class SetSpec extends FeatureSpec with GivenWhenThen {
  feature("The scala set type") {
    scenario("empty") {
      Then("the size is empty")
      Set.empty.size should be (0)
    }
  }
}
class StringSpec extends FeatureSpec with GivenWhenThen {
  feature("The scala String type") {
    scenario("startWith feature") {
      Given("It starts with Tony")
      val str = "Tony (a stupid java developer) is super cool!!!"
      Then("the size is empty")
        str should (startWith("Tony") and endWith("cool!!!") and not include "stupid")
    }
  }
}

