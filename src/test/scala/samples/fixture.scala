import org.scalatest.{Outcome, GivenWhenThen, fixture}

import scala.collection.mutable._

/**
 * Created by jtonic on 30.08.2014.
 */

class FixtureBasedSpec extends fixture.FeatureSpec with GivenWhenThen {

  override type FixtureParam = Stack[Int]
  override protected def withFixture(test: OneArgTest): Outcome = {
    val stack = new Stack[Int]
    stack.push(1)
    stack.push(2)
    test(stack)
  }

  feature("Pushing a value onto a stack") {
    scenario(f"User pushes a value to stack") { stack =>
      Given(f"Initially the stack size is ${stack.size}")
      val st = stack

      When(f"Pushing a nine ${st.size}")
        st.push(9)

      Then(f"The size is ${st.size + 1}")
        assert(st.size === 3)
    }
  }

}