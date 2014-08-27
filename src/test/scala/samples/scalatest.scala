package samples

import org.junit.runner.RunWith
import org.scalatest.{GivenWhenThen, FeatureSpec, FunSuite}
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class SetSuite extends FunSuite {

  test("An empty Set should have size 0") {
    assert(Set.empty.size == 0)
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

