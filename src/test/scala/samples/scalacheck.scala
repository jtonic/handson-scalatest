import org.junit.runner._
import org.scalatest.junit.JUnitRunner
import org.scalatest.prop.GeneratorDrivenPropertyChecks
import org.scalatest.{FunSpec, GivenWhenThen}
import org.scalatest.Matchers

/**
 * Created by jtonic on 31.08.2014.
 */

@RunWith(classOf[JUnitRunner])
class SimpleMathTest extends FunSpec with Matchers with GivenWhenThen with GeneratorDrivenPropertyChecks {

  describe("We can use test data from Scala check") {
    it("runs the same but with different constructs") {
      forAll ("a", "b") {
        (a: Int, b: Int) => whenever((a > 0 && a < 100) &&  (b > 14 && b < 100)) {
          (a + b) should (be (b + a) and not be < (0))
        }
      }
    }

    /*  property("Simple add check") = Prop.forAll { (a: Int, b: Int) =>
        (a < a + b) :| "a < a + b" &&
        (b < a + b) :| "b < a + b"
      }*/
  }
}
